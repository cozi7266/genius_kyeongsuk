package com.ssafy.exam.board.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.exam.board.model.dao.BoardDAO;
import com.ssafy.exam.board.model.dao.BoardDAOImpl;
import com.ssafy.exam.board.model.dto.Board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 *  action 파리미터의 값으로 각각의 동작을 구분
 *  등록폼	: writeForm
 *  등록	: write
 *  목록	: list
 *  삭제 : delete
 *  수정폼 : updateForm
 *  수정 : update
 *  상세조회 : detail
 */
@WebServlet("/board")
public class BoardController extends HttpServlet {

	private BoardDAO boardDao;
	public BoardController() {
		boardDao = BoardDAOImpl.getInstance();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if ("list".equals(action)) {
			// 목록 페이지
			list(req, resp);
		} else if ("writeForm".equals(action)) {
			// 등록폼 페이지 이동하자...
			writeForm(req, resp);
		} else if ("write".equals(action)) {
			// 등록 처리하자...
			write(req, resp);
		} else if ("detail".equals(action)) { // 게시글 상세정보
			detail(req, resp);
		} else if ("delete".equals(action)) { // 게시글 삭제
			delete(req, resp);
		}
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		// 삭제할 게시글 번호 가져오기
		int no = Integer.parseInt(req.getParameter("no"));
		try {
			boardDao.deleteBoard(no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath() + "/board?action=list");
	}

	private void detail(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// 조회할 게시글 번호 가져오기
		int no = Integer.parseInt(req.getParameter("no"));
		// 조회수 증가
		try {
			boardDao.updateViewCnt(no);
			// 게시글 조회
			Board board = boardDao.selectBoardByNo(no);
			req.setAttribute("board", board);
			RequestDispatcher rd = req.getRequestDispatcher("/board/detail.jsp");
			rd.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// 화면에 보여줄 데이터를 준비한다.
		List<Board> list = null;
		try {
			list = boardDao.selectBoard();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// req 같이 볼 수 있는 영역에 올리자(공유영역)
		req.setAttribute("list", list);
		
		// 화면 페이지로 이동한다.(list.jsp)
		RequestDispatcher rd = req.getRequestDispatcher("/board/list.jsp");
		rd.forward(req, resp);
	}
	private void write(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// 등록할 데이터를 파라미터에서 꺼낸다.
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		try {
			boardDao.insertBoard(board);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 등록한다.
		// http://localhost/board-step01-mvc/board     
		// 목록 페이지로 이동한다.(목록에 필요한 데이터를 준비하는 서블릿으로 이동)
//		RequestDispatcher rd = req.getRequestDispatcher("/board?action=list");
//		rd.forward(req, resp);
		
		resp.sendRedirect(req.getContextPath() + "/board?action=list");
	}
	private void writeForm(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// 등록 페이지로 이동한다.
		RequestDispatcher rd = req.getRequestDispatcher("/board/write.jsp");
		rd.forward(req, resp);
	}
	
}








