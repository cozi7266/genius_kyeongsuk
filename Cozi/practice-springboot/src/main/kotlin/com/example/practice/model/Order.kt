package com.example.practice.model

import jakarta.persistence.*

@Entity
@Table(name = "orders") // 테이블 이름을 "orders"로 변경
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val product: String,

    val quantity: Int,

    @ManyToOne
    @JoinColumn(name = "member_id")
    val member: Member
)
