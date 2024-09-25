package com.ssafy.exam.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// ctrl + shift + O
import java.util.ArrayList;
import java.util.List;

import com.ssafy.exam.board.model.dto.Board;
import com.ssafy.exam.util.DBUtil;

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
public class BoardDAOImpl implements BoardDAO {
	
	public static void main(String[] args) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		Connection con = dbUtil.getConnection();
		System.out.println(con);
	}
	
	
	// 게시글 번호
	private static int boardNo;
	private static BoardDAO instance = new BoardDAOImpl();
	private BoardDAOImpl() {}
	public static BoardDAO getInstance() {
		return instance;
	}
	
	private List<Board> boardList = new ArrayList<>();
	@Override
	public void insertBoard(Board board) {
		board.setNo(++boardNo);
		boardList.add(board);
	}
	
	@Override
	public List<Board> selectBoard() throws SQLException {
		List<Board> list = new ArrayList<>();
		
		DBUtil dbUtil = DBUtil.getInstance();
		// 데이터베이스 연결하기
		Connection con = dbUtil.getConnection();
		// 실행할 SQL 문 작성
		String sql = "select no, title, writer, view_cnt from board order by no desc";
		// SQL문을 실행할 객체를 얻어온다.
		PreparedStatement pstmt = con.prepareStatement(sql);
		// SQL문 실행하기 : select(executeQuery), select절 이외(executeUpdate)
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			int viewCnt = rs.getInt("view_cnt");
			Board board = new Board();
			board.setNo(no);
			board.setTitle(title);
			board.setWriter(writer);
			board.setViewCnt(viewCnt);
			list.add(board);
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public Board selectBoardByNo(int no) {
		for (Board b : boardList) {
			if (b.getNo() == no) return b;
		}
		return null;
	}
	@Override
	public void deleteBoard(int no) {
		for (Board b : boardList) {
			if (b.getNo() == no) {
				boardList.remove(b);
				return;
			}
		}
	}
	
	@Override
	public void updateViewCnt(int no) {
		for (Board b : boardList) {
			if (b.getNo() == no) {
				b.setViewCnt(b.getViewCnt() + 1);
				return;
			}
		}
	}
}








