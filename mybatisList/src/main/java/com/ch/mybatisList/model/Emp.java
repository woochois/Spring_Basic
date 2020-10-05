package com.ch.mybatisList.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Emp { // DTO, VO 데이터를 묶어서 전달한다.
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
	// join 용
	private Dept dept;
}
