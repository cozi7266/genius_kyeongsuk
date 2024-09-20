package com.ssafy.exam;

import java.util.ArrayList;
import java.util.List;

// CRUD
/*
 * 데이터베이스 처리 기준
 * 
 * R : selectBoard(전체)
 *   : selectBoardByPK(하나조회)
 * C : insertBoard  
 * U : updateBoard  
 * D : deleteBoard  
 */
public class BoardDAO {
	// 게시글 번호
	private static int boardNo;
	private static BoardDAO instance = new BoardDAO();
	private BoardDAO() {}
	public static BoardDAO getInstance() {
		return instance;
	}
	
	private List<Board> boardList = new ArrayList<>();
	public void insertBoard(Board board) {
		board.setNo(++boardNo);
		boardList.add(board);
	}
	
	public List<Board> selectBoard() {
		return boardList;
	}
}





