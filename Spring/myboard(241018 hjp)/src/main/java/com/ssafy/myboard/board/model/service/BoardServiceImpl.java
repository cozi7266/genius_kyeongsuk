package com.ssafy.myboard.board.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.myboard.board.model.dao.BoardDao;
import com.ssafy.myboard.board.model.dto.Board;
import com.ssafy.myboard.board.model.dto.BoardFile;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDao boardDao;
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public List<Board> list() throws Exception {
		return boardDao.selectBoard();
	}
	
	@Override
	public void write(Board board) throws SQLException {
		boardDao.insertBoard(board);
		BoardFile boardFile = board.getBoardFile(); // 게시글 번호가 없는 상태
		boardFile.setNo(board.getNo());
		boardDao.insertBoardFile(boardFile);
	}
	
	@Override
	public Board detail(int no) throws SQLException {
		Board board = boardDao.selectBoardByNo(no);
		board.setBoardFile(boardDao.selectBoardFileByNo(no));
		return board;
	}

}
