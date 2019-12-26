package com.bigdata2019.email.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigdata2019.email.repository.EmailRepository;
import com.bigdata2019.email.vo.EmailVo;

@Controller
public class EmailController {

	@Autowired
	private EmailRepository emailRepository;
	
	//dispatcher서블릿에 / -> 되어있기 때문에 리퀘스트 맵핑부분은 공백으로 설정.
	@RequestMapping({"", "/index", "/list"})
	public String index(Model model) {		
		List<EmailVo> list = new ArrayList<EmailVo>();
		list = emailRepository.findAll();
		model.addAttribute("list", list);
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping("/form")
	public String form() {		
		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping("/add")
	public String add(EmailVo vo) {		
		emailRepository.insert(vo);
		return "redirect:/";
	}	
}
