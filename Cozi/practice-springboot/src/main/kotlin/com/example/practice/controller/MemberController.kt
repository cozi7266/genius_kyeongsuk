package com.example.practice.controller

import com.example.practice.model.Member
import com.example.practice.service.MemberService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/members")
class MemberController(private val memberService: MemberService) {

    // 회원 추가
    @PostMapping
    fun addMember(@RequestBody member : Member): ResponseEntity<Member> {
        val savedMember = memberService.saveMember(member)
        return ResponseEntity.ok(savedMember)
    }

    // 모든 회원 조회
    @GetMapping
    fun getAllMembers(): ResponseEntity<List<Member>> {
        val members = memberService.getAllMembers()
        return ResponseEntity.ok(members)
    }

    // 특정 회원 조히
    @GetMapping("/{id}")
    fun getMemberById(@PathVariable id: Long): Member? {
        return memberService.getMemberById(id)
    }

    // 회원 수정
    @PutMapping("/{id}")
    fun updateMember(@PathVariable id: Long, @RequestBody member: Member): ResponseEntity<Member> {
        val updatedMember = memberService.updateMember(id, member)
        return ResponseEntity.ok(updatedMember)
    }


    // 회원 삭제
    @DeleteMapping("/{id}")
    fun deleteMember(@PathVariable id: Long): ResponseEntity<Void> {
        memberService.deleteMember(id)
        return ResponseEntity.noContent().build()
    }

}

