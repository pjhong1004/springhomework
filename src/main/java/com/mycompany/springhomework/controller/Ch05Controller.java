package com.mycompany.springhomework.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch05")
public class Ch05Controller {
	@RequestMapping("/content")
	public String content() {
		return "ch05/content";
	}
	
	@RequestMapping("/getHeaderValue")
	public String getHeaderValue(@RequestHeader("User-Agent") String userAgent,
			HttpServletRequest request) {
		log.info("User-Agent: " + userAgent);
		log.info("Client IP: " + request.getRemoteAddr());
		return "redirect:/ch05/content";
	}
	
	@RequestMapping(value="/createCookie", method=RequestMethod.GET)
	public String createCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("useremail", "summer@mycompany.com");
		cookie.setDomain("localhost");
		cookie.setPath("/");
		cookie.setMaxAge(30*60);
		cookie.setHttpOnly(false);
		cookie.setSecure(false);
		response.addCookie(cookie);
		
		return "redirect:/ch05/content";
	}
	
	@RequestMapping(value="/getCookie", method=RequestMethod.GET)
	public String GetCookie(@CookieValue("useremail") String userEmail) {
		log.info("실행");
		log.info("useremail : " + userEmail);
		
		return "redirect:/ch05/content";
	}
}
