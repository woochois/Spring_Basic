package com.ch.mybatisBoard.service;

import java.util.List;

import com.ch.mybatisBoard.model.Board;

public interface BoardService {

	List<Board> list();

	int insert(Board board);

	void updateReadCount(int num);

	Board select(int num);

}
