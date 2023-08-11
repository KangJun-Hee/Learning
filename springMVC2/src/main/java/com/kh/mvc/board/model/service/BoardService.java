package com.kh.mvc.board.model.service;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.mvc.board.model.mapper.BoardMapper;
import com.kh.mvc.board.model.vo.Board;
import com.kh.mvc.board.model.vo.Reply;

@Service
public class BoardService {
	@Autowired
	private BoardMapper mapper;
	
	//save method
	public int saveBoard(Board board) {
		int result = 0;
		
		if(board.getNo() == 0) {
			result = mapper.insertBoard(board);
		} else {
			result = mapper.updateBoard(board);
		}
		
		return result;
	}
	
	public int saveReply(Reply reply) {
		return mapper.insertReply(reply);
	}
	
	//upload download, save file
	public String saveFile(MultipartFile upFile,String savePath) {
		File folder = new File(savePath);
		
		//폴더없으면 만드는코드
		if(folder.exists() == false) {
			folder.mkdir();	//폴더만드는 거임
		}
		
		System.out.println("savePath:"+savePath);
		
		//change filename randomly
		//파일명 작성, 현재시간 포맷설정
		String originalFileName = upFile.getOriginalFilename();
		
		String reNameFileName = 
				LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmssSSS"));
		
		//현재이름 origi+reName 연결
		reNameFileName += originalFileName.substring(originalFileName.lastIndexOf("."));
		
		String reNamePath = savePath+"/"+reNameFileName;
		
		try {
			//실제파일 저장되는 코드
			
		} catch (Exception e) {
			return null;
		}
		
		return reNameFileName;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
