package br.edu.cesarschool.projetos.caminhao;

import br.edu.cesarschool.projetos.utils.Registro;

public class Caminhao extends Registro {
	private String placa;
	private String telefone;
	private Empresa empresa;
	private Rota rota;
	
	public Caminhao(String placa, String telefone, Empresa empresa, Rota rota) {
		this.placa = placa;
		this.telefone = telefone;
		this.empresa = empresa;
		this.rota = rota;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}
	
	
	
	

}
