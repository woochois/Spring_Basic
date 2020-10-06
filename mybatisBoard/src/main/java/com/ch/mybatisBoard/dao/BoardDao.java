package com.ch.mybatisBoard.dao;

import java.util.List;

import com.ch.mybatisBoard.model.Board;

public interface BoardDao {

	List<Board> list(int startRow, int endRow);

	int insert(Board board);

	void updateReadCount(int num);

	Board select(int num);

	int getTotal();

	int update(Board board);

	int delete(int num);

	int maxNum();

	void updateRe_step(Board board);

}
