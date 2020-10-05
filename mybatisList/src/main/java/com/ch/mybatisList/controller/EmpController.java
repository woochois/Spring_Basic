package com.ch.mybatisList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		model.addAttribute("empList", empList);
		return "/emp/empList";
	}

	@RequestMapping("empSelect")
	public String empSelect(int empno, Model model) {
		Emp emp = es.empSelect(empno);
		model.addAttribute("emp", emp);
		return "/emp/empSelect";
	}

	@RequestMapping("empInsertForm")
	public String empInsertForm(int deptno, Model model) {
		List<Dept> deptList = ds.list(); // 부서 코드 선택
		List<Emp> empAllList = es.empAllList(); // 관리자 선택
		model.addAttribute("deptList", deptList);
		model.addAttribute("empAllList", empAllList);
		model.addAttribute("deptno", deptno);
		return "/emp/empInsertForm";
	}

	@RequestMapping("empInsert")
	public String empInsert(Emp emp, Model model) { // emp 화면 입력 데이터 (넘어옴)
		int result = 0;
		Emp emp2 = es.empSelect(emp.getEmpno()); // 중복 체크 했지만 혹시나 같은 사번 데이터를 입력하는 것을 방지하기 위함.
		if (emp2 == null) {
			result = es.empInsert(emp); // result는 입력에 성공한 개수
		}else result = -1; // 중복된 사번 입력
		model.addAttribute("result", result);
		model.addAttribute("emp", emp);
		return "/emp/empInsert";
	}

	@RequestMapping(value = "empnoChk", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String empnoChk(int empno) {
		String msg = "";
		Emp emp = es.empSelect(empno);
		if (emp == null)
			msg = "사용 가능한 사번입니다.";
		else
			msg = "중복된 사번입니다.";
		return msg;
	}
	
	@RequestMapping("empUpdateForm")
	public String empUpdateForm(int empno, Model model) {
		Emp emp = es.empSelect(empno);
		List<Dept> deptList = ds.list(); // 부서 코드 선택
		List<Emp> empAllList = es.empAllList(); // 관리자 선택
		model.addAttribute("deptList", deptList);
		model.addAttribute("empAllList", empAllList);
		model.addAttribute("emp", emp);
		return "/emp/empUpdateForm";
	}
	
	@RequestMapping("empUpdate")
	public String empUpdate(Emp emp, Model model) {
		int result = es.empUpdate(emp);
		model.addAttribute("result", result);
		model.addAttribute("emp", emp);
		return "/emp/empUpdate";
	}
}
