package com.ch.restfulBoard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.restfulBoard.model.ReplyBoard;

@Repository
public class ReplyBoardDaoImpl implements ReplyBoardDao {
	
	@Autowired
	private SqlSessionTemplate sst;

	public List<ReplyBoard> list(int bno) {
		return sst.selectList("rbdns.list", bno);
	}

	public void insert(ReplyBoard rb) {
		sst.insert("rbdns.insert", rb);
	}
	
	public void delete(int rno) {
		sst.update("rbdns.delete", rno);
	}

	public void update(ReplyBoard rb) {
		sst.update("rbdns.update", rb);
	}
}
