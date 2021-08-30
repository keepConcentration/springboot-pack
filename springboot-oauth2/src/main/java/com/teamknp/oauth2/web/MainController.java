package com.teamknp.oauth2.web;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	private final HttpSession httpSession;
	
	@GetMapping("/oauth")
	public String index(Model model, Principal principal) {
		User user = (User) httpSession.getAttribute("user");
		
		if (user != null) {
			model.addAttribute("user", user);
		}
		return "index";
	}
}
