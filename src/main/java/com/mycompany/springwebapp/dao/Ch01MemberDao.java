package com.mycompany.springwebapp.dao;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class Ch01MemberDao {
	public Ch01MemberDao() {
		log.info("실행");
	}
}
