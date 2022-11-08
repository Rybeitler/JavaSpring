package com.codingdojo.daikichiRoutes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	@RequestMapping("")
	public String home() {
		return "Welcome";
	}
	@RequestMapping("/today")
	public String today() {
		return "This is todays fortune";
	}
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "this is tommmorows fortune";
	}
}
