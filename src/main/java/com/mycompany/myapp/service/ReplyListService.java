package com.mycompany.myapp.service;

import java.util.List;

import com.mycompany.myapp.advice.ErrorCode;
import com.mycompany.myapp.dto.Page;
import com.mycompany.myapp.dto.ReplyList;


public interface ReplyListService {
	ReplyList selectOne(int rnum);
	
	ErrorCode insert(ReplyList rList) throws Exception;
	ErrorCode update(ReplyList rList) throws Exception;
	ErrorCode updateRremoveyn(int rnum);
	
	//도움이 되는 댓글
	int updateHelp(int rnum);
	//도움이 안되는 댓글
	int updateUseless(int rnum);
	List<ReplyList> selectList(Page page);

}
