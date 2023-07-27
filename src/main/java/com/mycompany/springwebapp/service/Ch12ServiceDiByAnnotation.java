package com.mycompany.springwebapp.service;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycompany.springwebapp.dao.Ch12DaoByAnnotation1;
import com.mycompany.springwebapp.dao.Ch12DaoByAnnotation2;
import com.mycompany.springwebapp.dao.Ch12DaoByAnnotation3;
import com.mycompany.springwebapp.dao.Ch12DaoI;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Ch12ServiceDiByAnnotation {
	//필드
	//@Autowired
	private Ch12DaoByAnnotation1 daoByAnnotation1;
	private Ch12DaoByAnnotation2 daoByAnnotation2;
	private Ch12DaoByAnnotation3 daoByAnnotation3;
	
	@Resource(name="ch12DaoImpl2")
	private Ch12DaoI ch12DaoI;
	
	//생성자
	public Ch12ServiceDiByAnnotation() {
		log.info("실행1");
	}
	//생성자
	public Ch12ServiceDiByAnnotation(Ch12DaoByAnnotation1 daoByAnnotation1) {
		log.info("실행2");
		this.daoByAnnotation1 = daoByAnnotation1;
	}
	
	//Setters
	@Autowired
	public void setCh12DaoByAnnotation1(Ch12DaoByAnnotation1 daoByAnnotation1) {
		log.info("실행");
		this.daoByAnnotation1 = daoByAnnotation1;
	}
	@Autowired
	public void setCh12DaoByAnnotation2(Ch12DaoByAnnotation2 daoByAnnotation2) {
		log.info("실행");
		this.daoByAnnotation2 = daoByAnnotation2;
	}
	@Autowired
	public void setCh12DaoByAnnotation3(Ch12DaoByAnnotation3 daoByAnnotation3) {
		log.info("실행");
		this.daoByAnnotation3 = daoByAnnotation3;
	}
	
	
	public void setCollection1(List<String> list) {
		
		for(String item : list) {
			log.info(item);
		}
	}

	public void setCollection2(Set set) {
		log.info("아이템 수: " + set.size());
	}

	public void setCollection3(Map<String, Object> map) {
		log.info("아이템 수: " + map.size());
	}

	public void setCollection4(Properties prop) {
		log.info("아이템 수: " + prop.size());
	}
	
	//인스턴스 메소드
	public void method() {
		daoByAnnotation1.method();
		daoByAnnotation2.method();
		daoByAnnotation3.method();
		ch12DaoI.method();
	}
}
