package com.mycompany.myapp.repository;

import java.util.List;

import com.mycompany.myapp.dto.PensionFile;

public interface PensionFileRepository {
	int insert(PensionFile pensionFile);
	int update(PensionFile pensionFile);
	int delete (int pfnum);
	PensionFile selectOne(int pfnum);
	List<PensionFile> selectList(int pnum);
}
