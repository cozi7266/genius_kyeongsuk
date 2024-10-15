package com.ssafy.myboard.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.myboard.board.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	private final BoardService boardService;
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
//	@GetMapping("/list")
//	public String list(Model model) {
//		return "board/list";
//	}
	
	@GetMapping("/list")
	public void list(Model model) throws Exception {
//		List<Board> list = boardService.list();
//		model.addAttribute("list", list);
		
		// boardService.list()이 한 번만 쓰이기 때문에
		model.addAttribute("list", boardService.list());
	}
	
	@GetMapping("/register")
	public void register(Model model) throws Exception {
		model.addAttribute("register", boardService.update(board));
	}
}
