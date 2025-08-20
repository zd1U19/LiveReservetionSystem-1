package com.example.app.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.Reserve;
import com.example.app.service.LiveService;
import com.example.app.service.ReserveService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class MemberController {

	private final LiveService liveService;
	private final ReserveService reserveService;

	@GetMapping("/member/home") //全件表示
	public String list(Model model) {
		model.addAttribute("lives", liveService.getLiveList());
		return "member/home";
	}

	@GetMapping("/reserve")
	public String addget(Model model) {
		model.addAttribute("title","予約の追加");
		model.addAttribute("reserve",new Reserve());
		model.addAttribute("liveList", liveService.getLiveList());
			return "member/reserve";
	}

	@PostMapping("/reserve")
	public String addPost(
			@Valid Reserve reserve,
			Errors errors,
			RedirectAttributes rd,
			Model model) {
		if (errors.hasErrors()) {
			model.addAttribute("title", "予約の追加");
			model.addAttribute("reserve", new Reserve());
			return "member/reserve/";
		}
		reserveService.addReserve(reserve);
		rd.addFlashAttribute("statusMessage", "予約を追加しました。");
		return "redirect:/member/reserve";
}
}
