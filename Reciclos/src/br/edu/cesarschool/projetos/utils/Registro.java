package br.edu.cesarschool.projetos.utils;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Registro implements Serializable {
	private LocalDateTime dhInclusao;
	private LocalDateTime dhUltimaAtualizacao;
	
	public Registro() {
		dhInclusao = LocalDateTime.now();
	}

	public LocalDateTime getDhUltimaAtualizacao() {
		return dhUltimaAtualizacao;
	}

	public void setDhUltimaAtualizacao(LocalDateTime dhUltimaAtualizacao) {
		this.dhUltimaAtualizacao = dhUltimaAtualizacao;
	}


	public LocalDateTime getDhInclusao() {
		return dhInclusao;
	}

}