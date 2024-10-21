package com.ssafy.myboard.file.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		// "/files/**" 경로로 요청이 들어오면 "C:/ssafy/uploads/" 디렉토리에서 파일을 찾고싶다면
		registry.addResourceHandler("/files/**").addResourceLocations("file:///C:/ssafy/uploads/");
	}

}
