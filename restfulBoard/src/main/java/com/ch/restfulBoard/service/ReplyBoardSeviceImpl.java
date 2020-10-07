package com.ch.restfulBoard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.restfulBoard.dao.ReplyBoardDao;

@Service
public class ReplyBoardSeviceImpl implements ReplyBoardService{
	
	@Autowired
	private ReplyBoardDao rbd;
}
