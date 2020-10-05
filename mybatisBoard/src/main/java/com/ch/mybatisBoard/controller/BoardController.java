package com.ch.mybatisBoard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.mybatisBoard.service.BoardService;
import com.ch.mybatisBorad.model.Board;

@Controller
public class BoardController {
	@Autowired
	private BoardService bs;
	
	@RequestMapping("list")
	public String list(Model model) {
		List<Board> list = bs.list();
		model.addAttribute("list", list);
		return "list";
	}
}
