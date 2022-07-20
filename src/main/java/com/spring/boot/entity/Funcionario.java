package com.spring.boot.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="tbl_funcionario")
public class  Funcionario extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate nascimento;
	@Column
	private Double salario;
	
   //1 funcionário é de um departamento. Um departamento tem vários funcionários
	@ManyToOne
	@JoinColumn(name="id_departamento")
	Departamento reldepartamento;
	
	@JsonIgnore
	@OneToMany(mappedBy = "gestor",fetch = FetchType.EAGER)
	private Set<Projeto> projetos = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "equipepk.funcionario",fetch = FetchType.EAGER)
	private Set<ProjetoFuncionario> equipe  = new HashSet<>();
	

	public Funcionario(Long id, String nome, String documento, LocalDateTime dtcadastro, String login, String senha,
			LocalDate nascimento, Double salario, Departamento reldepartamento) {
		super(id, nome, documento, dtcadastro, login, senha);
		this.nascimento = nascimento;
		this.salario = salario;
		this.reldepartamento = reldepartamento;
	}

	public Funcionario() {}
	
	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}


	public Departamento getReldepartamento() {
		return reldepartamento;
	}

	public void setReldepartamento(Departamento reldepartamento) {
		this.reldepartamento = reldepartamento;
	}

	@JsonIgnore
	public Set<Projeto> getProjetos() {
		return projetos;
	}
	
	@JsonIgnore
	public Set<ProjetoFuncionario> getEquipe() {
		return equipe;
	}

}
