package com.ch.mybatisBoard.service;

import java.util.List;

import com.ch.mybatisBoard.model.Board;

public interface BoardService {

	List<Board> list(int startRow, int endRow);

	int insert(Board board);

	void updateReadCount(int num);

	Board select(int num);

	int getTotal();

	int update(Board board);

}
