package com.assignment.rewardmanagement.entity;

import java.time.Month;
import java.util.Map;

import lombok.Data;

@Data
public class Reward {
    private int customerId;
    private String customerName;
    private Map<Month, Integer> monthlyRewardPoints;
    private int totalRewardPoints;   
}
