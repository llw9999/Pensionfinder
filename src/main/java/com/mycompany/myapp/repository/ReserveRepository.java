package com.mycompany.myapp.repository;

import java.util.List;
import java.util.Map;

import com.mycompany.myapp.dto.Reserve;

public interface ReserveRepository {
	
	int insert(Reserve reserve);

	int delete(int rnum);
	
	int updateRremoveyn(int rnum);
	
	List<Reserve> mselectList(String memail);
	
	List<Reserve> selectList(int pnum);
	
	int insertcheck(Reserve reserve);
	
}
