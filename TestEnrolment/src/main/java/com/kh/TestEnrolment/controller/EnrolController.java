package com.kh.TestEnrolment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnrolController {

	@GetMapping("/Articles/page")
	public String goPage() {
		return "Articles/page";
	}
}
