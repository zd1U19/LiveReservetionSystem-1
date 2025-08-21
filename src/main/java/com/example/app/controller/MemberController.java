package com.example.app.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.Reserve;
import com.example.app.service.LiveService;
import com.example.app.service.ReserveService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

	private final LiveService liveService;
	private final ReserveService reserveService;

	@GetMapping("/home") //全件表示
	public String list(Model model) {
		model.addAttribute("lives", liveService.getLiveList());
		return "member/home";
	}

	@GetMapping("/reserve/{liveId}")
	public String addget(@PathVariable Integer liveId,
			Model model) {
		model.addAttribute("title","予約の追加");
		model.addAttribute("reserve",new Reserve());
		Reserve reserve=new Reserve();	
		reserve.setLiveId(liveId);
	    reserve.setLiveName(liveService.getLiveById(liveId).getLiveName()); // liveNameを取得してセット
	    model.addAttribute("reserve",reserve);
	    model.addAttribute("liveList", liveService.getLiveList());
	    return "member/reserve";
	}

	@PostMapping("/reserve/{liveId}")
	public String addPost(
			@Valid Reserve reserve,
			Errors errors,
			RedirectAttributes rd,
			Model model) {
		if (errors.hasErrors()) {
			model.addAttribute("title", "予約の追加");
			model.addAttribute("reserve", new Reserve());
			return "member/reserve";
		}
		reserveService.addReserve(reserve);
		rd.addFlashAttribute("statusMessage", "ご予約が完了しました！");
		return "redirect:/member/home";
		//return "redirect:/reserve/done/{liveId}";
}
}
