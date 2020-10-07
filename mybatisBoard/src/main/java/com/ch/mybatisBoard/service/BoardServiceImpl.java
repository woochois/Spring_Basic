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

//	public List<Board> list(int startRow, int endRow) {
//		return bd.list(startRow, endRow);
//	}
	
	public List<Board> list(Board board){
		return bd.list(board);
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

	public int getTotal(Board board) {
		return bd.getTotal(board);
	}

	public int update(Board board) {
		return bd.update(board);
	}

	public int delete(int num) {
		return bd.delete(num);
	}

	public int maxNum() {
		return bd.maxNum();
	}

	public void updateRe_step(Board board) {
		bd.updateRe_step(board);		
	}
}
