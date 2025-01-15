package com.example.practice.repository

import com.example.practice.model.Member
import com.example.practice.model.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, Long> {
    fun findByMember(member: Member): MutableList<Order>
}