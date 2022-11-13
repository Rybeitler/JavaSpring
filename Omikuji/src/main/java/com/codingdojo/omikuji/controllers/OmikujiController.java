package com.codingdojo.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {
	@GetMapping("/")
	public String index() {
		return "redirect:/omikuji";
	}
	@GetMapping("/omikuji")
	public String omikuji(HttpSession session) {
		if (session.getAttribute("number") != null) {
			session.removeAttribute("number");
			session.removeAttribute("city");
			session.removeAttribute("person");
			session.removeAttribute("profession");
			session.removeAttribute("thing");
			session.removeAttribute("nice");
		}
		return "omikuji.jsp";
	}
	@PostMapping("/omikuji/create")
	public String create(
			@RequestParam(value="number") Integer number,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="profession") String profession,
			@RequestParam(value="thing") String thing,
			@RequestParam(value="nice") String nice,
			HttpSession session
			) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("profession", profession);
		session.setAttribute("thing", thing);
		session.setAttribute("nice", nice);
		return "redirect:/omikuji/show";
	}
	@GetMapping("/omikuji/show")
	public String show(HttpSession session) {
		if(session.getAttribute("number")==null) {
			return "redirect:/omikuji";
		}else {
			return "showOmikuji.jsp";
		}
	}
}
