package com.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {
	
	@RequestMapping("/x")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/")
	public String princial() {
		return "cadastro/principal";
	}
	
	@RequestMapping("/menu")
	public String carregarMenu() {
		return "/cadastro/menu";
	}
	
	@RequestMapping("/cadastroprojetos")
	public String projetos() {
		return "/cadastro/projeto";
	}
	
	@RequestMapping("/projeto_listar")
	public String carregarProjetos() {
		return "/cadastro/projeto_listar";
	}
	
	
		
	@RequestMapping("/projetoequipe")
	public String projetosf() {
		return "/cadastro/equipe";
	}
 
	@RequestMapping("/projetoequipelistar")
	public String projetoslistarequipe() {
		return "/cadastro/equipe_listar";
	}
 

}
