package com.ch.mybatisList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.mybatisList.dao.DeptDao;
import com.ch.mybatisList.model.Dept;

@Service
public class DeptServiceImpl implements DeptService{
	@Autowired
	private DeptDao dd;

	public List<Dept> list() {
		return null;
	}
}
