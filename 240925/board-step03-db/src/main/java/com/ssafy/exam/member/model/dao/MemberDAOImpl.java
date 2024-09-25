package com.ssafy.exam.member.model.dao;

import java.util.HashMap;
import java.util.Map;

import com.ssafy.exam.member.model.dto.Member;

public class MemberDAOImpl implements MemberDAO {
	// 회원 정보 관리 데이터베이스(메모리)
	private Map<String, Member> memberMap = new HashMap<>();
	private static MemberDAO instance = new MemberDAOImpl(); 
	private MemberDAOImpl() {}
	public static MemberDAO getInstance() {
		return instance;
	}
	
	@Override
	public void insertMember(Member member) {
		memberMap.put(member.getId(), member);
	}
	
	@Override
	public Member selectMember(Member member) {
		Member m = memberMap.get(member.getId());
		if (m != null && member.getPassword().equals(m.getPassword())) {
			return m;
		}
		return null;
	}
}





