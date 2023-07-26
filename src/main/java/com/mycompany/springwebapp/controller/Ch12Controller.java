package com.mycompany.springwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springwebapp.service.Ch12ServiceDiByXml;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch12")
public class Ch12Controller {
	@Autowired
	private Ch12ServiceDiByXml serviceDiByXml;
	
	@RequestMapping("/content")
	public String content() {
		serviceDiByXml.method();
		
		return "ch12/content";
	}
	
}