package com.ch.mvc2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {
	@RequestMapping("sendMember")
	public Member sendMember() {
		Member member = new Member();
		member.setName("홍길동");
		member.setTel("010-2222-2222");
		member.setAge(34);
		
		return member;
	}
	
	@RequestMapping("sendList")
	public List<Member> sendList(){
		List<Member> list = new ArrayList<Member>();
		for(int i = 1; i < 10; i ++) {
			Member member = new Member();
			member.setAge(11 + i);
			member.setName("길동" + i);
			member.setTel("010-3333-" + (1000 + i));
			list.add(member);
		}
		return list;
	}
}
