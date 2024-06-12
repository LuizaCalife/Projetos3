package br.edu.cesarschool.projetos.caminhao;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class RegistroColetaDAO {
	private CadastroObjetos cadastro = new CadastroObjetos(RegistroColeta.class);
	private String obterIdUnico(RegistroColeta registroColeta) {
		return registroColeta.getNumRegistro();
	}
	
	public RegistroColeta buscar(String numRegistro) {
		return (RegistroColeta)cadastro.buscar(numRegistro);
	}
	
	public boolean incluir(RegistroColeta registroColeta) {
		String idUnico = obterIdUnico(registroColeta);
		RegistroColeta rc = buscar(idUnico);
		if (rc == null) {
			cadastro.incluir((Serializable) registroColeta, idUnico);
			return true;
		}
		return false;

	}
	
	public boolean alterar(RegistroColeta registroColeta) {
		String idUnico = obterIdUnico(registroColeta);
		RegistroColeta rc = buscar(idUnico);
		if (rc != null) {
			cadastro.alterar((Serializable) registroColeta, idUnico);
			return true;
		}
		return false;
	}
	
	
	public boolean excluir(String numRegistro) {
		RegistroColeta rc = buscar(numRegistro);
		if (rc != null) {
			cadastro.excluir(numRegistro);
			return true;
		}
		return false;
	}

}
