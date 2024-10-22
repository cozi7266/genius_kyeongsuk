package com.ssafy.myboard.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.myboard.board.model.Board;
import com.ssafy.myboard.board.model.BoardFile;
import com.ssafy.myboard.board.model.BoardSearch;
import com.ssafy.myboard.board.model.dao.BoardDao;
import com.ssafy.util.PageResult;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDao boardDao;
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	/** 
	 * 게시판 목록에 필요한 데이터 조회
	 */
	@Override
	public Map<String, Object> list(BoardSearch boardSearch) {
		Map<String, Object> result = new HashMap<>();
		result.put("list", boardDao.selectBoard(boardSearch));
		result.put("pr", new PageResult(
								boardSearch.getPage(), 
								boardDao.selectBoardCount(boardSearch), 
								boardSearch.getListSize()
						 )
		);
		return result;
	}

	@Override
	public void writeBoard(Board board) throws Exception {
		boardDao.insertBoard(board);  // 게시글 번호가 auto_increment에 의해서 자동 생성
		BoardFile boardFile = board.getBoardFile(); // 게시글 번호가 없는 상태임
		if (boardFile != null) {
			boardFile.setNo(board.getNo());
			boardDao.insertBoardFile(boardFile);
		}
	}

	@Override
	public Board detailBoard(int no) throws Exception {
		Board board = boardDao.selectBoardByNo(no);
		board.setBoardFile(boardDao.selectBoardFileByNo(no));
		return board;
	}

}










