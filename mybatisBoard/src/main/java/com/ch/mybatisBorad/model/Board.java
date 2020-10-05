package com.ch.mybatisBorad.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Board {
	private int num;
	private String writer;
	private String subject;
	private String content;
	private String email;
	private int readcount;
	private String password;
	private int ref;
	private int re_step;
	private int re_level;
	private String ip;
	private Date reg_date;
	private String del;
}
