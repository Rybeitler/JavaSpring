package com.codingdojo.dateTime.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DatetimeController {
	@GetMapping("/")
	public String index(Model model) {
		return "index.jsp";
	}
	@GetMapping("/date")
	public String date(Model model) {
		SimpleDateFormat day = new SimpleDateFormat("EEEEEEEEE,' the' d ' of' MMM, Y");
		Date dateTime = new Date();
		String date = day.format(dateTime);
		model.addAttribute("date", date);
		return "date.jsp";
	}
	@GetMapping("/time")
	public String time(Model model) {
		SimpleDateFormat time = new SimpleDateFormat("h:mm a");		
		Date dateTime = new Date();
		String theTime = time.format(dateTime);
		model.addAttribute("time", theTime);
		return "time.jsp";
	}
}
