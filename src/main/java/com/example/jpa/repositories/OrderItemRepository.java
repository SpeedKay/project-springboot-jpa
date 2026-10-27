package com.example.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entities.OrderItem;
import com.example.jpa.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
