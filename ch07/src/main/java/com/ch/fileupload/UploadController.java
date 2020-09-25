package com.ch.fileupload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@RequestMapping("uploadForm")
	public String uploadForm() {
		return "uploadForm";
	}

	@RequestMapping("upload")
	public String upload(@RequestParam("file") MultipartFile mf, Member member, Model model, HttpSession session) throws IOException {
		String fileName = mf.getOriginalFilename();
		String real = session.getServletContext().getRealPath("/upload");
		FileOutputStream fos = new FileOutputStream(new File(real + "/" + fileName));
		fos.write(mf.getBytes());
		int fileSize = (int) mf.getSize();
		fos.close();
		
//		mf.transferTo(new File("/")); 업로드 폴더 경로 변경
		model.addAttribute("id", member.getId());
		model.addAttribute("fileName", fileName);
		model.addAttribute("fileSize", fileSize);
		model.addAttribute("name", member.getName());
		return "upload";
	}
	
	@RequestMapping("upload2")
	public String upload2(Member member, Model model, HttpSession session) throws IOException {
		String fileName = member.getFile().getOriginalFilename();
		String real = session.getServletContext().getRealPath("/upload");
		FileOutputStream fos = new FileOutputStream(new File(real + "/" + fileName));
		int fileSize = (int) member.getFile().getSize();
		fos.write(member.getFile().getBytes());
		fos.close();
		
//		mf.transferTo(new File("/")); 업로드 폴더 경로 변경
		model.addAttribute("id", member.getId());
		model.addAttribute("fileName", fileName);
		model.addAttribute("fileSize", fileSize);
		model.addAttribute("name", member.getName());
		return "upload";
	}
}
