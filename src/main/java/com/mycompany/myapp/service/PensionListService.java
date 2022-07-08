package com.mycompany.myapp.service;

import java.util.List;

import com.mycompany.myapp.advice.ErrorCode;

import com.mycompany.myapp.dto.Page;
import com.mycompany.myapp.dto.PensionList;

public interface PensionListService {
	List<PensionList> selectList(Page page);
	PensionList selectOne(int pnum);
	
	ErrorCode insert(PensionList pList) throws Exception;
	ErrorCode update(PensionList pList, List<Integer> removeFiles) throws Exception;
	ErrorCode updateRemoveyn(int pnum);
	
	//좋아요
	int updateLikes(int pnum);
	//싫어요
	int updateDislikes(int pnum);
	
}
