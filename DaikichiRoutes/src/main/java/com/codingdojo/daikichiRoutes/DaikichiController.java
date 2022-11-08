package com.codingdojo.daikichiRoutes;

import org.springframework.web.bind.annotation.PathVariable;
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
	@RequestMapping("/travel/{city}")
	public String travel(@PathVariable("city")String city) {
		return "Congrats, you will soon travel to "+city+"!";
	}
	@RequestMapping("/lotto/{num}")
	public String lotto(@PathVariable("num")int num) {
		if(num % 2 ==0) {
			return "You will take a grand journey in the near future, but be wary of tempting offers.";
		}else {
			return "You have enjoyed the fruits of your labor, but now is a great time to spend time with family and friends";
		}
	}
}
