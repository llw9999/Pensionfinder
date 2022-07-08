package com.mycompany.myapp.service;

import java.util.List;
import java.util.Map;

import com.mycompany.myapp.advice.ErrorCode;
import com.mycompany.myapp.dto.ReplyList;
import com.mycompany.myapp.dto.Reserve;

public interface ReserveService {
	
	ErrorCode insert(Reserve reserve) throws Exception;
	
	ErrorCode updateRremoveyn(int rnum) throws Exception;
		
	List<Reserve> selectList(int pnum);
	
	List<Reserve> mselectList(String memail);
}
