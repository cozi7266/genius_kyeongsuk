package com.ssafy.myboard.board.model;

public class Idol {
	private int no;
	private String name;
	private String gender;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "idol [no=" + no + ", name=" + name + ", gender=" + gender + "]";
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * use examdb;
	 * 
	 * CREATE table idol ( no int AUTO_INCREMENT, name VARCHAR(30) not null, gender
	 * CHAR(1) not null, PRIMARY KEY(no) );
	 * 
	 * insert into idol(name, gender) values ('로제', 'F'), ('차은우', 'M');
	 * 
	 * 
	 * 
	 * 
	 * select * from idol;
	 * 
	 * 
	 */
}
