package br.edu.cesarschool.projetos.caminhao;

public class Lixo {
	private double volume;
	private String tipo;
	
	public Lixo(double volume, String tipo) {
		this.volume = volume;
		this.tipo = tipo;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	

}
