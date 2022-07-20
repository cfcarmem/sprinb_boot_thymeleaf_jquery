package com.spring.boot.entity.enumerator;

public enum StatusProjeto {
	PENDENTE(1),
	ANDAMENTO(2),
	FINALIZADO(3),
	CANCELADO(4);
	
	private int code;
	
	private StatusProjeto(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
	//converter numérico para enumerado. Static pois pode ser usado sem precisar instanciar a classe
	public static StatusProjeto valueOf(int code) {
		for(StatusProjeto s: StatusProjeto.values()) {
			if(s.getCode() == code) {
			  return s;
			}
		}
		throw new IllegalArgumentException("Código do Status é inválido");
	}


}
