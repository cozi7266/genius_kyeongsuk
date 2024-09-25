package com.ssafy.exam.member.model.dao;

import com.ssafy.exam.member.model.dto.Member;

public interface MemberDAO {

	void insertMember(Member member);

	Member selectMember(Member member);

}