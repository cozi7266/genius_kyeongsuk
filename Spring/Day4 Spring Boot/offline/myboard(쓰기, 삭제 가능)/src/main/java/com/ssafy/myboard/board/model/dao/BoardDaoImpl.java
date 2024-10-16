package com.ssafy.myboard.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.myboard.board.model.dto.Board;
import com.ssafy.myboard.util.DBUtil;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	private DBUtil db;
	public BoardDaoImpl() {
		db = DBUtil.getInstance();
	}
	
	@Override
	public List<Board> selectBoard() throws SQLException {
		try (
			Connection con = db.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"""
					SELECT no, title, writer, content, view_cnt, reg_date
						from board
					 order by no desc
					"""
				);
		) { 
			List<Board> list = new ArrayList<>();
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setRegDate(rs.getString("reg_date"));
				list.add(board);
				
			}
			return list;
		}
	}

	@Override
	public void insertBoard(Board board) throws SQLException {
	    String sql = """
	        INSERT INTO board (title, writer, content) 
	        VALUES (?, ?, ?)
	    """;

	    try (
	        Connection con = db.getConnection();
	        PreparedStatement pstmt = con.prepareStatement(sql);
	    ) {
	        pstmt.setString(1, board.getTitle());
	        pstmt.setString(2, board.getWriter());
	        pstmt.setString(3, board.getContent());
	        pstmt.executeUpdate();
	    }
	}
	
	@Override
	public Board selectBoardByNo(int no) throws SQLException {
	    String sql = "SELECT no, title, writer, content, view_cnt, reg_date FROM board WHERE no = ?";
	    
	    try (
	        Connection con = db.getConnection();
	        PreparedStatement pstmt = con.prepareStatement(sql);
	    ) {
	        pstmt.setInt(1, no);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            Board board = new Board();
	            board.setNo(rs.getInt("no")); 
	            board.setTitle(rs.getString("title"));
	            board.setWriter(rs.getString("writer"));
	            board.setContent(rs.getString("content"));
	            board.setViewCnt(rs.getInt("view_cnt"));
	            board.setRegDate(rs.getString("reg_date"));
	            return board;  
	        } else {
	            return null;
	        }
	    }
	}


	@Override
	public void deleteBoardByNo(int no) throws SQLException {
	    String sql = "DELETE FROM board WHERE no = ?";
	    try (
	        Connection con = db.getConnection();
	        PreparedStatement pstmt = con.prepareStatement(sql);
	    ) {
	        pstmt.setInt(1, no);
	        int result = pstmt.executeUpdate(); 
	    }
	}
}
