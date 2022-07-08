package com.mycompany.myapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.dto.Page;
import com.mycompany.myapp.dto.PensionList;

@Repository
public class PensionListRepositoryImpl implements PensionListRepository{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(PensionList pList) {

		return sqlSession.insert("com.mycompany.myapp.PensionListMapper.insert", pList);
	}

	@Override
	public int update(PensionList pList) {
		
		return sqlSession.update("com.mycompany.myapp.PensionListMapper.update", pList);
	}

	@Override
	public int delete(int pnum) {
		
		return sqlSession.delete("com.mycompany.myapp.PensionListMapper.delete", pnum);
	}

	@Override
	public PensionList selectOne(int pnum) {
		
		return sqlSession.selectOne("com.mycompany.myapp.PensionListMapper.selectOne", pnum);
	}

	@Override
	public List<PensionList> selectList(Page page) {
		
		return sqlSession.selectList("com.mycompany.myapp.PensionListMapper.selectList", page);
	}

	@Override
	public int selectTotalCnt(Page page) {
		//전체 게시물 수
		return sqlSession.selectOne("com.mycompany.myapp.PensionListMapper.selectTotalCnt", page);
	}

	@Override
	public int updateRemoveyn(int pnum) {
		//삭제여부
		return sqlSession.update("com.mycompany.myapp.PensionListMapper.updateRemoveyn", pnum);
	}

	@Override
	public int updateLikes(int pnum) {
		//좋아요
		return sqlSession.update("com.mycompany.myapp.PensionListMapper.updateLikes", pnum);
	}

	@Override
	public int updateDisLikes(int pnum) {
		return sqlSession.update("com.mycompany.myapp.PensionListMapper.updateDisLikes", pnum);
	}

}
