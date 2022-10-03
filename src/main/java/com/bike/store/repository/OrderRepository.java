package com.bike.store.repository;

import com.bike.store.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
