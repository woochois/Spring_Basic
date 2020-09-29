package com.ch.mybatisList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.mybatisList.dao.EmpDao;
import com.ch.mybatisList.model.Emp;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpDao ed;
	public List<Emp> empList(int deptno) {
		return ed.empList(deptno);
	}
	
	public Emp empSelect(int empno) {
		return ed.empSelect(empno);
	}

	public List<Emp> empAllList() {
		return ed.empAllList();
	}
	
}
