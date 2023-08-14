package com.kh.springbootthemeleaf.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class MyInfo {
	private String id;
	private String name;
	private String email;
	private Integer age;
	private String gender;
	
}
