package com.ch.mybatisBoard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.mybatisBoard.model.Board;

@Repository
public class BoardDaoImpl implements BoardDao{
	@Autowired
	private SqlSessionTemplate sst;

	public List<Board> list() {
		return sst.selectList("boardns.list");
	}

	public int insert(Board board) {
		return sst.insert("boardns.insert", board);
	}

	public void updateReadCount(int num) {
		sst.update("boardns.updateReadCount", num);
	}

	public Board select(int num) {
		return sst.selectOne("boardns.select", num);
	}
}
