package com.ssafy.myboard.board.model.dao;

import java.util.List;

import com.ssafy.myboard.board.model.Board;
import com.ssafy.myboard.board.model.BoardFile;
import com.ssafy.myboard.board.model.BoardSearch;

/** 게시물 처리 인터페이스 */
public interface BoardDao {
	
	/** 게시물 목록 데이터 */
	List<Board> selectBoard(BoardSearch boardSearch);

	/** 게시물 페이징 처리를 위한 전체 데이터 카운트 */
//	<select id="selectBoardCount" resultType="int" parameterType="boardSearch">
	int selectBoardCount(BoardSearch boardSearch);
	
	void insertBoard(Board board);

	void insertBoardFile(BoardFile boardFile);

	Board selectBoardByNo(int no);

	BoardFile selectBoardFileByNo(int no);
}
