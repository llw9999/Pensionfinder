package com.mycompany.myapp.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.dto.Reserve;

@Repository
public class ReserveRepositoryImpl implements ReserveRepository {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insert(Reserve reserve){
		return sqlSession.insert("com.mycompany.myapp.ReserveMapper.insert", reserve);
	}

	@Override
	public int delete(int rnum){
		return sqlSession.delete("com.mycompany.myapp.ReserveMapper.delete", rnum);
	}

	@Override
	public List<Reserve> mselectList(String memail) {
		return sqlSession.selectList("com.mycompany.myapp.ReserveMapper.mselectList", memail);
	}

	@Override
	public List<Reserve> selectList(int pnum) {
		return sqlSession.selectList("com.mycompany.myapp.ReserveMapper.selectList", pnum);
	}

	@Override
	public int updateRremoveyn(int rnum) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.mycompany.myapp.ReserveMapper.updateRremoveyn", rnum);
	}

	@Override
	public int insertcheck(Reserve reserve) {
		return sqlSession.selectOne("com.mycompany.myapp.ReserveMapper.insertcheck", reserve);
		
	}

}
