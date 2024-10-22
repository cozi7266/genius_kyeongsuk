package com.ssafy.myboard.board.model.service;

import java.util.Map;

import com.ssafy.myboard.board.model.Board;
import com.ssafy.myboard.board.model.BoardSearch;

public interface BoardService {
	Map<String, Object> list(BoardSearch boardSearch);

	void writeBoard(Board board) throws Exception;

	Board detailBoard(int no) throws Exception;
}
