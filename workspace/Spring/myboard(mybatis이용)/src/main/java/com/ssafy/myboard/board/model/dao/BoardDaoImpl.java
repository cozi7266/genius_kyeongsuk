package com.ssafy.myboard.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.ssafy.myboard.board.model.dto.Board;
import com.ssafy.myboard.board.model.dto.BoardFile;
import com.ssafy.myboard.config.MyBatisConfig;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	private final String NS = "com.ssafy.myboard.board.model.dao.BoardDao.";
	
	private SqlSessionFactory sqlFactory;
	public BoardDaoImpl() {
		sqlFactory = MyBatisConfig.getFactory();
	}
	
	@Override
	public List<Board> selectBoard() {
		try(SqlSession sqlSession = sqlFactory.openSession(true)){
			List<Board> list = sqlSession.selectList(NS +"selectBoard");
			return list;
		}
	}
	
	@Override
	public void insertBoard(Board board) {
		try(SqlSession sqlSession = sqlFactory.openSession(true)){
			sqlSession.insert(NS + "insertBoard", board);
			sqlSession.commit();
		}
	}
	
	@Override
	public void insertBoardFile(BoardFile boardFile)  {
		try(SqlSession sqlSession = sqlFactory.openSession(true)){
			sqlSession.insert(NS + "insertBoardFile", boardFile);
			sqlSession.commit();
		}
		
	}

	@Override
	public Board selectBoardByNo(int no) {
		try(SqlSession sqlSession = sqlFactory.openSession(true)){
			return sqlSession.selectOne(NS + "selectBoardByNo", no);
		}
	}
	


	@Override
	public BoardFile selectBoardFileByNo(int no)  {
		try(SqlSession sqlSession = sqlFactory.openSession(true)){
			return sqlSession.selectOne(NS + "selectBoardFileByNo", no);
		}
     }
}