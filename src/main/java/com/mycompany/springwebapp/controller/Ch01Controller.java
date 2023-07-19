package com.mycompany.springwebapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch01")
public class Ch01Controller {
	private static final Logger log = LoggerFactory.getLogger(Ch01Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		log.info("실행");
		
		return "ch01/content";
	}
	
	@RequestMapping("/button1")
	public String button1() {
		log.info("실행");
		
		return "ch01/content";
	}

	@RequestMapping("/button2")
	public String button2() {
		log.info("실행");
		
		return "redirect:/ch01/content";
	}
}
