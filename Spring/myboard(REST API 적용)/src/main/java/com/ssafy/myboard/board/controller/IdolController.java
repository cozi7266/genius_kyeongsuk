package com.ssafy.myboard.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myboard.board.model.Idol;
import com.ssafy.myboard.board.model.service.IdolService;

//REST
//GET : 조회
///board/list     ->     GET         /board
///board/detail   ->     GET         /board/100 
///board/write    ->     POST        /board       {"name" : "홍길동", "gender" : "F"}
///board/update   ->     PUT, PATCH  /board/100   {"no" : 100, "name" : "홍길동", "gender" : "F"}
///board/delete   ->     DELETE      /board/100

//@Controller
@RestController
@RequestMapping("/idol")
public class IdolController {
	private final IdolService idolService;

	public IdolController(IdolService idolService) {
		this.idolService = idolService;
	}

	/*
	 * 응답 시작라인(200 HTTP/1.1 OK) 헤더 키:값 키:값 빈줄~~ 바디
	 * 
	 * 
	 * 200 HTTP/1.1 OK a: 1 b: 1 c: 2
	 * 
	 * d: 3
	 * 
	 * 
	 * JSON 맵 : {} DTO : {} LIST, 배열 : []
	 * 
	 * 
	 * 
	 * [{}, {}]
	 */
	@GetMapping
//	@ResponseBody
	public List<Idol> list() {
		// list 데이터를 브라우저에서 사용하도록 문자열로 변환해서 전송해줘야 한다.
		// 객체를 반환하면 객체의 내용을 JSON으로 자동 변환 : JACKSON
		List<Idol> list = idolService.list();
		return list;
	}

	// /idol/76
	@GetMapping("{no}")
//	@ResponseBody
	public Idol detail(@PathVariable("no") int no) {
//	public Idol detail(@PathVariable int no){
		return idolService.detail(no);
	}

	// /idol/100
	@DeleteMapping("{no}")
	public void delete(@PathVariable int no) {
		idolService.remove(no);
	}

	// 등록
	@PostMapping
	public void regist(@RequestBody Idol idol) {
		idolService.regist(idol);
	}

	// 수정
	@PutMapping("{no}")
	public void modify(@RequestBody Idol idol) {
		idolService.modify(idol);
	}

}
