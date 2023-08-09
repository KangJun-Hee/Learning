package com.kh.springbasic.member.model.dao;

import java.util.List;

import com.kh.springbasic.member.model.vo.Member;

/*
 * 
 * DI 설계 - spring에서는 interface설계를 권장한다.
 * 
 * 사유 
 * 1. 설계 이점이 존재, 개발하기 전에 기능을 클래스에서 정의 가능하고 미리 정리하기 위해 작성
 * 2. 느슨한 결합으로 실제 코드부가 변경되는 일이 없고 인터페이스만 정리하면 된다.
 * 3. 같은 interface를 상속 받았지만 전혀 다른 객체를 생성할 수 도 있다. 
 * 
 */
public interface MemberDao {

	int insertMember(Member member);
	List<Member> selectAll();
	Member selectById(String id);
	
}





