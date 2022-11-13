package com.codingdojo.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CountController {

	@RequestMapping("/index")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}else {
			Integer addOne = (Integer) session.getAttribute("count") +1;
			session.setAttribute("count", addOne);
		}
		return "index.jsp";
	}
	@RequestMapping("/showCount")
	public String showCount(HttpSession session) {
		return "showCount.jsp";
	}
	@RequestMapping("/countTwo")
	public String countTwo(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 2);
		}else {
			Integer addOne = (Integer) session.getAttribute("count") +2;
			session.setAttribute("count", addOne);
		}
		return "showCount.jsp";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		if (session.getAttribute("count")!=null) {
			session.setAttribute("count", null);
		}
		return "index.jsp";
	}
}
