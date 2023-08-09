package com.ncs.test.login.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
@Data
@ToString
public class Member {
	private String id;
	private String pw;

}
