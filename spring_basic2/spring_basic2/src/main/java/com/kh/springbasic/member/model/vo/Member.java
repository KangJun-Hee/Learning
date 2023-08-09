package com.kh.springbasic.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor   //매개변수 모두 받는 생성자
@NoArgsConstructor 	  // 기본생성자 
@Getter
@Setter
@Data

public class Member {
	private String id;
	private String name;
	private int age;
	private String gender;
	private String address; // forrm에는 존재하지 않음
	private String[] devLang; // 개발 가능한 언어-> 배열로 처리 예정
}
