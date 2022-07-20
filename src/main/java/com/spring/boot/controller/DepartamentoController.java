package com.spring.boot.controller;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.controller.service.DepartamentoService;
import com.spring.boot.entity.Departamento;

@Controller
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService service;
	
	
	@GetMapping(value="/cadastrodepartamento")
	public String getAll(Model model) {
		model.addAttribute("listadepartamentos", service.findAll());
		return "cadastro/departamento";
	}
	
	@RequestMapping(value="/buscardepartamento", method = {RequestMethod.GET})
	@ResponseBody //retorna um json
	public Optional<Departamento> getForId(Long iddepartamento , Model model){
		model.addAttribute("listadepartamentos", service.getFindId(iddepartamento));
		return service.getFindId(iddepartamento);
	}
	
	
	@RequestMapping(value="/editar", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
	public String updateDepartamento(Departamento depto) {
		service.salvar(depto);
		return "redirect:/cadastrodepto";
		
	}
	
	@RequestMapping(value="/salvar", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
	public String addDepartamento(Departamento departamento) {
		service.salvar(departamento);
		return "redirect:/cadastrodepto";
	}
	
	@RequestMapping(value="/deletar", method = {RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
	public String deleteDepartamento(Long iddepartamento) {
		service.deleteDepartamento(iddepartamento);
		return "redirect:/cadastrodepto";
	}
	
	

}
