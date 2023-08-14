package com.kh.spring.kakaocontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.kakao.MapInfo;

@Controller
public class KakaoController {
	@RequestMapping("/kakaoMap1")
	String kakaoMap1(Model model) {
		
		List<MapInfo> mapList = new ArrayList<MapInfo>();
		
		//원하는 위도경도를 찾아 저장하면 된다
		mapList.add(new MapInfo("생태연못","제주시 어쩌구",33.450936,126.569477));
		mapList.add(new MapInfo("텃밭","제주시 어쩌구",33.450879,126.569940));
		mapList.add(new MapInfo("근린공원","제주시 어쩌구",33.451393,126.570738));

		double x = 0.0;
		double y = 0.0;
		
		for (MapInfo map : mapList) {
			x += map.getX();
			y += map.getY();
		}
		
		x = x / mapList.size();
		y = y / mapList.size();
		
		model.addAttribute("mapList",mapList);
		
		model.addAttribute("x", x);
		model.addAttribute("y", y);
		
		return "/kakao/kakaoMap1";
	}
	
	@RequestMapping("/kakaoMap2")
	String kakaoMap2(Model model) {
		
		List<MapInfo> mapList = new ArrayList<MapInfo>();
		
		//원하는 위도경도를 찾아 저장하면 된다
		mapList.add(new MapInfo("생태연못","제주시 어쩌구",33.450936,126.569477));
		mapList.add(new MapInfo("텃밭","제주시 어쩌구",33.450879,126.569940));
		mapList.add(new MapInfo("근린공원","제주시 어쩌구",33.451393,126.570738));

		double x = 0.0;
		double y = 0.0;
		
		for (MapInfo map : mapList) {
			x += map.getX();
			y += map.getY();
		}
		
		x = x / mapList.size();
		y = y / mapList.size();
		
		model.addAttribute("mapList",mapList);
		
		model.addAttribute("x", x);
		model.addAttribute("y", y);
		
		return "/kakao/kakaoMap2";
	}
}
