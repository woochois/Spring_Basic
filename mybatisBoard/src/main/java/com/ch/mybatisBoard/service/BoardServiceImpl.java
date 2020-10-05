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
}
