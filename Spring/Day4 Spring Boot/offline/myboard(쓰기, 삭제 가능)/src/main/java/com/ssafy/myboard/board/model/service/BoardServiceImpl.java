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
    public void write(Board board) throws SQLException {
        boardDao.insertBoard(board);
    }

    @Override
    public Board detail(int no) throws SQLException {
        return boardDao.selectBoardByNo(no);
    }

    @Override
    public void delete(int no) throws SQLException {
        boardDao.deleteBoardByNo(no);
    }
}

