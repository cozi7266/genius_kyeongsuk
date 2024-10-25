package com.ssafy.myboard.board.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myboard.board.model.Idol;
import com.ssafy.myboard.board.model.service.IdolService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

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
@Tag(name = "IdolController(아이돌 관리 컨트롤러)" 
, description = "아이돌 정보를 처리하는 컨트롤러 입니다.")
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
	@Operation(
				summary = "아이돌 전체 목록 조회",
				description = "모든 아이돌 목록을 반환합니다.",
				responses = {
					@ApiResponse(responseCode = "200", description = "조회 성공"),	
					@ApiResponse(responseCode = "204", description = "조회된 데이터가 없음"),	
					@ApiResponse(responseCode = "500", description = "서버 실행시 에러"),	
				}
			)
	public ResponseEntity<?> list() {
////	public List<Idol> list() {
		// 응답 코드 : 200
		// 응답 바디 : List<Idol>

//	public Map<String, Object> list() {
		// list 데이터를 브라우저에서 사용하도록 문자열로 변환해서 전송해줘야 한다.
		// 객체를 반환하면 객체의 내용을 JSON으로 자동 변환 : JACKSON

		/*
		 * 1000 : 정상 1001 : 서버 문제 발생 1002 : 요청 정보가 잘못되었음
		 */

//		Map<String, Object> result = new HashMap<>();
//		
//		result.put("code", 1002);
//		result.put("message", idolService.list());
//		return result;

////	List<Idol> list = idolService.list();
////	return list;

		/*
		 * 
		 * 성공시 : 200 데이터가 없는 경우 : 204 실패시 : 500
		 */

		ResponseEntity<?> responseEntity;
		try {
			List<Idol> list = idolService.list();
			if (list.isEmpty()) {
				responseEntity = new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
			} else {
				HttpHeaders headers = new HttpHeaders();
				headers.add("mykey", "abcde12345");
				responseEntity = new ResponseEntity<>(list, headers, HttpStatus.OK);
			}
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("문제가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	
	/*
	 	정상일 경우 200
	  	요청 번호에 해당하는 데이터가 없을 경우 204
	 */
	// /idol/76
	@GetMapping("{no}")
//	@ResponseBody
	@Operation(
//			hidden = true,
			summary = "아이돌 상세 조회",
			description = "번호에 해당하는 아이돌의 상세 정보를 반환합니다.",
			responses = {
					@ApiResponse(responseCode = "200", description = "정상 조회"),
					@ApiResponse(responseCode = "204", description = "데이터가 존재하지 않음"),
			},
			parameters = {
					@Parameter(
							name = "no", 
							description = "아이돌 번호",
							required = true
					)
			}
	)
	public ResponseEntity<Idol> detail(@PathVariable("no") int no) {
//	public Idol detail(@PathVariable("no") int no) {
//	public Idol detail(@PathVariable int no){
		Idol idol = idolService.detail(no);
		if(idol == null) {   // 요청 번호에 해당하는 아이돌이 존재하지 않는 경우
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(idol);
		
//		return ResponseEntity.ok(idol); // 권장되는 방식
		
		// 기존 객체 생성 방식
//		return new ResponseEntity<Idol>(idol, HttpStatus.OK);	
		
//		return idolService.detail(no);
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
