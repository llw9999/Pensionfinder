package com.mycompany.myapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.advice.ErrorCode;
import com.mycompany.myapp.dto.Reserve;
import com.mycompany.myapp.repository.ReserveRepository;

@Service
public class ReserveServiceImpl implements ReserveService {
	
	
	
	@Autowired
	ReserveRepository reserveRepository;
	
	@Override
	public ErrorCode insert(Reserve reserve) throws Exception {
		
		int insertcheck = reserveRepository.insertcheck(reserve);
		
		if(insertcheck == 0) {
			reserveRepository.insert(reserve);
			return ErrorCode.SUCCESS_RESERVE;
		} else {
			return ErrorCode.ERROR_RESERVE;
		}
	}

	@Override
	public ErrorCode updateRremoveyn(int rnum) throws Exception {
		reserveRepository.updateRremoveyn(rnum);
		return ErrorCode.SUCCESS_REMOVE_RESERVE;
	}

	@Override
	public List<Reserve> selectList(int pnum) {
		return reserveRepository.selectList(pnum);
	}

	@Override
	public List<Reserve> mselectList(String memail) {
		return reserveRepository.mselectList(memail);
	}

}
