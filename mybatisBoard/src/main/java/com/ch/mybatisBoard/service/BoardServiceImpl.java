package com.ch.mybatisBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.mybatisBoard.dao.BoardDao;
import com.ch.mybatisBoard.model.Board;

@Repository
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDao bd;

	public List<Board> list() {
		return bd.list();
	}

	public int insert(Board board) {
		return bd.insert(board);
	}

	public void updateReadCount(int num) {
		bd.updateReadCount(num);
	}

	public Board select(int num) {
		return bd.select(num);
	}
}
