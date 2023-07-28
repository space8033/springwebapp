package com.mycompany.springwebapp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springwebapp.dao.Ch13BoardDao;
import com.mycompany.springwebapp.dao.Ch13BoardDaoOldImpl;
import com.mycompany.springwebapp.dto.Ch13Board;
import com.mycompany.springwebapp.dto.Ch13Pager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch13")
public class Ch13Controller {
	@Resource
	private Ch13BoardDaoOldImpl boardDaoOld;
	@Resource
	private Ch13BoardDao boardDao;
	
	
	@RequestMapping("/content")
	public String content() {
		
		return "ch13/content";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoard() {
		log.info("실행");
		
		Ch13Board board = new Ch13Board();
		board.setBtitle("고생한 시간");
		board.setBcontent("연봉: ");
		board.setMid("user");
		
		boardDao.insert(board);
		//boardDaoOld.insert(board);
		
		log.info("저장된 bno: " + board.getBno());

		
		//실제로 저장됨 bno
		return "redirect:/ch13/content";
	}
	
	@GetMapping("/getBoardList")
	public String getBoardList() {
		int totalRows = boardDao.count();
		Ch13Pager pager = new Ch13Pager(10, 5, totalRows, 3);
//		List<Ch13Board> list = boardDaoOld.selectAll();
		List<Ch13Board> list = boardDao.selectAll(pager);

		for(Ch13Board board : list) {
			log.info(board.toString());
		}
		
		return "redirect:/ch13/content";
	}
	
	@GetMapping("/updateBoard")
	public String updateBoard() {
		Ch13Board board = boardDaoOld.selectByBno(1);
		board.setBtitle("메롱");
		board.setBcontent("메롱메롱");
		
		boardDao.updateByBno(board);
		//boardDaoOld.updateByBno(board);
		
		return "redirect:/ch13/content";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Integer bno) {
		//boardDaoOld.deleteByBno(bno);
		bno = 21;
		boardDao.deleteByBno(bno);
		
		return "redirect:/ch13/content";
	}
}