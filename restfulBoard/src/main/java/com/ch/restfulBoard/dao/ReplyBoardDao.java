package com.ch.restfulBoard.dao;

import java.util.List;

import com.ch.restfulBoard.model.ReplyBoard;

public interface ReplyBoardDao {

	List<ReplyBoard> list(int bno);

	void insert(ReplyBoard rb);

	void delete(int rno);

	void update(ReplyBoard rb);

}
