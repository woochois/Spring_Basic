package com.ch.mybatis.dao;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.mybatis.model.Member;
import com.ch.mybatis.model.MemberPhoto;
@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSessionTemplate sst;
	public Member select(String id) {
		return sst.selectOne("memberns.select", id);
	}
	public int insert(Member member) {
		return sst.insert("memberns.insert",member);
	}
	public int update(Member member) {
		return sst.update("memberns.update", member);
	}
	public int delete(String id) {
		return sst.update("memberns.delete", id);
	}
	public void insertphoto(List<MemberPhoto> photos) {
		sst.insert("memberns.insertphoto",photos);		
	}
	public List<MemberPhoto> listPhoto(String id) {
		return sst.selectList("memberns.selectPhotoList", id);
	}
}


