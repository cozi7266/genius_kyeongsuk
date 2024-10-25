package com.ssafy.hw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hw.model.dto.SearchCondition;
import com.ssafy.hw.model.dto.User;
import com.ssafy.hw.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@RequestMapping("/userapi")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@Tag(name = "user-rest-controller"
, description = "User Rest Controller")
public class UserRestController {

	@Autowired
	UserService us;
	
	@Operation(summary = "등록된 모든 사용자 정보를 반환한다.")
	@GetMapping("/user")
	public ResponseEntity<?> selectAll() {
		 try {
		 	List<User> users = us.selectAll();
		 	if (users.isEmpty()) {
		 		return ResponseEntity.noContent().build();
		 	} else {
		 		return ResponseEntity.ok(users);
		 	}
		 } catch (Exception e) {
		 	return exceptionHandling(e);
		 }
	}
	
	@Operation(summary = "{id}에 해당하는 사용자 정보를 반환한다.")
	@GetMapping("/user/{id}")
	public ResponseEntity<?> select(@PathVariable String id) {
		 try {
		 	User user = us.searchById(id);
		 	if (user != null) {
		 		return ResponseEntity.ok(user);
		 	} else {
		 		return ResponseEntity.noContent().build();
		 	}
		 } catch (Exception e) {
		 	return exceptionHandling(e);
		 }
	}
	
	@Operation(summary = "SearchCondition에 부합하는 조건을 가진 사용자 목록을 반환한다.")
	@GetMapping("/user/search")
	public ResponseEntity<?> search(@ModelAttribute SearchCondition con) {
		 try {
		 	List<User> users = us.searchByCondition(con);
		 	if (users.isEmpty()) {
		 		return ResponseEntity.noContent().build();
		 	} else {
		 		return ResponseEntity.ok(users);
		 	}
		 } catch (Exception e) {
		 	return exceptionHandling(e);
		 }
	}
	
	@Operation(summary = "사용자 정보를 삽입한다.")
	@PostMapping("/user")
	public ResponseEntity<?> insert(User user) {
		 try {
		 	int result = us.insert(user);
		 	if(result > 0) { // 사용자가 성공적으로 추가된 경우
		 		return ResponseEntity.status(HttpStatus.CREATED).build();
		 	} else { // 추가 실패 시
		 		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to insert user");
		 	}

		 } catch (Exception e) {
		 	return exceptionHandling(e);
		 }
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
