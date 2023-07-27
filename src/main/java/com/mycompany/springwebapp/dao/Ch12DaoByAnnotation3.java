package com.mycompany.springwebapp.dao;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class Ch12DaoByAnnotation3 {
	
	public void method() {
		log.info("실행");
	}
}
