package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.service.LiveService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member/home")
@RequiredArgsConstructor
public class MemberController {
	
	private final LiveService service;
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("lives", service.getLiveList());
		return "member/home";
	}

}
