package com.ch.mybatis.service;
import java.util.List;

import com.ch.mybatis.model.Member;
import com.ch.mybatis.model.MemberPhoto;
public interface MemberService {
	Member select(String id);
	int insert(Member member);
	int update(Member member);
	int delete(String id);
	void insertphoto(List<MemberPhoto> photos);
	List<MemberPhoto> listPhoto(String id);

}