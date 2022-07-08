package com.mycompany.myapp.repository;

import java.util.List;

import com.mycompany.myapp.dto.Page;
import com.mycompany.myapp.dto.ReplyList;


public interface ReplyListRepository {
	int insert(ReplyList rList);
	int update(ReplyList rList);
	int delete(int rnum);
	ReplyList selectOne(int rnum);

	int updateHelp(int rnum);
	int updateUseless(int rnum);
	
	int updateRremoveyn(int rnum);
	
	int selectTotalCnt(int pnum, Page page);
	List<ReplyList> selectList(int rnum, Page page);
}
