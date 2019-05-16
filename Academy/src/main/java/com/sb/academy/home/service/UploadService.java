package com.sb.academy.home.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {

	public String imgUpload(MultipartFile file, HttpServletRequest request, HttpServletResponse response)
			throws IllegalStateException, IOException {
		response.setContentType("text/html;charset=utf-8");

		// 파일 이름 생성 - 파일명이 중복되지 않도록 UUID를 이용하여 이름을 짓는다. 파라미터로 넘어온 파일의 실제 이름와 조합한다.
		String filename = UUID.randomUUID().toString() + file.getOriginalFilename();

		// 저장될 실제 폴더 경로+ 파일 이름
		String filepath = request.getSession().getServletContext().getRealPath("/upload/") + filename;

		// 경로를 이용하여 새 파일 생성 (저장 전)
		File f = new File(filepath);

		try {
			// 파일의 물리적 저장
			file.transferTo(f);
		} catch (IllegalStateException e) {
			f.delete(); // 저장 실패시 파일 삭제
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			f.delete();
			e.printStackTrace();
			throw e;
		}
		// DB에 저장될 웹경로(파일의 주소) 리턴 - 필요한 경우만 사용
		String sqlpath = ("http://192.168.0.10/academy/upload/" + filename).trim();
		return sqlpath;
	};

}
