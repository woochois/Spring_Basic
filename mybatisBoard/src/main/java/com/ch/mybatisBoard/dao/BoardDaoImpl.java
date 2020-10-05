package com.ch.mybatisBoard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.mybatisBorad.model.Board;

@Repository
public class BoardDaoImpl implements BoardDao{
	@Autowired
	private SqlSessionTemplate sst;

	public List<Board> list() {
		return sst.selectList("boardns.list");
	}
}
