package com.ssafy.myboard.board.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.myboard.board.model.dao.BoardDao;
import com.ssafy.myboard.board.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDao boardDao;
    public BoardServiceImpl(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @Override
    public List<Board> list() throws SQLException {
        return boardDao.selectBoard();
    }

	@Override
	public void update(Board board) throws SQLException {
		boardDao.insertBoard(board);
	}

	

	
}
