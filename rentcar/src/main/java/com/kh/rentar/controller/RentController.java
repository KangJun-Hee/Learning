package com.kh.rentar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RentController {
	@GetMapping("/renthome")
	public String gohome() {
		
		return "home";
	}
}
