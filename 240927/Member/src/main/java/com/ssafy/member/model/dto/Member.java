package com.ssafy.member.model.dto;

import java.io.Serializable;

public class Member implements Serializable {
	private static final long serialVersionUTD = 1L;
	
	private String id;
	private String password;
	private String name;
	private String nickname;
	private String addrNum;
	private String addrBasic;
	private String addrDetail;
	public Member() {}
	
	public Member(String id, String password, String name, String nickname, String addrNum, String addrBasic,
			String addrDetail) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.addrNum = addrNum;
		this.addrBasic = addrBasic;
		this.addrDetail = addrDetail;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAddrNum() {
		return addrNum;
	}
	public void setAddrNum(String addrNum) {
		this.addrNum = addrNum;
	}
	public String getAddrBasic() {
		return addrBasic;
	}
	public void setAddrBasic(String addrBasic) {
		this.addrBasic = addrBasic;
	}
	public String getAddrDetail() {
		return addrDetail;
	}
	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}
	public static long getSerialversionutd() {
		return serialVersionUTD;
	}
	@Override
	public String toString() {
		return "SignUp [id=" + id + ", password=" + password + ", name=" + name + ", nickname=" + nickname
				+ ", addrNum=" + addrNum + ", addrBasic=" + addrBasic + ", addrDetail=" + addrDetail + "]";
	}
	
	
}
