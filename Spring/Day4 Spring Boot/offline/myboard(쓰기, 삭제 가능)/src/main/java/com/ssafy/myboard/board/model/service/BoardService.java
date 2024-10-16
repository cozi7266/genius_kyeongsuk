package com.ssafy.myboard.board.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.myboard.board.model.dto.Board;

public interface BoardService {
	List<Board> list() throws SQLException;
	void write(Board board) throws SQLException;
	Board detail(int no) throws SQLException;
	void delete(int no) throws SQLException;
}
