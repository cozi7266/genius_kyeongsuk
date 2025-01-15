package com.example.practice.service

import com.example.practice.model.Member
import com.example.practice.model.Order
import com.example.practice.repository.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService(
    private val orderRepository: OrderRepository
) {

    @Transactional
    fun saveOrder(order: Order): Order {
        return orderRepository.save(order)
    }

    @Transactional
    fun findOrderByMember(member: Member): List<Order> {
        return orderRepository.findByMember(member)
    }

    fun getOrderById(id: Long): Order? {
        return orderRepository.findById(id).orElse(null)
    }

    fun getAllOrders(): List<Order> {
        return orderRepository.findAll()
    }


}