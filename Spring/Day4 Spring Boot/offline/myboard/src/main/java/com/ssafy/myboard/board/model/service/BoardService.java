package com.ssafy.myboard.board.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.myboard.board.model.dto.Board;

public interface BoardService {
	List<Board> list() throws SQLException;
	void update(Board board) throws SQLException;
}
