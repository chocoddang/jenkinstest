package com.koreait.ex10.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.ex10.domain.Notice;
import com.koreait.ex10.service.NoticeService;

@Controller
@RequestMapping("notice")
public class NoticeController {

	@Autowired
	private NoticeService service;
	
	//method만들 차례
	@GetMapping(value="selectNoticeList")
	public String selectNoticeList(Model model) {
		model.addAttribute("list", service.selectNoticeList());
		return "notice/list";
	}
	
	
	@GetMapping(value="noticePage")
	public String noticePage() {
		return "notice/insert";
	}
	
	
	@PostMapping(value="insertNotice")  // title, content  받는 방법
	public void insertNotice(Notice notice, HttpServletResponse response) {
		service.insertNotice(notice, response);
	}
	
	
	
	@GetMapping(value="selectNoticeByNo")
	public String selectNoticeByNo(@RequestParam("no") Long no, Model model) {
		model.addAttribute("notice", service.selectNoticeByNo(no));
		return "notice/detail";
	}
	
	
	@GetMapping(value="updateNotice")
	public void updateNotce(Notice notice, HttpServletResponse response) {
		service.updateNotice(notice, response);
	}
	
	
	@GetMapping(value="deleteNotice")
	public void deleteNotice(@RequestParam("no") Long no, HttpServletResponse response) {
		service.deleteNotice(no, response);
	}
}
