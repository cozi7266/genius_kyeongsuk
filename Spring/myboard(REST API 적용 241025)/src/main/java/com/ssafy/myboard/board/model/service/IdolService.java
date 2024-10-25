package com.ssafy.myboard.board.model.service;

import java.util.List;

import com.ssafy.myboard.board.model.Idol;

public interface IdolService {
	List<Idol> list();
	Idol detail(int no);
	void remove(int no);
	void regist(Idol idol);
	void modify(Idol idol);
	
	
	
}
