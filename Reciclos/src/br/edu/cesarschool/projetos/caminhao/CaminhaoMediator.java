package br.edu.cesarschool.projetos.caminhao;

import br.edu.cesarschool.projetos.utils.StringUtils;
import br.edu.cesarschool.projetos.utils.ValidaPlaca;
import br.edu.cesarschool.projetos.utils.ValidaTelefone;

public class CaminhaoMediator {
	private static CaminhaoMediator instancia;
	private CaminhaoDAO caminhaoDAO = new CaminhaoDAO();
	
	private CaminhaoMediator() {
		
	}
	
	public static CaminhaoMediator obterInstancia() {
		if(instancia == null) {
			instancia = new CaminhaoMediator();
		}
		return instancia;
	}
	
	public Caminhao buscar(String placa){
		return caminhaoDAO.buscar(placa);
	}
	
	public String validar(Caminhao caminhao) {
		if(!ValidaPlaca.validarPlaca(caminhao.getPlaca())) {
			return "Placa inválida";
		}
		if(!ValidaTelefone.validarTelefone(caminhao.getTelefone())) {
			return "Telefone inválido";
		}
		if(caminhao.getEmpresa() == null) {
			return "Empresa inválida";
		}
		if(caminhao.getRota() == null) {
			return "Rota inválida";
		}
		else {
			return null;
		}
	}
	
	
	public String incluir(Caminhao caminhao) {
		String validacao = validar(caminhao);
		
		if(validacao != null) {
			return validacao;
		}
		else {
			if(!caminhaoDAO.incluir(caminhao)) {
				return "Caminhao ja existente";
			}
			else {
				return null;
			}
			
		}
	}
	
	public String alterar(Caminhao caminhao) {
		String validacao = validar(caminhao);
		
		if(validacao != null) {
			return validacao;
		}
		else {
			if(!caminhaoDAO.alterar(caminhao)) {
				return "Caminhao inexistente";
			}
			else {
				return null;
			}
			
		}
	}
	
	public String excluir(String placa) {
		if(StringUtils.isVaziaOuNula(placa)) {
			return "Placa errada";
		}
		else {
			if(!caminhaoDAO.excluir(placa)) {
				return "Caminhao inexistente";
			}
			else {
				return null;
			}
		}
	}

}


