package com.ssafy.myboard.board.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.myboard.board.model.dto.Board;
import com.ssafy.myboard.board.model.dto.BoardFile;

public interface BoardDao {
	List<Board> selectBoard();

	void insertBoard(Board board);

	Board selectBoardByNo(int no);

	void insertBoardFile(BoardFile boardFile);

	BoardFile selectBoardFileByNo(int no);
}
