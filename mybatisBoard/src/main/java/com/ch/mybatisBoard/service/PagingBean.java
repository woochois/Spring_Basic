package com.ch.mybatisBoard.service;

import lombok.Data;

@Data
public class PagingBean {

	private int currentPage;
	private int rowPerPage;
	private int total;
	private int totalPage;
	private int pagePerBlock = 10;
	private int startPage;
	private int endPage;
	
	public PagingBean(int currentPage, int rowPerPage, int total) {
		this.currentPage = currentPage;
		this.rowPerPage = rowPerPage;
		this.total = total;
		
		// 페이지 : Math.ceil(개수/페이지당 개수) - Math.ceil은 올림 함수
		totalPage = (int) Math.ceil((double) total/rowPerPage);
		// 시작 페이지 : 현재 페이지 - ( 현재 페이지 - 1 ) % pagePerBlock
		startPage = currentPage - (currentPage - 1) % pagePerBlock;
		// 끝 페이지 : 시작 페이지 + 블록 당 페이지 수 - 1
		endPage = startPage + pagePerBlock - 1;
		// 마지막 블록의 page 조정
		if (endPage > totalPage) 
			endPage = totalPage;
	}

}
