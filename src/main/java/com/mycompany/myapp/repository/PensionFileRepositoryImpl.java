package com.mycompany.myapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.dto.PensionFile;

@Repository
public class PensionFileRepositoryImpl implements PensionFileRepository{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(PensionFile pensionFile) {
		return sqlSession.insert("com.mycompany.myapp.PensionFileMapper.insert", pensionFile);
	}

	@Override
	public int update(PensionFile pensionFile) {
		return sqlSession.update("com.mycompany.myapp.PensionFileMapper.update", pensionFile);
	}

	@Override
	public int delete(int pfnum) {
		return sqlSession.delete("com.mycompany.myapp.PensionFileMapper.delete", pfnum);
	}

	@Override
	public PensionFile selectOne(int pfnum) {
		return sqlSession.selectOne("com.mycompany.myapp.PensionFileMapper.selectOne", pfnum);
	}

	@Override
	public List<PensionFile> selectList(int pnum) {
		return sqlSession.selectList("com.mycompany.myapp.PensionFileMapper.selectList", pnum);
	}
}
