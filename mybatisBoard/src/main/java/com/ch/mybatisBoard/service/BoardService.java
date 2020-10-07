package com.ch.mybatisBoard.service;

import java.util.List;

import com.ch.mybatisBoard.model.Board;

public interface BoardService {

//	List<Board> list(int startRow, int endRow);
	List<Board> list(Board board);

	int insert(Board board);

	void updateReadCount(int num);

	Board select(int num);

	int getTotal(Board board);

	int update(Board board);

	int delete(int num);

	int maxNum();

	void updateRe_step(Board board);

}
