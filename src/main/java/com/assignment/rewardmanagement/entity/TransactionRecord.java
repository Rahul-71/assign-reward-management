package com.assignment.rewardmanagement.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class TransactionRecord {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int transactionId;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;
    private double amount;
    private LocalDateTime transactionDate;
}
