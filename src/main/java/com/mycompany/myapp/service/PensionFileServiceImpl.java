package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.dto.PensionFile;
import com.mycompany.myapp.repository.PensionFileRepository;

@Service
public class PensionFileServiceImpl implements PensionFileService{
	
	@Autowired
	private PensionFileRepository pensionFileRepository;
	
	@Override
	public List<PensionFile> selectList(int pnum) {
		return pensionFileRepository.selectList(pnum);
	}
	
}