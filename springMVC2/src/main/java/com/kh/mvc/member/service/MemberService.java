package com.kh.mvc.member.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mvc.member.mapper.MemberMapper;
import com.kh.mvc.member.model.vo.Member;

@Service
public class MemberService {

	@Autowired
	private MemberMapper mapper;
	
	public boolean validate(String userId) {
		return this.findById(userId) != null;
	}
	
	public Member login(String id,String pw) {
		//실제로그인시 아이디값 갖고와 DB에 있는 내용 확인 후 결과가 null
		Member member = mapper.selectMember(id);
		if(id.equals("admin")) {//admin 테스트위한 코드
			return member;
		}
		
		if(member == null) {
			return null;
		}else {
			return member;
		}
	}
	
	public int sava(Member member) {
		
		int result = 0;
		if(member.getNo() == 0) {//회원 가입
			result = mapper.insertMember(member);
		}else { //회원 수정
			
			result = mapper.updateMember(member);
		}
		
		
		return result;
	}
	
	public Member findById(String id) {
		return mapper.selectMember(id);
	}
	public int delete(int no) {
		return mapper.deleteMember(no);
	}
	
	
	public int updatePwd(Member loginMember,String userPW) {
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("no",""+loginMember.getNo());
		map.put("newPwd",userPW);
		
		return mapper.updatePwd(map);
		
	}
	
	
	
	
	
	
}
