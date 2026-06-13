package com.assignment.rewardmanagement.service;

import java.util.List;

import com.assignment.rewardmanagement.entity.Reward;

public interface RewardService {
    Reward getRewardPointsForCustomer(int customerId);
    List<Reward> getAllCustomerRewards();
}
