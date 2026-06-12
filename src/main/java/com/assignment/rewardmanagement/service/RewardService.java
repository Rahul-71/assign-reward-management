package com.assignment.rewardmanagement.service;

import com.assignment.rewardmanagement.entity.Reward;

public interface RewardService {
    Reward getRewardPointsForCustomer(int customerId);
}
