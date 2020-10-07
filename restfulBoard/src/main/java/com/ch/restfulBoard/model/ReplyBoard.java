package com.ch.restfulBoard.model;

import java.sql.Date;

import lombok.Data;

@Data
public class ReplyBoard {
	private int rno;
	private int pno;
	private String replytext;
	private String replyer;
	private Date regdate;
	private Date updatedate;
	private String del;
}
