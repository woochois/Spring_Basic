package com.ch.restfulBoard.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyBoardDaoImpl implements ReplyBoardDao {
	
	@Autowired
	private SqlSessionTemplate sst;
}
