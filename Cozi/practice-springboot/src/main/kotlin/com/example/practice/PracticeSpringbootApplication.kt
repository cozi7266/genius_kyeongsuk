package com.example.practice

import com.example.practice.model.Member
import com.example.practice.model.Order
import com.example.practice.service.MemberService
import com.example.practice.service.OrderService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class PracticeSpringbootApplication {

    @Bean
    fun run(memberService: MemberService, orderService: OrderService) = CommandLineRunner {
        val member = Member(name = "John Doe")
        val order1 = Order(product = "Laptop", quantity = 1, member = member)
        val order2 = Order(product = "Phone", quantity = 2, member = member)

        memberService.saveMember(member)
        orderService.saveOrder(order1)
        orderService.saveOrder(order2)

        val orders = orderService.findOrderByMember(member)
        println("orders for ${member.name} ")
        orders.forEach {
            println("- ${it.product}: ${it.quantity}")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<PracticeSpringbootApplication>(*args)
}
