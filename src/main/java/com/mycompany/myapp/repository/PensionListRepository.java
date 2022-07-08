package com.mycompany.myapp.repository;

import java.util.List;

import com.mycompany.myapp.dto.Page;
import com.mycompany.myapp.dto.PensionList;

public interface PensionListRepository {
	int insert(PensionList pList);
	int update(PensionList pList);
	int delete(int pnum);
	PensionList selectOne(int pnum);
	List<PensionList> selectList(Page page); //페이징 처리용 정보
	//전체 게시물 수
	int selectTotalCnt(Page page);
	
	//좋아요
	int updateLikes(int pnum);
	//싫어요
	int updateDisLikes(int pnum);
	
	//삭제여부
	int updateRemoveyn(int pnum);

}
