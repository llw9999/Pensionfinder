package com.mycompany.myapp.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.dto.JoinPension;

@Repository
public class JoinPensionRepositoryImpl implements JoinPensionRepository{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(JoinPension joinpension) {
		return sqlSession.insert("com.mycompany.myapp.JoinPensionMapper.insert", joinpension);
	}

	@Override
	public int update(JoinPension joinpension) {
		return sqlSession.update("com.mycompany.myapp.JoinPensionMapper.update", joinpension);
	}

	@Override
	public int delete(String pemail) {
		return sqlSession.delete("com.mycompany.myapp.JoinPensionMapper.delete", pemail);
	}

	@Override
	public JoinPension selectOne(String pemail) {
		return sqlSession.selectOne("com.mycompany.myapp.JoinPensionMapper.selectOne", pemail);
	}

	@Override
	public List<JoinPension> selectList(Map<String, String> map) {
		return sqlSession.selectList("com.mycompany.myapp.JoinPensionMapper.selectList", map);
	}

	@Override
	public int update_emailauth(String pemail) {
		return sqlSession.update("com.mycompany.myapp.JoinPensionMapper.update_emailauth", pemail);
	}

}
