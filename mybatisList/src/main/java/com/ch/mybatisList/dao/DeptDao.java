package com.ch.mybatisList.dao;

import java.util.List;

import com.ch.mybatisList.model.Dept;

public interface DeptDao {

	List<Dept> list();

	Dept select(int deptno);

	int insertDept(Dept dept);
}
