package com.sb.academy.hire.model;

import org.springframework.web.multipart.MultipartFile;

public class HireVO {

	private int boardNum;

	private String photo;

	private String title;

	private String content;
	
	private MultipartFile file;

	public HireVO(String photo) {
		super();
		this.photo = photo;
	}

	public String getphoto() {
		return photo;
	}

	public void setphoto(String photo) {
		this.photo = photo;
	}

	public int getBoarNum() {
		return boardNum;
	}

	public void setBoarNum(int boarNum) {
		this.boardNum = boarNum;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
