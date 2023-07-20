package com.mycompany.springwebapp.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.springwebapp.dto.Ch02FileInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch02")
public class Ch02Controller {
	
	@RequestMapping("/content")
	public String content() {
		
		return "ch02/content";
	}
	
	@RequestMapping(value="/method", method=RequestMethod.GET)
	public String method1(String bkind, int bno) {
		log.info("bkind: " + bkind);
		log.info("bno: " + bno);
		
		return "ch02/content";
	}

	@RequestMapping(value="/method", method=RequestMethod.POST)
	public String method2(String bkind, int bno) {
		log.info("bkind: " + bkind);
		log.info("bno: " + bno);
		
		return "ch02/content";
	}
	
	@PutMapping("/method")
	public void method3(@RequestBody String json, HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject(json);
		String bkind = jsonObject.getString("bkind");
		int bno = jsonObject.getInt("bno");
		log.info("bkind: " + bkind);
		log.info("bno: " + bno);
		
		JSONObject root = new JSONObject();
		root.put("result", "success");
		String responseJson = root.toString();
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.print(responseJson);
		pw.flush();
		pw.close();
		
	}
	
	@DeleteMapping("/method")
	public void method4(@RequestBody String json, HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject(json);
		int bno = jsonObject.getInt("bno");
		log.info("bno: " + bno);
		
		JSONObject root = new JSONObject();
		root.put("result", "success");
		String responseJson = root.toString();
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.print(responseJson);
		pw.flush();
		pw.close();
	}
	
	@GetMapping("/ajax1")
	public String ajax1() {
		
		return "ch02/fragmentHtml";
	}
	
	@GetMapping("/ajax2")
	public void ajax2(HttpServletResponse response) throws Exception {
		JSONObject root = new JSONObject();
		root.put("fileName", "photo5.jpg");
		String responseJson = root.toString();
		
		//직접 JSON 응답 생성
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.print(responseJson);
		pw.flush();
		pw.close();
	}
	
	@GetMapping(value="/ajax3", produces="application/json; charset=UTF-8")
	@ResponseBody //리턴값을 응답 본문에 바로 싣기
	public String ajax3(HttpServletResponse response) throws Exception {
		JSONObject root = new JSONObject();
		root.put("fileName", "photo6.jpg");
		String responseJson = root.toString();
		
		return responseJson;
	}

	@GetMapping(value="/ajax4", produces="application/json; charset=UTF-8")
	@ResponseBody //리턴값을 json으로 변환하여 (jackson-databind 라이브러리 필요) 응답 본문에 바로 싣기
	public Ch02FileInfo ajax4() {
		Ch02FileInfo fileInfo = new Ch02FileInfo();
		fileInfo.setFileName("photo7.jpg");
		
		return fileInfo;
	}
	
	
}
