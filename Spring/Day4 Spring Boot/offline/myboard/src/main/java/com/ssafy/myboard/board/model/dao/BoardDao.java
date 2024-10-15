package com.ssafy.myboard.board.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.myboard.board.model.dto.Board;

public interface BoardDao {
	List<Board> selectBoard() throws SQLException;
	void insertBoard(Board board) throws SQLException;
}
