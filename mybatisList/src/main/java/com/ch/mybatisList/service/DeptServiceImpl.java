package com.ch.mybatisList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.mybatisList.dao.DeptDao;
import com.ch.mybatisList.model.Dept;

@Service
public class DeptServiceImpl implements DeptService{
	@Autowired
	private DeptDao dd;

	public List<Dept> list() {
		return dd.list();
	}

	public Dept select(int deptno) {
		return dd.select(deptno);
	}

	public int insertDept(Dept dept) {
		return dd.insertDept(dept);
	}

	public int updateDept(Dept dept) {
		return dd.updateDept(dept);
	}
	
	public int delete(int deptno) {
		return dd.delete(deptno);
	}

}
