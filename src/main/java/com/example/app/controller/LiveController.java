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

import com.example.app.domain.Live;
import com.example.app.service.LiveService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin/live") //共通の部分まではクラス共通でここに書く
@RequiredArgsConstructor
public class LiveController {

	private final int NUM_PER_PAGE=5;
	private final LiveService service;
	

	@GetMapping("/list")
	public String list(
			@RequestParam(name="page",defaultValue="1")Integer page,
			Model model) {
		model.addAttribute("lives",
				service.getLiveListByPage(page, NUM_PER_PAGE));
				 model.addAttribute("page", page);
				 model.addAttribute("totalPages",
				service.getTotalPages(NUM_PER_PAGE));
		return "admin/live/list";
	}

	@GetMapping("/add")
	public String addGet(Model model) {
		model.addAttribute("title", "ライブの追加");
		model.addAttribute("live", new Live()); 
		model.addAttribute("isNew", true);
		return "admin/live/form";
	}

	@PostMapping("/add")
	public String addPost(
			@Valid Live live,
			Errors errors,
			RedirectAttributes rd,
			Model model) {
		if (errors.hasErrors()) {
			model.addAttribute("title", "ライブの追加");
			model.addAttribute("isNew", true);
			return "admin/live/form";
		}
		service.addLive(live);
		rd.addFlashAttribute("statusMessage", "ライブ情報を追加しました。");
		return "redirect:/admin/live/list";
	}

	@GetMapping("/edit/{liveId}")
	public String editGet(@PathVariable("liveId") Integer liveId, Model model) {
		model.addAttribute("title", "ライブ情報の変更");
		model.addAttribute("live", service.getLiveById(liveId));
		model.addAttribute("isNew", false);
		return "admin/live/form";
	}

	@PostMapping("/edit/{liveId}")
	public String editPost(
			@PathVariable("liveId") Integer liveId,
			@Valid Live live,
			Errors errors,
			RedirectAttributes rd,
			Model model) {
		if (errors.hasErrors()) {
			model.addAttribute("title", "ライブ情報の変更");
			model.addAttribute("isNew", false);
			return "admin/live/form";
		}
		service.editLive(live);
		rd.addFlashAttribute("statusMessage", "ライブ情報を変更しました。");
		return "redirect:/admin/live/list";
	}

	@GetMapping("/delete/{liveId}")
	public String delete(@PathVariable Integer liveId,
			RedirectAttributes rd) {
		service.deleteLive(liveId);
		rd.addFlashAttribute("statusMessage", "ライブ情報を削除しました。");
		return "redirect:/admin/live/list";
	}
}
