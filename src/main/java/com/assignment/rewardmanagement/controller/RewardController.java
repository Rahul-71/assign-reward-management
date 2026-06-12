package com.assignment.rewardmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.rewardmanagement.entity.Reward;
import com.assignment.rewardmanagement.service.RewardService;

@RestController
@RequestMapping("/rewards")
public class RewardController {

    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Reward> getRewardPoints(@PathVariable int customerId) {
        return ResponseEntity.ok(rewardService.getRewardPointsForCustomer(customerId));
    }
}
