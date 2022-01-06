package com.koreait.ex10.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.ex10.domain.Notice;

public class NoticeRepository {

	@Autowired
	private SqlSessionTemplate sqlSession;

	// 1. seletNoticeList
	public List<Notice> selectNoticeList() {
		return sqlSession.selectList("mapper.notice.selectNoticeList");
	}
	
	// 2. selectNoticeByNo
	public Notice selectNoticeByNo(Long no) {
		return sqlSession.selectOne("mapper.notice.selectNoticeByNo", no);
	}
	
	// 3. insertNotice
	public int insertNotice(Notice notice) {
		return sqlSession.insert("mapper.notice.insertNotice", notice);
		
	}
	
	// 4.updateNotice
	public int updateNotice(Notice notice) {
		return sqlSession.update("mapper.notice.updateNotice", notice);
		
	}
	
	
	// 5. deleteNotice
	public int deleteNotice(Long no) {
		return sqlSession.delete("mapper.notice.deleteNotice", no);
		
	}
	
	
}
