package com.ch.restfulBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ch.restfulBoard.service.BoardService;
import com.ch.restfulBoard.service.ReplyBoardService;

@Controller
public class ReplyBoardController {

	@Autowired
	private BoardService bs;
	
	@Autowired
	private ReplyBoardService rbs;
	
}
