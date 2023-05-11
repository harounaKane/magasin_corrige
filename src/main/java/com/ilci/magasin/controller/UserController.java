package com.ilci.magasin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ilci.magasin.entity.Personne;
import com.ilci.magasin.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	
	@GetMapping("/user/login")
	public String loginForm() {
		
		return "user/login";
	}
	
	@PostMapping("/login")
	public String login(
			@RequestParam String login, 
			@RequestParam String mdp,
			HttpSession session,
			RedirectAttributes attributes
			) {
		
		Personne user = userRepository.findPersonneByLoginAndMdp(login, mdp);
		
		if( user != null ) {
			session.setAttribute("user", user);
			attributes.addFlashAttribute("success", "Vous êtes connecté!");
			return "redirect:/";
		}
		
		//attributes.addFlashAttribute("error", "login et/ou mot de passe invalide !");
		return "user/login";
	}
	
	@GetMapping("/user/logout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:/";
	}
	

	@GetMapping("/logOn")
	public String logonForm(ModelMap model) {
		model.addAttribute("user", new Personne());
		return "user/logon";
	}
	
	@PostMapping("/user/logon")
	public String logon(@ModelAttribute Personne user) {
		user.setStatut(1);
		userRepository.save(user);
		
		return "redirect:/";
	}
}
