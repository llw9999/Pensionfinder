package com.mycompany.myapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.dto.Page;
import com.mycompany.myapp.dto.ReplyList;


@Repository
public class ReplyListRepositoryImpl implements ReplyListRepository{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(ReplyList rList) {
		return sqlSession.insert("com.mycompany.myapp.ReplyListMapper.insert", rList);
	}

	@Override
	public int update(ReplyList rList) {
		return sqlSession.update("com.mycompany.myapp.ReplyListMapper.update", rList);
	}

	@Override
	public int delete(int rnum) {
		return sqlSession.delete("com.mycompany.myapp.ReplyListMapper.delete", rnum);
	}

	@Override
	public ReplyList selectOne(int rnum) {
		return sqlSession.selectOne("com.mycompany.myapp.ReplyListMapper.selectOne", rnum);
	}

	@Override
	public List<ReplyList> selectList(int pnum, Page page) {
		return sqlSession.selectList("com.mycompany.myapp.ReplyListMapper.selectList", page);
	}

	@Override
	public int updateHelp(int rnum) {
		return sqlSession.update("com.mycompany.myapp.ReplyListMapper.updateHelp", rnum);
	}

	@Override
	public int updateUseless(int rnum) {
		return sqlSession.update("com.mycompany.myapp.ReplyListMapper.updateUseless", rnum);
	}

	@Override
	public int updateRremoveyn(int rnum) {
		return sqlSession.update("com.mycompany.myapp.ReplyListMapper.updateRremoveyn", rnum);
	}

	@Override
	public int selectTotalCnt(int pnum, Page page) {
		return sqlSession.selectOne("com.mycompany.myapp.ReplyListMapper.selectTotalCnt", page);
	}
}
