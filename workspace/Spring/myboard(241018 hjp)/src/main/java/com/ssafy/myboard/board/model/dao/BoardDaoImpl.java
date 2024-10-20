package com.ssafy.myboard.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.myboard.board.model.dto.Board;
import com.ssafy.myboard.board.model.dto.BoardFile;
import com.ssafy.myboard.util.DBUtil;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	private DBUtil db;
	public BoardDaoImpl() {
		db = DBUtil.getInstance();
	}
	
	@Override
	public List<Board> selectBoard() throws SQLException {
		try(
				Connection con = db.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
					"""
					SELECT no, title, writer, view_cnt, reg_date
					FROM board	
					ORDER BY no DESC
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
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setRegDate(rs.getString("reg_date"));
				list.add(board);
			}
			return list;
		}
	}

	@Override
	public Board selectBoardByNo(int no) throws SQLException {
		String sql = "SELECT title, writer, content, view_cnt, reg_date FROM board WHERE no = ?";
		try(
				Connection con = db.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
		) {
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			Board board = null;
			if(rs.next()) {
				board = new Board();
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setRegDate(rs.getString("reg_date"));
			}
			return board;
		}
	}
	
	@Override
	public void insertBoard(Board board) throws SQLException {
		String sql = "INSERT INTO board(title, writer, content) VALUES(?, ?, ?)";
		try(
				Connection con = db.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			) {
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.executeUpdate();
			
			String sql2 = "SELECT last_insert_id() AS lastno FROM dual;";
			try(
					PreparedStatement pstmt2 = con.prepareStatement(sql2);
					ResultSet rs = pstmt2.executeQuery();
				) {
				
				if(rs.next()) {
					board.setNo(rs.getInt("lastno"));
					
				}
			}
		}
		
	}

	@Override
	public void insertBoardFile(BoardFile boardFile) throws SQLException {
		String sql = "INSERT INTO board_file(file_path, ori_name, system_name, no) VALUES(?, ?, ?, ?)";
		try(
				Connection con = db.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			) {
			pstmt.setString(1, boardFile.getFilePath());
			pstmt.setString(2, boardFile.getOriName());
			pstmt.setString(3, boardFile.getSystemName());
			pstmt.setInt(4, boardFile.getNo());
			pstmt.executeUpdate();
		}
		
	}

	@Override
	public BoardFile selectBoardFileByNo(int no) throws SQLException {
		String sql = "SELECT file_path, ori_name, system_name FROM board_file WHERE no = ?";
		try(
				Connection con = db.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
		) {
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			BoardFile boardFile = null;
			if(rs.next()) {
				boardFile = new BoardFile();
				boardFile.setFilePath(rs.getString("file_path"));
				boardFile.setOriName(rs.getString("ori_name"));
				boardFile.setSystemName(rs.getString("system_name"));
			}
			return boardFile;
		}
	}
	
}
