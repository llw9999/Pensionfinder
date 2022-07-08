package com.mycompany.myapp.repository;

import java.util.List;
import java.util.Map;

import com.mycompany.myapp.dto.JoinPension;

public interface JoinPensionRepository {
	int insert(JoinPension joinpension);
	int update(JoinPension joinpension);
	int delete(String pemail);
	JoinPension selectOne(String pemail);
	List<JoinPension> selectList(Map<String, String>map);
	int update_emailauth(String pemail);	
}
