package com.example.app.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.Reserve;
import com.example.app.service.LiveService;
import com.example.app.service.ReserveService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin/reserve")
@RequiredArgsConstructor
public class ReserveController {
	
	private final int NUM_PER_PAGE=5;
	private final ReserveService service;
	private final LiveService liveService;
	

	@GetMapping("/list")
	public String list(
			@RequestParam(name="page",defaultValue="1")Integer page,
			Model model) {
		model.addAttribute("reserves",
				service.getReserveListByPage(page, NUM_PER_PAGE));
				 model.addAttribute("page", page);
				 model.addAttribute("totalPages",
				service.getTotalPages(NUM_PER_PAGE));
		return "admin/reserve/list";
	}

	
	@GetMapping("/add")
	public String addget(Model model) {
		model.addAttribute("title","予約の追加");
		model.addAttribute("reserve",new Reserve());
		model.addAttribute("isNew",true);
		model.addAttribute("liveList", liveService.getLiveList());
			return "admin/reserve/form";
	}

	@PostMapping("/add")
	public String addPost(
			@Valid Reserve reserve,
			Errors errors,
			RedirectAttributes rd,
			Model model) {
		if (errors.hasErrors()) {
			model.addAttribute("title", "予約の追加");
			model.addAttribute("isNew",true);
			model.addAttribute("reserve", new Reserve());
		
			return "admin/reserve/form";
		}
		service.addReserve(reserve);
		rd.addFlashAttribute("statusMessage", "予約を追加しました。");
		return "redirect:/admin/reserve/list";
	}
	
	@GetMapping("/edit/{reserveId}")
	public String editGet(@PathVariable("reserveId") Integer reserveId, Model model) {
		model.addAttribute("title", "予約の変更");
		model.addAttribute("reserve", service.selectByReserveId(reserveId));
		model.addAttribute("isNew", false);
		model.addAttribute("liveList", liveService.getLiveList());	
		return "admin/reserve/form";
	}

	@PostMapping("/edit/{reserveId}")
	public String editPost(
			@PathVariable("reserveId") Integer reserveId,
			@Valid Reserve reserve,
			Errors errors,
			RedirectAttributes rd,
			Model model) {
		if (errors.hasErrors()) {
			model.addAttribute("title", "予約の変更");
			model.addAttribute("isNew", false);
			return "admin/reserve/form";
		}
		
		 reserve.setReserveId(reserveId);
		
		service.editReserve(reserve);
		rd.addFlashAttribute("statusMessage", "予約を変更しました。");
		return "redirect:/admin/reserve/list";
	}

	@GetMapping("/delete/{reserveId}")
	public String delete(@PathVariable Integer reserveId,
			RedirectAttributes rd) {
		service.deleteReserve(reserveId);
		rd.addFlashAttribute("statusMessage", "予約を削除しました。");
		return "redirect:/admin/reserve/list";
	}

}
