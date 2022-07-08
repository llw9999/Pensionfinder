package com.mycompany.myapp.repository;

import java.util.List;
import java.util.Map;

import com.mycompany.myapp.dto.JoinMember;

public interface JoinMemberRepository {
	
	int insert(JoinMember joinmember);
	int update(JoinMember joinmember);
	int delete(String memail);
	JoinMember selectOne(String memail);
	List<JoinMember> selectList(Map<String, String>map);
	int update_emailauth(String memail);
	
}
