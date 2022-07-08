package com.mycompany.myapp.service;

import java.util.List;

import com.mycompany.myapp.dto.PensionFile;

public interface PensionFileService {
	//PensionFile db에 접근
	List<PensionFile> selectList(int pnum);
}
