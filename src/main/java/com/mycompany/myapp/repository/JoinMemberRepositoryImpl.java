package com.mycompany.myapp.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.dto.JoinMember;

@Repository
public class JoinMemberRepositoryImpl implements JoinMemberRepository{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(JoinMember joinmember) {
		// TODO Auto-generated method stub
		return sqlSession.insert("com.mycompany.myapp.JoinMemberMapper.insert", joinmember);
	}

	@Override
	public int update(JoinMember joinmember) {
		return sqlSession.update("com.mycompany.myapp.JoinMemberMapper.update", joinmember);
	}

	@Override
	public int delete(String memail) {
		return sqlSession.delete("com.mycompany.myapp.JoinMemberMapper.delete", memail);
	}

	@Override
	public JoinMember selectOne(String memail) {
		return sqlSession.selectOne("com.mycompany.myapp.JoinMemberMapper.selectOne", memail);
	}

	@Override
	public List<JoinMember> selectList(Map<String, String> map) {
		return sqlSession.selectList("com.mycompany.myapp.JoinMemberMapper.selectList", map);
	}

	@Override
	public int update_emailauth(String memail) {
		return sqlSession.update("com.mycompany.myapp.JoinMemberMapper.update_emailauth", memail);
	}

}
