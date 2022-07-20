package com.spring.boot.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nome;
	@Column
	private String documento;
	@Column
	LocalDateTime dtcadastro = LocalDateTime.now();
	
	@Column
	private String login = "usu";
	
	@Column
	private String senha = "123";
	
	
	public Pessoa() {}



	public Pessoa(Long id, String nome, String documento, LocalDateTime dtcadastro, String login, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.documento = documento;
		this.dtcadastro = dtcadastro;
		this.login = login;
		this.senha = senha;
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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public LocalDateTime getDtcadastro() {
		return dtcadastro;
	}

	public void setDtcadastro(LocalDateTime dtcadastro) {
		this.dtcadastro = dtcadastro;
	}

	
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
		
	
	
	
	

}
