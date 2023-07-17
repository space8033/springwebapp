package com.mycompany.springwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HouseController {
	
	@RequestMapping("/")
	public String hello() {
		log.info("실행1");
		log.info("실행2");
		return "index";
	}
	
}
