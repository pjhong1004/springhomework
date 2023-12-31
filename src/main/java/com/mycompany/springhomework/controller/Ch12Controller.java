package com.mycompany.springhomework.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springhomework.service.Ch12ServiceCreateByXml;
import com.mycompany.springhomework.service.Ch12ServiceDIByAnnotation;
import com.mycompany.springhomework.service.Ch12ServiceDIByXml;
import com.mycompany.springhomework.service.Ch12ServicePropertyDi;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch12")
public class Ch12Controller {
	Ch12ServiceCreateByXml a = new Ch12ServiceCreateByXml();
	
	@Autowired
	private Ch12ServiceDIByXml serviceDIByXml;
	
	@Autowired
	private Ch12ServiceDIByAnnotation serviceDIByAnnotation;
	
	@Resource
	private Ch12ServicePropertyDi servicePropertyDi;
	
	@RequestMapping("/content")
	public String content(HttpSession session) {
		a.method1();
		serviceDIByXml.method();
		serviceDIByAnnotation.method();
		servicePropertyDi.method();
		return "ch12/content";
	}
	
	
}
