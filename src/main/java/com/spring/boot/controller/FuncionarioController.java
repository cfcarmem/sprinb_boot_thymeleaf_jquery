package com.spring.boot.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.controller.service.DepartamentoService;
import com.spring.boot.controller.service.FuncionarioService;
import com.spring.boot.entity.Departamento;
import com.spring.boot.entity.Funcionario;

import antlr.collections.List;

@Controller
public class FuncionarioController {
	private static final DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	@Autowired
	private FuncionarioService fservice;
	@Autowired
	private DepartamentoService dservice;

	@RequestMapping("/goHome")
	public String home() {
		return "index";
	}
	
	@GetMapping("/cadastrofuncionario")
	public String listar(Model model) {
		model.addAttribute("listafuncionarios", fservice.listarTodos());
		model.addAttribute("listadepartamentos", dservice.findAll());
		return "/cadastro/funcionario";
	}
	
	
	
	@RequestMapping(value="/salvarfuncionario", method = {RequestMethod.POST})
	public String addFuncionario(Funcionario funcionario) {
		fservice.addFunc(funcionario);
		return "redirect:/cadastrofuncionario";
	}
	
	
	@RequestMapping(value="/buscarporid", method = {RequestMethod.GET})
	@ResponseBody
	public Optional<Funcionario>procurarId(Long idfuncionario , Model model){
		model.addAttribute("listadepartamentos", dservice.findAll()); 
		Optional<Funcionario> f = fservice.procurarPorId(idfuncionario);
		//Vamos selecionar o departamento que está gravado no funcionário selecionado
		Optional<Departamento> d   =  dservice.getFindId(f.get().getReldepartamento().getId());
		//para comparar no select selected. Mas estamos selecionando com jquery
		model.addAttribute("selecionado", f.get().getReldepartamento().getId());
		return fservice.procurarPorId(idfuncionario);
	}
	
	@RequestMapping(value="/editarfuncionario", method = {RequestMethod.POST})
	public String updateFuncionario(Funcionario funcionario) {
		fservice.addFunc(funcionario);
		return "redirect:/cadastrofuncionario";
	}
	
	
	@RequestMapping(value="/deletarporid", method = {RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
	public String deleteDepartamento(Long idfuncionario) {
		fservice.deleteFuncId(idfuncionario);
		return "redirect:/cadastrofuncionario";
	}

	@PostMapping("/findSearchFull")
	public String fullSearchFunc(String nomepesquisar, Model model) {
		model.addAttribute("listadepartamentos", dservice.findAll());
		model.addAttribute("listafuncionarios", fservice.fullSearchFunc(nomepesquisar));
		return "/cadastro/funcionario";
	}
	
	
	@PostMapping("/findSearchFullModelAndView")
	public ModelAndView pesquisarf(@RequestParam("nomepesquisar") String nomepesquisar) {
		ModelAndView model = new ModelAndView("/cadastro/funcionario");
		model.addObject("listafuncionarios", fservice.fullSearchFunc(nomepesquisar));
		return model;
	}
	
}
