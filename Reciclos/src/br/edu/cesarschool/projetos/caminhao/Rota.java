package br.edu.cesarschool.projetos.caminhao;

import java.time.LocalDateTime;

import br.edu.cesarschool.projetos.utils.Registro;

public class Rota extends Registro {
	private java.time.LocalDateTime data;
	private String endereco;
	private String cep;
	
	public Rota(LocalDateTime data, String endereco, String cep) {
		this.data = data;
		this.endereco = endereco;
		this.cep = cep;
	}

	public java.time.LocalDateTime getData() {
		return data;
	}

	public void setData(java.time.LocalDateTime data) {
		this.data = data;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	
	

}
