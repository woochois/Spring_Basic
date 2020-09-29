package com.ch.mybatisList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping("insertDeptForm")
	public String insertDeptForm() {
		return "/dept/insertDeptForm";
	}

	@RequestMapping(value = "deptNoChk", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String deptNoChk(int deptno) {
		String msg = "";
		Dept dept = ds.select(deptno);
		if (dept == null)
			msg = "사용 가능한 코드입니다.";
		else
			msg = "사용 중이니 다른 번호를 사용하세요.";
		return msg;
	}

	@RequestMapping("insertDept")
	public String insertDept(Dept dept, Model model) {
		int result = 0;
		Dept dt = ds.select(dept.getDeptno());
		if (dt == null)
			result = ds.insertDept(dept);
		else
			result = -1;
		model.addAttribute("result", result);
		return "/dept/insertDept";
	}
	
	@RequestMapping("updateDeptForm")
	public String updateDeptForm(int deptno, Model model) {
		Dept dept = ds.select(deptno);
		model.addAttribute("dept", dept);
		return "/dept/updateDeptForm";
	}
	
	@RequestMapping("updateDept")
	public String updateDept(Dept dept, Model model) {
		int result = ds.updateDept(dept);
		model.addAttribute("result", result);
		return "/dept/updateDept";
	}
	
	@RequestMapping("deleteDept")
	public String deleteDept(int deptno, Model model) {
		int result  = ds.delete(deptno);
		model.addAttribute("result", result);
		return "/dept/deleteDept";
	}
}
