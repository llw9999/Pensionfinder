package com.mycompany.myapp.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService{
	//자동주입(DI),이름,타입
	//root-context.xml의 정의된 bean주입
	//@Autowired
	//private String savedir;
	
	//application.properties의 환경설정값
	@Value("${file.savedir}")
	private String savedir;
	
	
	@Override
	public String fileUpload(MultipartFile file) throws Exception {

		//파일을 업로드하고 파일명을 리턴
		String originFileName = file.getOriginalFilename();
		if (originFileName.equals("")) return ""; //파일 이름이 없을 경우
		//파일 이름이 겹치지 않도록 시스템날짜를 붙이기
		String filename = System.currentTimeMillis() + "_" + originFileName;
		
		//저장할 디렉토리 생성
		if (!new File(savedir).isDirectory()) { //경로명이 없다면
			Files.createDirectories(Paths.get(savedir)); //경로명 path생성 후 디렉토리 생성
		}
		
		//파일을 전송
		file.transferTo(new File(savedir, filename));
		
		return filename;
	}

	@Override
	public void fileDelete(String filename) throws Exception {
		// TODO Auto-generated method stub
		String savedirToday = savedir + "/20220621";
		File file = new File(savedirToday + "/" + filename);
		if (file.isFile()) {
			file.delete();
		}
	}

}
