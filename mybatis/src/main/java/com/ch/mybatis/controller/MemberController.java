package com.ch.mybatis.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.ch.mybatis.model.Member;
import com.ch.mybatis.model.MemberPhoto;
import com.ch.mybatis.service.MemberService;
@Controller
public class MemberController {
	@Autowired
	private MemberService ms;
	@RequestMapping("joinForm")
	public String joinForm() {
		return "joinForm";
	}
	@RequestMapping("joinForm2")
	public String joinForm2() {
		return "joinForm2";
	}
	/*
	 * @RequestMapping("idChk") 
	 * public String idChk(String id, Model model) { 
		 * String msg = ""; 
		 * Member member = ms.select(id); 
		 * if (member == null) msg="사용가능한 ID입니다"; 
		 * else msg="이미 있으니 다른 ID를 사용하시오"; 
		 * model.addAttribute("msg", msg); 
		 * return "idChk"; 
	 * }
	 */
	@RequestMapping(value="idChk",produces="text/html;charset=utf-8")
	@ResponseBody  // jsp프로그램을 이용하지 않고 바로 본문을 전달
	public String idChk(String id) {
		String msg = ""; 
		Member member = ms.select(id); 
		if (member == null) msg="사용가능한 ID입니다"; 
		else msg="이미 있으니 다른 ID를 사용하시오";
		return msg;
	}
	@RequestMapping("join")
	public String join(Member member,Model model,HttpSession session) throws IOException {
		int result = 0;
		Member mem = ms.select(member.getId());
		if (mem == null) {
			// 화면에서 member로 파일명은 입력되지 않음	
			// String fileName = member.getFile().getOriginalFilename();
			String fileName1=member.getFile().getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			String fileName = uuid+"-"+fileName1;
			member.setFileName(fileName);
			String real = session.getServletContext()
					.getRealPath("/upload");
			FileOutputStream fos = 
				new FileOutputStream(new File(real+"/"+fileName));
			fos.write(member.getFile().getBytes());
			fos.close();
			result = ms.insert(member);
		} else result = -1;
		model.addAttribute("result", result);
		return "join";
	}
	@RequestMapping("loginForm")
	public String loginForm() {
		return "loginForm";
	}
	@RequestMapping("login")
	public String login(Member member,Model model,HttpSession session) {
		int result = 0;
		Member mem = ms.select(member.getId());
		if (mem == null || mem.getDel().equals("y")) result = -1;  // 없는 ID
		else if (mem.getPassword().equals(member.getPassword())) {
			result = 1; // 성공
			session.setAttribute("id", member.getId());
		}
		model.addAttribute("result", result);
		return "login";
	}
	@RequestMapping("main")
	public String main(Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		Member member = null;
		if (id != null && !id.equals(""))
			member = ms.select(id);
		model.addAttribute("member", member);
		return "main";
	}
	@RequestMapping("view")
	public String view(Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		Member member = ms.select(id);
		model.addAttribute("member", member);
		return "view";
	}
	@RequestMapping("view2")
	public String view2(Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		Member member = ms.select(id);
		List<MemberPhoto> list = ms.listPhoto(id);
		model.addAttribute("member", member);
		model.addAttribute("list", list);
		return "view2";
	}
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}
	@RequestMapping("updateForm")
	public String updateForm(Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		Member member = ms.select(id);
		model.addAttribute("member", member);
		return "updateForm";
	}
	@RequestMapping("update")
	public String update(Member member,Model model,HttpSession session) throws IOException {
		String fileName1=member.getFile().getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		String fileName = uuid+"-"+fileName1;
	//	String fileName = member.getFile().getOriginalFilename();
		// 수정에서 파일을 선택하지 않으면 값이 공란("")이 넘어옴
		if (fileName!=null && !fileName.equals("")) {
			String real=session.getServletContext()
					.getRealPath("/upload");
			FileOutputStream fos = new FileOutputStream(
					new File(real+"/"+fileName));
			fos.write(member.getFile().getBytes());
			fos.close();
			member.setFileName(fileName);
		}
		int result = ms.update(member);
		model.addAttribute("result", result);
		return "update";
	}
	@RequestMapping("delete")
	public String delete(Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		int result  = ms.delete(id);
		if (result >0 ) session.invalidate();
		model.addAttribute("result", result);
		return "delete";
	}
	@RequestMapping("join2")
	public String join2(Member member, Model model, 
			HttpSession session, MultipartHttpServletRequest mr) 
					throws IOException {
		int result = 0;
		Member mem = ms.select(member.getId());
		if (mem == null) {
			String real=session.getServletContext().getRealPath("/upload");
			// 여러개 그림파일을 한번에 받아온다
			List<MultipartFile> list = mr.getFiles("file");
			List<MemberPhoto> photos = new ArrayList<MemberPhoto>();
			for (MultipartFile mf:list) {
				MemberPhoto mp = new MemberPhoto();
				String fileName= mf.getOriginalFilename();
				mp.setFileName(fileName);
				mp.setId(member.getId());
				photos.add(mp);
				FileOutputStream fos = new FileOutputStream(
						new File(real+"/"+fileName));
				fos.write(mf.getBytes());
				fos.close();
				// 임시로 member에 마지막 파일 기록 member fileName없으면 생략
				member.setFileName(fileName);
			}
			result = ms.insert(member);
			ms.insertphoto(photos);
		} else result = -1;
		model.addAttribute("result", result);
		return "join";
	}
}



