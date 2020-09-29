package com.ch.mybatisList.service;

import java.util.List;

import com.ch.mybatisList.model.Dept;

public interface DeptService {

	List<Dept> list();

	Dept select(int deptno);

	int insertDept(Dept dept);

	int updateDept(Dept dept);

	int delete(int deptno);

}
