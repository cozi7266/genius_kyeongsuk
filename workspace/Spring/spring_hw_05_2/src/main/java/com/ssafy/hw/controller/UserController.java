package com.ssafy.hw.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.hw.model.dto.User;

@Controller
public class UserController {

    @Autowired
    ResourceLoader resLoader;

    // 사용자 목록을 static으로 선언하여 모든 요청에서 공유되도록 설정
    private static List<User> userList = new ArrayList<>();

    // 초기 사용자 목록 추가
    static {
        userList.add(new User("ssafy1", "1234", "김싸피", "ssafy1@ssafy.com", 26));
        userList.add(new User("ssafy2", "1234", "박싸피", "ssafy2@ssafy.com", 26));
        userList.add(new User("ssafy3", "1234", "이싸피", "ssafy3@ssafy.com", 26));
        userList.add(new User("ssafy4", "1234", "강싸피", "ssafy4@ssafy.com", 26));
    }

    // 홈 페이지 또는 인덱스 페이지 이동
    @GetMapping({ "/", "/index" })
    public String showIndex() {
        return "index";
    }

    // 사용자 등록 폼으로 이동
    @GetMapping("/regist")
    public String showRegistForm() {
        return "regist";
    }

    // 사용자 등록 처리
    @PostMapping("/regist")
    public String doRegist(@ModelAttribute User user, @RequestParam(value = "file", required = false) MultipartFile file, Model model)
            throws IllegalStateException, IOException {

        // 파일이 존재하는 경우 파일 저장 처리
        if (file != null && !file.isEmpty()) {
            // 파일 저장할 위치 지정
            String uploadPath = new File("target/classes/static/upload/").getAbsolutePath();
//        	System.out.println(uploadPath);
//        	Resource resource = resLoader.getResource("classpath:/static/img/");
//        	System.out.println(resource.getFile()); 
        	File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs(); // 디렉토리가 없으면 생성
            }

            // 중복 방지를 위해 파일 이름 앞에 현재 시간 추가
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            user.setImg(fileName); // User 객체에 고유 파일 이름 저장
            user.setOrgImg(file.getOriginalFilename()); // User 객체에 원본 파일 이름 저장

            // 파일을 저장할 경로 생성
            File destinationFile = new File(uploadDir, fileName);
//            File destinationFile = new File(resource.getFile(), fileName);
            try {
                file.transferTo(destinationFile); // 실제 파일을 해당 위치에 저장
            } catch (IOException e) {
                e.printStackTrace(); // 오류 로그 출력
                throw new RuntimeException("파일 저장 중 오류 발생", e);
            }
        } else {
            user.setImg(null);
            user.setOrgImg(null);
        }

        // 사용자 목록에 추가
        userList.add(user);

        // 등록 후 결과 페이지로 이동하여 사용자 정보를 확인
        model.addAttribute("user", user);
        return "regist_result";
    }

    // 사용자 목록 보기
    @GetMapping("/list")
    public String showList(Model model) {
        // 사용자 목록을 모델에 추가하여 JSP에서 접근 가능하게 설정
        model.addAttribute("users", userList);
        return "list"; // 리스트 JSP 페이지로 이동
    }

    @PostMapping("/login")
    public String doLogin(User user, HttpSession session, Model model) {
        String view = "/index";

        if (user.getId().equals("ssafy") && user.getPassword().equals("1234")) {
            user.setName("김싸피");
            session.setAttribute("loginUser", user);
            view = "redirect:/";
        } else {
            model.addAttribute("msg", "로그인 실패");
        }

        return view;
    }

    @GetMapping("/logout")
    public String doLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/error/404")
    public void showError404() {
        // 404 Not Found 처리
    }
}
