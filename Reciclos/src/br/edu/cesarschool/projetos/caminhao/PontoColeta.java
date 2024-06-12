package br.edu.cesarschool.projetos.caminhao;

public class PontoColeta {
	private String id;
	private String endereco;
	private Lixo[] lixos;
	
	public PontoColeta(String id, String endereco, Lixo[] lixos) {
		this.id = id;
		this.endereco = endereco;
		this.lixos = lixos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Lixo[] getLixos() {
		return lixos;
	}

	public void setLixos(Lixo[] lixos) {
		this.lixos = lixos;
	}
	
	
	
	

}
