package com.mycompany.springwebapp.service;

import java.util.List;

import com.mycompany.springwebapp.dao.Ch12DaoByXml1;
import com.mycompany.springwebapp.dao.Ch12DaoByXml2;
import com.mycompany.springwebapp.dao.Ch12DaoByXml3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch12ServiceDiByXml {
	//필드
	private Ch12DaoByXml1 daoByXml1;
	private Ch12DaoByXml2 daoByXml2;
	private Ch12DaoByXml3 daoByXml3;
	
	//생성자
	public Ch12ServiceDiByXml() {
		log.info("실행1");
	}
	//생성자
	public Ch12ServiceDiByXml(Ch12DaoByXml1 daoByXml1) {
		log.info("실행2");
		this.daoByXml1 = daoByXml1;
	}
	
	//Setters
	public void setCh12DaoByXml1(Ch12DaoByXml1 daoByXml1) {
		log.info("실행");
		this.daoByXml1 = daoByXml1;
	}
	public void setCh12DaoByXml2(Ch12DaoByXml2 daoByXml2) {
		log.info("실행");
		this.daoByXml2 = daoByXml2;
	}
	public void setCh12DaoByXml3(Ch12DaoByXml3 daoByXml3) {
		log.info("실행");
		this.daoByXml3 = daoByXml3;
	}
	
	public void setCollection1(List<String> list) {
		
		for(String item : list) {
			log.info(item);
		}
	}
	
	//인스턴스 메소드
	public void method() {
		daoByXml1.method();
		daoByXml2.method();
		daoByXml3.method();
	}
}
