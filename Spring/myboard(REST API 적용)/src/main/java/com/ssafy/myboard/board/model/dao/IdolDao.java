package com.ssafy.myboard.board.model.dao;

import java.util.List;

import com.ssafy.myboard.board.model.Idol;

public interface IdolDao {
	List<Idol> selectIdol();
	Idol selectIdolByPk(int no);
	void deleteIdol(int no);
	void insertIdol(Idol idol);
	void updateIdol(Idol idol);
}


