package com.ch.restfulBoard.service;

import java.util.List;

import com.ch.restfulBoard.model.ReplyBoard;

public interface ReplyBoardService {

	List<ReplyBoard> list(int bno);

	void insert(ReplyBoard rb);

	void delete(int rno);

	void update(ReplyBoard rb);

}
