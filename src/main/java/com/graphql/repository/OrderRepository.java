package com.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
