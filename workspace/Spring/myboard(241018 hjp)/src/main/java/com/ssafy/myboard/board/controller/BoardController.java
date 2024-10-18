package com.ssafy.myboard.board.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.myboard.board.model.dto.Board;
import com.ssafy.myboard.board.model.dto.BoardFile;
import com.ssafy.myboard.board.model.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	// 생성자 자동 주입
	private final BoardService boardService;
	
	private ResourceLoader resourceLoader;
	
	public BoardController(BoardService boardService, ResourceLoader resourceLoader) {
		this.boardService = boardService;
		this.resourceLoader = resourceLoader;
	}
	
	@GetMapping("/list")
	public void list(Model model) throws Exception {
		model.addAttribute("list", boardService.list());
	}
	
	// 글쓰기 폼 이동
	@GetMapping("/write")
	public String writeForm() {
		return "/board/write";
	}
	
	@PostMapping("/write")
	public String write(@RequestParam("attach") MultipartFile attach, Board board) throws SQLException, IllegalStateException, IOException {
		
		// 사용자가 업로드한 파일 이름
		String oriName = attach.getOriginalFilename();
		if(oriName.length() > 0) { // 사용자가 파일을 선택한 경우
			String subDir = new SimpleDateFormat("/yyyy/MM/dd/HH").format(new Date()); // 현재 날짜를 가져오기(업로드 시간으로 구별하여 디렉토리 나눔)
//			File dir = new File("C:/SSAFY/uploads" + subDir); // 디렉토리 주소를 나타내는 File 객체 생성
			
			Resource resource = resourceLoader.getResource("classpath:/static/img");
			
			File dir = new File(resource.getFile() + subDir);
			dir.mkdirs(); // 디렉토리가 없다면 만드는 메서드
			String systemName = UUID.randomUUID().toString() + oriName;
			File file = new File(dir, systemName); // 디렉토리에 해당하는 fileName을 가진 파일 객체 생성
			attach.transferTo(file); //  메모리의 파일 정보를 특정 위치에 저장
		
			// 데이터베이스에 저장하기 위한 준비과정(DB에 파일 저장을 위한 테이블과 dto 클래스 생성)
			BoardFile boardFile = new BoardFile();
			boardFile.setFilePath(subDir);
			boardFile.setOriName(oriName);
			boardFile.setSystemName(systemName);
			board.setBoardFile(boardFile);
		}
		
		boardService.write(board);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam int no, Model model) throws SQLException {
		model.addAttribute("board", boardService.detail(no));
		return "/board/detail";
	}
	
	@GetMapping("/download")
	public String download(BoardFile boardFile, Model model) {
		model.addAttribute("filePath", boardFile.getFilePath());
		model.addAttribute("systemName", boardFile.getSystemName());
		return "fileDownloadView";
	}
}
