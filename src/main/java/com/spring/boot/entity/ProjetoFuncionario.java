package com.spring.boot.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.spring.boot.entity.pk.ProjetoFuncionarioPK;

@Entity
@Table(name="tb_projeto_equipe")
public class ProjetoFuncionario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProjetoFuncionarioPK equipepk = new ProjetoFuncionarioPK()                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           ;
	

	public ProjetoFuncionario(){}
	
	//temos que colocar na mão o Funcionario e Projeto e setar com a variável embebed
	public ProjetoFuncionario(Funcionario funcionario, Projeto projeto) {
		super();
		equipepk.setFuncionario(funcionario);
		equipepk.setProjeto(projeto);
	}
	
	
	public Funcionario getFuncionario() {
		return equipepk.getFuncionario();
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.equipepk.setFuncionario(funcionario);
	}
	
	public Projeto getProjeto() {
		return equipepk.getProjeto();
	}
	
	public void setProjeto(Projeto projeto) {
		equipepk.setProjeto(projeto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(equipepk);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjetoFuncionario other = (ProjetoFuncionario) obj;
		return Objects.equals(equipepk, other.equipepk);
	}
	
}
