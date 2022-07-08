package com.mycompany.myapp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.myapp.advice.ErrorCode;
import com.mycompany.myapp.dto.Page;
import com.mycompany.myapp.dto.PensionFile;
import com.mycompany.myapp.dto.PensionList;
import com.mycompany.myapp.repository.PensionFileRepository;
import com.mycompany.myapp.repository.PensionListRepository;

@Service
public class PensionListServiceImpl implements PensionListService {
	@Autowired
	private PensionListRepository pensionListRepository;
	@Autowired
	private PensionFileRepository pensionFileRepository;
	
	@Autowired
	private FileService fileService;
	
	@Override
	public List<PensionList> selectList(Page page) {
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
				int totalCnt = pensionListRepository.selectTotalCnt(page); //전체게시물수
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
				
				return pensionListRepository.selectList(page);
			}

	@Override
	public PensionList selectOne(int pnum) {
		return pensionListRepository.selectOne(pnum);
	}
	
	//트랜잭션 관리(commit/rollback)
	@Transactional
	@Override
	public ErrorCode insert(PensionList pList) throws Exception {
		//1)게시물 추가
		//insert시 pnum세팅
		pensionListRepository.insert(pList);
		System.out.println(pList);
		
		//2)게시물 파일들 업로드 후 저장
		pensionFilesSave(pList);
		return ErrorCode.SUCCESS_ADD;
	}
	
	//트랙잭션 관리
	@Transactional
	@Override
	public ErrorCode update(PensionList pList, List<Integer> removeFiles) throws Exception {
		//1) 게시물 수정
		pensionListRepository.update(pList);
		//2) 게시물 파일 db 삭제
		if (removeFiles!=null) {
			for (int pfnum : removeFiles) {
				pensionFileRepository.delete(pfnum);
			}
		}
		//3) 게시물 파일들 업로드 후 저장
		pensionFilesSave(pList);
		
		return ErrorCode.SUCCESS_MODIFY;
	}
	
	private void pensionFilesSave(PensionList pList) throws Exception {
		//게시물 파일들 저장
		List<MultipartFile> files = pList.getFiles();
		for(MultipartFile file:files) {
			String filename = fileService.fileUpload(file); //파일 저장
			if (filename.equals("")) continue; //파일 이름이 공백이면 저장 불가
			
			//게시물 파일 db 저장
			PensionFile pensionFile = new PensionFile();
			pensionFile.setPnum(pList.getPnum()); //게시물의 pnum세팅
			pensionFile.setFilename(filename);
			pensionFileRepository.insert(pensionFile);
		}
	}
	
	@Override
	public ErrorCode updateRemoveyn(int pnum) {
		pensionListRepository.updateRemoveyn(pnum);
		return ErrorCode.SUCCESS_REMOVE;
	}

	@Override
	public int updateLikes(int pnum) {
		return pensionListRepository.updateLikes(pnum);
	}

	@Override
	public int updateDislikes(int pnum) {
		return pensionListRepository.updateDisLikes(pnum);
	}
	
}