package com.codingdojo.helloHuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	@RequestMapping("/")
	public String home(@RequestParam(value="name", required=false)String myName, @RequestParam(value="last", required=false)String last, @RequestParam(value="times", required=false)Integer times) {
		if(times == null) {
			if(myName == null) {
				return "Hello Human!";
			}else {
				if(last == null) {
					return "Hello " + myName + "!";
				}else {
					return "Hello " + myName +" "+ last + "!";
				}
			}
		}else {
				if(myName == null) {
					String message = "Hello Human! ";
					String x = "";
					for (int i=0; i<times; i++) {
						x = x.concat(message);
					}
					return x; 
				}else {
					if(last == null) {
						String message = "Hello " + myName + "! ";
						String x = "";
						for (int i=0; i<times; i++) {
							x = x.concat(message);
						}
						return x;
					}else {
						String message = "Hello " + myName +" "+ last + "! ";
						String x = "";
						for (int i=0; i<times; i++) {
							x = x.concat(message);
						}
						return x;
					}
				}
			}
	}
}
