package br.edu.cesarschool.projetos.caminhao;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;


public class CaminhaoDAO {
	private CadastroObjetos cadastro = new CadastroObjetos(Caminhao.class);
	private String obterIdUnico(Caminhao caminhao) {
		return caminhao.getPlaca();
	}
	
	public Caminhao buscar(String placa) {
		return (Caminhao)cadastro.buscar(placa);
	}
	
	public boolean incluir(Caminhao caminhao) {
		String idUnico = obterIdUnico(caminhao);
		Caminhao ca = buscar(idUnico);
		if (ca == null) {
			cadastro.incluir(caminhao, idUnico);
			return true;
		}
		return false;

	}
	
	public boolean alterar(Caminhao caminhao) {
		String idUnico = obterIdUnico(caminhao);
		Caminhao ca = buscar(idUnico);
		if (ca != null) {
			cadastro.alterar(caminhao, idUnico);
			return true;
		}
		return false;
	}
	
	
	public boolean excluir(String placa) {
		Caminhao ca = buscar(placa);
		if (ca != null) {
			cadastro.excluir(placa);
			return true;
		}
		return false;
	}
}
	
	


