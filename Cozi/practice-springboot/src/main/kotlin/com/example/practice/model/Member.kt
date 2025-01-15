package com.example.practice.model

import jakarta.persistence.*

@Entity
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var name: String,


    @OneToOne(mappedBy = "member", cascade = [CascadeType.ALL])
    val profile: Profile? = null,

    @OneToMany(mappedBy = "member", cascade = [CascadeType.ALL])
    val orders: List<Order> = mutableListOf()
)

