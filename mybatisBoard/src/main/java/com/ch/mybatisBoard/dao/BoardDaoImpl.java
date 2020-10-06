package com.ch.mybatisBoard.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.mybatisBoard.model.Board;

@Repository
public class BoardDaoImpl implements BoardDao{
	@Autowired
	private SqlSessionTemplate sst;

	public List<Board> list(int startRow, int endRow) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		return sst.selectList("boardns.list", map);
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

	public int getTotal() {
		return sst.selectOne("boardns.getTotal");
	}

	public int update(Board board) {
		return sst.update("boardns.update", board);
	}
}
