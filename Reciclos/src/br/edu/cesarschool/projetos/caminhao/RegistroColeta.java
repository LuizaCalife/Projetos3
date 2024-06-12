package br.edu.cesarschool.projetos.caminhao;

public class RegistroColeta extends PontoColeta{
	private String numRegistro;
	private Caminhao[] caminhoes;

	public RegistroColeta(String id, String endereco, Lixo[] lixos, String numRegistro, Caminhao[] caminhoes) {
		super(id, endereco, lixos);
		this.numRegistro = numRegistro;
		this.caminhoes = caminhoes;
	}

	public String getNumRegistro() {
		return numRegistro;
	}

	public void setNumRegistro(String numRegistro) {
		this.numRegistro = numRegistro;
	}

	public Caminhao[] getCaminhoes() {
		return caminhoes;
	}

	public void setCaminhoes(Caminhao[] caminhoes) {
		this.caminhoes = caminhoes;
	}
	
	
	
	

}
