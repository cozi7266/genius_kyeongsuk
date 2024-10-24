package com.ssafy.myboard.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.myboard.board.model.Idol;
import com.ssafy.myboard.board.model.dao.IdolDao;

@Service
public class IdolServiceImpl implements IdolService {
	private final IdolDao idolDao;
	
	public IdolServiceImpl(IdolDao idolDao) {
		this.idolDao = idolDao;
	}

	@Override
	public List<Idol> list() {
		return idolDao.selectIdol();
	}

	@Override
	public Idol detail(int no) {
		return idolDao.selectIdolByPk(no);
	}

	@Override
	public void remove(int no) {
		idolDao.deleteIdol(no);
	}

	@Override
	public void regist(Idol idol) {
		idolDao.insertIdol(idol);
	}

	@Override
	public void modify(Idol idol) {
		idolDao.updateIdol(idol);
		
	}
}
