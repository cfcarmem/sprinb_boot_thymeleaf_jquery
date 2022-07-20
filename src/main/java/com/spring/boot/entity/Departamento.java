package com.spring.boot.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_departamento")
public class Departamento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@OneToMany(mappedBy = "reldepartamento")
	private List<Funcionario> funcionario = new ArrayList<>();
	
	public Departamento(){}
	
	public Departamento(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
    
	@JsonIgnore
	public List<Funcionario> getPessoa() {
		return funcionario;
	}

	public void setPessoa(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

}
