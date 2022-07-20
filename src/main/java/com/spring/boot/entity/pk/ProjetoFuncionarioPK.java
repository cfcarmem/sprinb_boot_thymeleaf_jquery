package com.spring.boot.entity.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.spring.boot.entity.Funcionario;
import com.spring.boot.entity.Projeto;

@Embeddable //vai criar a PK composta
public class ProjetoFuncionarioPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="id_funcionario")
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name="id_Projeto")
	private Projeto projeto;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(funcionario, projeto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjetoFuncionarioPK other = (ProjetoFuncionarioPK) obj;
		return Objects.equals(funcionario, other.funcionario) && Objects.equals(projeto, other.projeto);
	}
	
	
}
