package com.kh.mustache.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlbumController {
	@GetMapping("/Album")
	public String bringHome(Model model) {
		
		return "viewpagename";
	}
}
