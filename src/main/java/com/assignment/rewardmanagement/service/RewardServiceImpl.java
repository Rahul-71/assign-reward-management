package com.assignment.rewardmanagement.service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.assignment.rewardmanagement.entity.Customer;
import com.assignment.rewardmanagement.entity.Reward;
import com.assignment.rewardmanagement.entity.TransactionRecord;
import com.assignment.rewardmanagement.repository.CustomerRepository;
import com.assignment.rewardmanagement.repository.TransactionRecordRepository;

@Service
public class RewardServiceImpl implements RewardService {

    private final CustomerRepository customerRepository;
    private final TransactionRecordRepository transactionRecordRepository;

    public RewardServiceImpl(CustomerRepository customerRepository,
            TransactionRecordRepository transactionRecordRepository) {
        this.customerRepository = customerRepository;
        this.transactionRecordRepository = transactionRecordRepository;
    }

    @Override
    public Reward getRewardPointsForCustomer(int customerId) {
        if (customerRepository == null || transactionRecordRepository == null) {
            return null;
        }
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));

        List<TransactionRecord> transactions = transactionRecordRepository.findByCustomer(customer);
        // get trnsaction for last 3 months
        transactions = transactions.stream()
                .filter(
                        t -> t.getTransactionDate().isAfter(LocalDateTime.now().minusMonths(3))
                ).toList();

        // calculate monthwise reward        
        Map<Month, Integer> monthwiseRewards = transactions.stream().collect(
                Collectors.groupingBy(
                        t -> t.getTransactionDate().getMonth(),
                        Collectors.summingInt(t -> calculateRewards(t.getAmount()))
                )
        );

        Reward reward = new Reward();
        reward.setCustomerId(customerId);
        reward.setCustomerName(customer.getName());
        reward.setMonthlyRewardPoints(monthwiseRewards);
        reward.setTotalRewardPoints(monthwiseRewards.values().stream().mapToInt(Integer::intValue).sum());
        return reward;
    }

    /*
    A customer receives 2 points for every dollar spent over $100 in each transaction, 
    plus 1 point for every dollar spent between $50 and $100 in each transaction.
    (e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
     */
    private int calculateRewards(double amount) {
        if (amount > 100) {
            return (int) (2 * (amount - 100) + 50);
        } else if (amount > 50) {
            return (int) (amount - 50);
        } else {
            return 0;
        }
    }

}
