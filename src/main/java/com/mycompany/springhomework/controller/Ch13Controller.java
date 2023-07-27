package com.mycompany.springhomework.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springhomework.dao.Ch13BoardDaoOld;
import com.mycompany.springhomework.dto.Ch11Member;
import com.mycompany.springhomework.dto.Ch13Board;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch13")
public class Ch13Controller {
	@Resource
	private Ch13BoardDaoOld boardDaoOld;

	@RequestMapping("/content")
	public String content() {
		return "ch13/content";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoard() {
		
		Ch13Board board = new Ch13Board();
		board.setBtitle("제목1");
		board.setBcontent("내용1");
		board.setMid("user");
		
		boardDaoOld.insert(board);
		return "redirect:/ch13/content";
	}
	
	@GetMapping("/getBoardList")
	public String getBoardList() {
		
		
		boardDaoOld.select();
		
		return "redirect:/ch13/content";
	
	}
	
	@GetMapping("/updateBoard")
	public String updateBoard() {
		
		boardDaoOld.updateBno();
		
		return "redirect:/ch13/content";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard() {
		log.info("실행");
		
		boardDaoOld.deleteByBno();
		
		return "redirect:/ch13/content";
	}
}