package com.ch.mybatisBoard.dao;

import java.util.List;

import com.ch.mybatisBoard.model.Board;

public interface BoardDao {

	List<Board> list();

	int insert(Board board);

	void updateReadCount(int num);

	Board select(int num);

}
