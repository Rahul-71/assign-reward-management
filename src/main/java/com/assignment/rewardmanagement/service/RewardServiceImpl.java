package com.assignment.rewardmanagement.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.rewardmanagement.entity.Customer;
import com.assignment.rewardmanagement.entity.Reward;
import com.assignment.rewardmanagement.entity.TransactionRecord;
import com.assignment.rewardmanagement.repository.CustomerRepository;
import com.assignment.rewardmanagement.repository.TransactionRecordRepository;

@Service
public class RewardServiceImpl implements RewardService {

    private final CustomerRepository customerRepository;
    private final TransactionRecordRepository transactionRecordRepository;

    @Autowired
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
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));

        List<TransactionRecord> transactions = transactionRecordRepository.findByCustomer(customer);
        // get trnsaction for last 3 months
        transactions = transactions.stream().filter(t -> t.getTransactionDate().isAfter(LocalDateTime.now().minusMonths(3))).toList();

        // calculate monthwise reward        
        transactions.stream().collect(
            Collectors.groupingBy(
                t -> t.getTransactionDate().getMonth(), 
                Collectors.summingInt(t -> calculateRewards(t.getAmount()))
            )
        );

        return null;
    }

    private int calculateRewards(double amount) {
        
        throw new UnsupportedOperationException("Unimplemented method 'calculateRewards'");
    }

}
