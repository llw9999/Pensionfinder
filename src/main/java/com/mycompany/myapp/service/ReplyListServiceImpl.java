package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.myapp.advice.ErrorCode;
import com.mycompany.myapp.dto.Page;
import com.mycompany.myapp.dto.ReplyList;

import com.mycompany.myapp.repository.ReplyListRepository;

@Service
public class ReplyListServiceImpl implements ReplyListService{
	@Autowired
	private ReplyListRepository replyListRepository;	
	
	@Override
	public List<ReplyList> selectList(Page page) {
		//페이징 처리
		int curPage = page.getCurPage(); //현재페이지
		int perPage = page.getPerPage(); //한페이지당 게시물수
		int perBlock = page.getPerBlock(); //페이지 블럭의 수
		
		//1)게시물의 시작번호(mysql은 시작번호 0번 부터)
		//오라클은 + 1
		int startNum = (curPage-1) * perPage;
		//2)게시물의 끝번호
		int endNum = startNum + perPage -1;
		
		//3)전체페이지수
		int totalCnt = replyListRepository.selectTotalCnt(page); //전체게시물수
		int totPage = totalCnt/perPage;
		if (totalCnt%perPage!=0) totPage++; //나머지가 있으면 +1
		
		//4)페이지블럭의 시작페이지
		int startPage= curPage - ((curPage-1)%perBlock);
		//5)페이지블럭의 끝페이지
		int endPage = startPage + perBlock - 1;
		if (endPage>totPage) endPage=totPage; //endPage는 totPage보다 작거나 같아야 한다

		
		//page 세팅
		page.setStartNum(startNum);
		page.setEndNum(endNum);
		page.setStartPage(startPage);
		page.setEndPage(endPage);
		page.setTotPage(totPage);
		return replyListRepository.selectList(page);
	}

	@Override
	public ReplyList selectOne(int rnum) {
		return replyListRepository.selectOne(rnum);
	}
	
	@Transactional
	@Override
	public ErrorCode insert(ReplyList rList) throws Exception {
		replyListRepository.insert(rList);
		return ErrorCode.SUCCESS_ADD;
	}
	
	@Transactional
	@Override
	public ErrorCode update(ReplyList rList) throws Exception {
		replyListRepository.update(rList);
		return ErrorCode.SUCCESS_MODIFY;
	}

	@Override
	public int updateHelp(int rnum) {
		return replyListRepository.updateHelp(rnum);
	}

	@Override
	public int updateUseless(int rnum) {
		return replyListRepository.updateUseless(rnum);
	}

	@Override
	public ErrorCode updateRremoveyn(int rnum) {
		replyListRepository.updateRremoveyn(rnum);
		return ErrorCode.SUCCESS_REMOVE;
	}


}
