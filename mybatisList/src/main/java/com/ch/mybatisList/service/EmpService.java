package com.ch.mybatisList.service;

import java.util.List;

import com.ch.mybatisList.model.Emp;

public interface EmpService {

	List<Emp> empList(int deptno);

}
