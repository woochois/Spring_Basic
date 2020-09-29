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
}
