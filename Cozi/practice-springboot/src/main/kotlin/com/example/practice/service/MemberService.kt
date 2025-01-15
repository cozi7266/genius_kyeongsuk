package com.example.practice.service

import com.example.practice.model.Member
import com.example.practice.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(private val memberRepository: MemberRepository) {

    //회원 추가
    fun saveMember(member: Member): Member {
        return memberRepository.save(member)
    }

    // 모든 회원 조회
    fun getAllMembers(): List<Member> {
        return memberRepository.findAll()
    }

    // 특정 회원 조회
    fun getMemberById(id: Long): Member? {
        return memberRepository.findById(id).orElse(null)
    }

    // 회원 수정
    fun updateMember(id: Long, newMember: Member): Member {
        val member = memberRepository.findById(id).orElseThrow { IllegalArgumentException("회원이 없습니다.") }
        member.name = newMember.name
        return memberRepository.save(member)
    }

    // 회원 삭제
    fun deleteMember(id: Long) {
        memberRepository.deleteById(id)
    }
}