package com.ch.mybatisList.dao;

import java.util.List;

import com.ch.mybatisList.model.Emp;

public interface EmpDao {

	List<Emp> empList(int deptno);

	Emp empSelect(int empno);

	List<Emp> empAllList();

	int empInsert(Emp emp);

}
