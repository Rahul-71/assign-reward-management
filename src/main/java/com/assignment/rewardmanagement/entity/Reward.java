package com.assignment.rewardmanagement.entity;

import lombok.Data;

@Data
public class Reward {
    private int customerId;
    private int monthlyRewardPoints;
    private int totalRewardPoints;   
}
