package com.ch.mybatisList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.mybatisList.model.Dept;
import com.ch.mybatisList.model.Emp;
import com.ch.mybatisList.service.DeptService;
import com.ch.mybatisList.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	private EmpService es;
	
	@Autowired
	private DeptService ds;
	
	@RequestMapping("empList")
	public String empList(int deptno, Model model) {
		Dept dept = ds.select(deptno);
		List<Emp> empList = es.empList(deptno);
		model.addAttribute("dept", dept);
		return "/emp/empList";
	}
}
