package com.spring.boot.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.boot.entity.enumerator.StatusProjeto;


@Entity
@Table(name="tb_projeto")
public class Projeto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	//1 funcionário pode ser gestor de vários projetos. 1 Projeto só tem  1 gestor
	@ManyToOne
	@JoinColumn(name="id_funcionario")  //informa a chave estrangeira
	private Funcionario gestor;
	

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate inicio;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate fim;
	private Integer statusprojeto;
	
	@OneToMany(mappedBy = "equipepk.projeto",fetch = FetchType.EAGER)
	private Set<ProjetoFuncionario> projetos = new HashSet<>();
	
	public Projeto() {}

	public Projeto(Long id, String nome, Funcionario gestor, LocalDate inicio, LocalDate fim, Integer statusprojeto) {
		super();
		this.id = id;
		this.nome = nome;
		this.gestor = gestor;
		this.inicio = inicio;
		this.fim = fim;
		this.statusprojeto = statusprojeto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFim() {
		return fim;
	}

	public void setFim(LocalDate fim) {
		this.fim = fim;
	}

	public StatusProjeto getStatusprojeto() {
		return StatusProjeto.valueOf(statusprojeto);
	}

	public void setStatusprojeto(StatusProjeto statusprojeto) {
		if(statusprojeto != null) {
			this.statusprojeto = statusprojeto.getCode();
		}
	}
	
	@JsonIgnore
	//vamos pegar todos os funcionários da equipe
	public Set<Funcionario> getProjetos() {
		//pegar  os funcionarios que faz parte da equipe do projeto
		Set<Funcionario> sets = new HashSet<>();
		for(ProjetoFuncionario x: projetos) {
			sets.add(x.getFuncionario());
		}
		return sets;
	}
	
	
	@JsonProperty("gestor")
	public Funcionario getGestor() {
		return gestor;
	}
	 @JsonProperty("gestor")
	public void setGestor(Funcionario gestor) {
		this.gestor = gestor;
	}
	 

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		return Objects.equals(id, other.id);
	}

}
