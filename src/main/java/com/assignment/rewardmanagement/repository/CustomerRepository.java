package com.assignment.rewardmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.rewardmanagement.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
}
