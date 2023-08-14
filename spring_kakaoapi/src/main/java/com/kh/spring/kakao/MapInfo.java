package com.kh.spring.kakao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MapInfo {
	private String name;
	private String address;
	private double x;//위도
	private double y;//경도

	
}
