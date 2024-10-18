package com.ssafy.myboard.file.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FileDownloadView extends AbstractView{

	private ResourceLoader resourceLoader;

	public FileDownloadView(ResourceLoader resourceLoader) {
			this.resourceLoader = resourceLoader;
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// 사전준비
		String systemName = (String)model.get("systemName");
		Resource resource = resourceLoader.getResource("classpath:/static/img");
		File file = new File(resource.getFile() + (String)model.get("filePath"), systemName);
		//////
		
		systemName = new String(systemName.getBytes("UTF-8"), "ISO-8859-1"); // 인코딩 방식 지정(한글이 다른 브라우저에서 깨질 수 있으므로)
		
		// 헤더 설정, 약속된 것이므로 이 형식을 지켜야 함
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + systemName + "\";");

		response.setHeader("Content-Transfer-Encoding", "binary");
		
		/////////////////////////////////////////
		
		
		try(
				FileInputStream fis = new FileInputStream(file);
				OutputStream os = response.getOutputStream();
				) {
			FileCopyUtils.copy(fis, os);
		}
		
	}

}
