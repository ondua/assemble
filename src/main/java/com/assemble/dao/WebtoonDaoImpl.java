package com.assemble.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assemble.vo.WebtoonVO;

@Repository
public class WebtoonDaoImpl implements WebtoonDao {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertwebtoon(WebtoonVO wb) {
		this.sqlSession.insert("web_in", wb);
	}
}
