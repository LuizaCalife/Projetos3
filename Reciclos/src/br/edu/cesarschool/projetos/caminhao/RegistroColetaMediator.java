package br.edu.cesarschool.projetos.caminhao;

import br.edu.cesarschool.projetos.utils.StringUtils;

public class RegistroColetaMediator {
	private static RegistroColetaMediator instancia;
	private RegistroColetaDAO registroColetaDAO = new RegistroColetaDAO();
	
	private RegistroColetaMediator() {
		
	}
	
	public static RegistroColetaMediator obterInstancia() {
		if(instancia == null) {
			instancia = new RegistroColetaMediator();
		}
		return instancia;
	}
	
	public RegistroColeta buscar(String numRegistro){
		return registroColetaDAO.buscar(numRegistro);
	}
	
	public String validar(RegistroColeta registro) {
		if(StringUtils.isVaziaOuNula(registro.getId()) || registro.getId().length() < 2) {
			return "ID inválido";
		}
		if(StringUtils.isVaziaOuNula(registro.getEndereco()) || registro.getEndereco().length() < 2) {
			return "Endereço inválido";
		}
		if(registro.getLixos() == null || registro.getLixos().length == 0) {
			return "Tipos de lixo inválidos";
		}
		if(StringUtils.isVaziaOuNula(registro.getNumRegistro()) || registro.getNumRegistro().length() < 2) {
			return "Número de registro inválido";
		}
		if(registro.getCaminhoes() == null || registro.getCaminhoes().length == 0) {
			return "Caminhões inválidos";
		}
		else {
			return null;
		}
		
	}
	
	public String incluir(RegistroColeta registro) {
		String validacao = validar(registro);
		
		if(validacao != null) {
			return validacao;
		}
		else {
			if(!registroColetaDAO.incluir(registro)) {
				return "Registro de Coleta ja existente";
			}
			else {
				return null;
			}
			
		}
	}
	
	public String alterar(RegistroColeta registro) {
		String validacao = validar(registro);
		
		if(validacao != null) {
			return validacao;
		}
		else {
			if(!registroColetaDAO.alterar(registro)) {
				return "Registro de Coleta inexistente";
			}
			else {
				return null;
			}
			
		}
	}
	
	public String excluir(String numRegistro) {
		if(StringUtils.isVaziaOuNula(numRegistro)) {
			return "Número de registro errado";
		}
		else {
			if(!registroColetaDAO.excluir(numRegistro)) {
				return "Registro de Coleta inexistente";
			}
			else {
				return null;
			}
		}
	}

}
