package com.ssafy.exam;

import java.util.HashMap;
import java.util.Map;

public class MemberDAO {
	// 회원 정보 관리 데이터베이스(메모리)
	private Map<String, Member> memberMap = new HashMap<>();
	private static MemberDAO instance = new MemberDAO(); 
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public void insertMember(Member member) {
		memberMap.put(member.getId(), member);
	}
	
	public Member selectMember(Member member) {
		Member m = memberMap.get(member.getId());
		if (m != null && member.getPassword().equals(m.getPassword())) {
			return m;
		}
		return null;
	}
}





