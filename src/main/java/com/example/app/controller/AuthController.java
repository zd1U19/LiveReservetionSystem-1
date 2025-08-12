package com.example.app.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.Admin;
import com.example.app.service.AdminService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuthController {

	private final AdminService service;
	private final HttpSession session;

	@GetMapping("/admin/home")
	public String showHome(Model model) {
		model.addAttribute("admin", new Admin());
		return "admin/home";
	}

	@PostMapping("/admin/home")
	public String login(
			@Valid Admin admin,
			Errors errors,
			Model model) {
		// 入力に不備がある
		if (errors.hasErrors()) {
			return "admin/home";
		}

		String loginId = admin.getLoginId();
		String loginPass = admin.getLoginPass();
		// ログイン ID・パスワードが正しくない
		if (!service.isCorrectIdAndPassword(loginId, loginPass)) {
			errors.rejectValue("loginId", "error.incorrect_id_password");
			model.addAttribute("admin", admin);
			return "admin/home";
		}
		// 正しいログイン ID・パスワード
		// ⇒ セッションにログイン ID を格納し、リダイレクト
		session.setAttribute("loginId", loginId);
		return "redirect:/admin/home";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// セッションを破棄し、トップページへ遷移
		session.invalidate();
		return "redirect:/admin/home";
	}

}
