package com.ch.mybatisList.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.mybatisList.model.Dept;

@Repository
public class DeptDaoImpl implements DeptDao {
	@Autowired
	private SqlSessionTemplate sst;

	public List<Dept> list() {
		return sst.selectList("deptns.deptList");
	}

	public Dept select(int deptno) {
		// TODO Auto-generated method stub
		return sst.selectOne("deptns.select", deptno);
	}
	
	public int insertDept(Dept dept) {
		return sst.insert("deptns.insertDept", dept);
	}

	public int updateDept(Dept dept) {
		return sst.update("deptns.updateDept", dept);
	}

	public int delete(int deptno) {
		return sst.delete("deptns.deleteDept", deptno);
	}
}
