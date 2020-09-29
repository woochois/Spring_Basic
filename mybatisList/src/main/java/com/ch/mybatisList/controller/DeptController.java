package com.ch.mybatisList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.mybatisList.model.Dept;
import com.ch.mybatisList.service.DeptService;

@Controller
public class DeptController {
	@Autowired
	private DeptService ds;
	
	@RequestMapping("deptList")
	public String deptList(Model model) {
		List<Dept> deptList = ds.list();
		model.addAttribute("deptList", deptList);
		return "/dept/deptList";
	}
}
