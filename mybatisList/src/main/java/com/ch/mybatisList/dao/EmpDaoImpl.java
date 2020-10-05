package com.ch.mybatisList.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.mybatisList.model.Emp;

@Repository
public class EmpDaoImpl implements EmpDao{
	@Autowired
	private SqlSessionTemplate sst;

	public List<Emp> empList(int deptno) {
		return sst.selectList("empns.empList", deptno);
	}

	public Emp empSelect(int empno) {
		return sst.selectOne("empns.empSelect", empno);
	}

	public List<Emp> empAllList() {
		return sst.selectList("empns.empAllList");
	}

	public int empInsert(Emp emp) {
		return sst.insert("empns.empInsert", emp);
	}
}
