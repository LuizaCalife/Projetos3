package br.edu.cesarschool.projetos.caminhao;

import br.edu.cesarschool.projetos.utils.Registro;

public class Empresa extends Registro {
	private String nome;
	private String cnpj;
	private String endereco;
	private String telefone;
	
	public Empresa(String nome, String cnpj, String endereco, String telefone) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
	

}
