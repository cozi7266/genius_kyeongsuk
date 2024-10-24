package com.ssafy.myboard.board.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.myboard.board.model.Board;
import com.ssafy.myboard.board.model.BoardFile;
import com.ssafy.myboard.board.model.BoardSearch;
import com.ssafy.myboard.board.model.service.BoardService;

//@CrossOrigin("*")
@Controller
@RequestMapping("/board")
public class BoardController {
	private final BoardService boardService;
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	// /list?page=3&listSize=5
	@GetMapping("/list")
	public void list(BoardSearch boardSearch, Model model) {
		Map<String, Object> result = boardService.list(boardSearch);
		model.addAttribute("list", result.get("list"));
		model.addAttribute("pr", result.get("pr"));
	}
	
	@GetMapping("/detail")
	public void detail(@RequestParam("no") int no, Model model) throws Exception {
		model.addAttribute("board", boardService.detailBoard(no));
	}

	// 글쓰기 폼 이동
	@GetMapping("/write")
	public void writeForm() {}
	
	@PostMapping("/write")
	public String write(@RequestParam("attach") MultipartFile attach, Board board) throws Exception {
		// 사용자가 업로드한 파일 이름
		String oriName = attach.getOriginalFilename();
		if (oriName.length() > 0) {  // 사용자가 파일을 선택한 경우
			// 서버의 특정 디렉토리에 저장
			String subDir = new SimpleDateFormat("/yyyy/MM/dd/HH").format(new Date());
			File dir = new File("c:/SSAFY/uploads" + subDir);
			dir.mkdirs();
			String systemName = UUID.randomUUID().toString() + oriName;
			attach.transferTo(new File(dir, systemName));  // 메모리의 파일 정보를 특정 위치에 저장
			
			// 데이터베이스에 저장하기 위한 준비
			BoardFile boardFile = new BoardFile();
			boardFile.setFilePath(subDir);
			boardFile.setOriName(oriName);
			boardFile.setSystemName(systemName);
			board.setBoardFile(boardFile);
		}
		boardService.writeBoard(board);
		return "redirect:/board/list";
	}
}









































