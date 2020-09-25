package com.ch.fileupload;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Member {
	private String id;
	private String name;
	private String fileName;
	
	//파일 업로드용
	private MultipartFile file;
}
