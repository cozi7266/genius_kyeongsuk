package com.ssafy.myboard.board.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.myboard.board.model.dto.Board;
import com.ssafy.myboard.board.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public void list(Model model) throws Exception {
        model.addAttribute("list", boardService.list());
    }

    @GetMapping("/write")
    public String writeForm() {
        return "/board/writeForm";
    }

    @PostMapping("/write")
    public String write(Board board) throws SQLException {
        boardService.write(board);
        return "redirect:/board/list";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("no") int no, Model model) throws SQLException {

        Board board = boardService.detail(no);
        
        if (board == null) {
            System.out.println("해당 게시글이 없음");
            return "redirect:/board/list";  
        }

        
        model.addAttribute("board", board);
        return "/board/detail";
    }


   
    @PostMapping("/delete")
    public String delete(@RequestParam(value = "no", required = false, defaultValue = "-1") int no) throws SQLException {
    
        boardService.delete(no);  // 삭제 수행
        return "redirect:/board/list";
    }





}
