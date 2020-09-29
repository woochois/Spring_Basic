package com.ch.mybatisList.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDaoImpl implements EmpDao{
	@Autowired
	private SqlSessionTemplate sst;
	
}
