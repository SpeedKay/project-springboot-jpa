package com.example.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	
}
