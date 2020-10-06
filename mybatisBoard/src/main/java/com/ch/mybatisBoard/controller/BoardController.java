package com.ch.mybatisBoard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.mybatisBoard.model.Board;
import com.ch.mybatisBoard.service.BoardService;
import com.ch.mybatisBoard.service.PagingBean;

@Controller
public class BoardController {
	@Autowired
	private BoardService bs;

	@RequestMapping("list")
	public String list(String pageNum, Model model) {
		int rowPerPage = 10;
		// 페이지가 지정되지 않으면 1페이지를 보여줘라
		if (pageNum == null || pageNum.equals(""))
			pageNum = "1";

		int currentPage = Integer.parseInt(pageNum);
		int total = bs.getTotal();
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		List<Board> list = bs.list(startRow, endRow);
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		model.addAttribute("list", list);
		model.addAttribute("pb", pb);
		return "list";
	}

	@RequestMapping("insertForm")
	public String insertForm(String nm, String pageNum, Model model) {
		// 답변용 ref, re_level, re_step
		int ref = 0, re_level = 0, re_step = 0, num = 0; // 답변 글이 아님.
		if (nm != null && !nm.equals("")) { // 답변 글
			num = Integer.parseInt(nm);
			Board board = bs.select(num);

			// 원본 글의 ref, re_level, re_step
			ref = board.getRef();
			re_level = board.getRe_level();
			re_step = board.getRe_step();
		}
		model.addAttribute("ref", ref);
		model.addAttribute("re_level", re_level);
		model.addAttribute("re_step", re_step);
		model.addAttribute("num", num);
		model.addAttribute("pageNum", pageNum);
		return "insertForm";
	}

	@RequestMapping("insert")
	public String insert(Board board, String pageNum, Model model, HttpServletRequest request) {
		board.setIp(request.getLocalAddr()); // ip setting
		int number = bs.maxNum(); // num값
		if (board.getNum() != 0) { // 답변 글
			// re_step을 정리
			bs.updateRe_step(board);
			board.setRe_level(board.getRe_level() + 1);
			board.setRe_step(board.getRe_step() + 1);
		} else
			board.setRef(number); // 답변 글이 아니면 ref와 num은 같다
		board.setNum(number);
		int result = bs.insert(board);
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "insert";
	}

	@RequestMapping("view")
	public String view(int num, String pageNum, Model model) {
		bs.updateReadCount(num);
		Board board = bs.select(num);
		System.out.println(num + "," + board);
		model.addAttribute("board", board);
		model.addAttribute("pageNum", pageNum);
		return "view";
	}

	@RequestMapping("updateForm")
	public String updateForm(int num, String pageNum, Model model) {
		Board board = bs.select(num);
		model.addAttribute("board", board);
		model.addAttribute("pageNum", pageNum);
		return "updateForm";
	}

	@RequestMapping("update")
	public String update(Board board, String pageNum, Model model) {
		int result = bs.update(board);
		model.addAttribute("result", result);
		model.addAttribute("board", board);
		model.addAttribute("pageNum", pageNum);
		return "update";
	}

	@RequestMapping("deleteForm")
	public String deleteForm(int num, String pageNum, Model model) {
		Board board = bs.select(num);
		model.addAttribute("board", board);
		model.addAttribute("pageNum", pageNum);
		return "deleteForm";
	}

	@RequestMapping("delete")
	public String delete(int num, String pageNum, Model model) {
		int result = bs.delete(num);
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "delete";
	}

//	더미 데이터 삽입
//	@RequestMapping("insertBoard")
//	public String insertBoard(HttpServletRequest request) {
//		String ip = request.getLocalAddr();
//		for (int i = 400; i <= 600; i++) {
//			Board board = new Board();
//			board.setSubject("테스트" + i);
//			board.setWriter("테스트" + i);
//			board.setEmail("테스트" + i + "@com");
//			board.setPasswd("a");
//			board.setContent("테스트" + i);
//			board.setIp(ip);
//			bs.insert(board);
//		}
//		return "insertBoard";
//	}

}
