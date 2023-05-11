package com.ilci.magasin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ilci.magasin.MyServices;
import com.ilci.magasin.entity.Produit;
import com.ilci.magasin.repository.ProduitRepository;


@Controller
public class ArticleController {
	
	@Autowired
	ProduitRepository produitRepository;

	@GetMapping("/article/articles")
	public String articles(ModelMap model) {
		model.addAttribute("articles", produitRepository.findAll());
		return "articles/index";
	}

	@GetMapping("/article/new")
	public String newArticle(ModelMap model) {
		model.addAttribute("article", new Produit());
		return "articles/new";
	}

	@PostMapping("article/add")
	public String addArticle(
			@ModelAttribute("article") Produit produit, 
			@RequestParam("logo") MultipartFile multipartFile
			) {
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		
		
		if( !fileName.isEmpty() ) {
			String uploadDir = "src\\main\\resources\\static\\images\\articles\\";
			
			MyServices.uploadFile(fileName, uploadDir, multipartFile);

			produit.setImage(fileName);
			
			produitRepository.save(produit);
			return "redirect:/article/articles";
		}

		
		return "articles/index";
	}

}







