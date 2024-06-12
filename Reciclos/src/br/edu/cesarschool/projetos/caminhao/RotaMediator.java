package br.edu.cesarschool.projetos.caminhao;

import java.time.LocalDateTime;
import java.util.List;

import br.edu.cesarschool.projetos.utils.StringUtils;

public class RotaMediator {
	private static RotaMediator instancia;
	private RotaDAO rotaDAO = new RotaDAO();
	
	private RotaMediator() {
		
	}
	
	public static RotaMediator obterInstancia() {
		if(instancia == null) {
			instancia = new RotaMediator();
		}
		return instancia;
	}
	
	public Rota buscar(String endereco){
		return rotaDAO.buscar(endereco);
	}
	
	public String validar(Rota rota) {
		if(rota.getCep().length() != 8) {
			return "CEP inválido";
		}
		if(rota.getData() == null || rota.getData().isBefore(LocalDateTime.now())) {
			return "Hora inválida";
		}
		if(StringUtils.isVaziaOuNula(rota.getEndereco()) || rota.getEndereco().length() < 2){
			return "Endereço inválido";
		}
		
		else{
			return null;
		}
		
	}
	
	public String incluir(Rota rota) {
		String validacao = validar(rota);
		
		if(validacao != null) {
			return validacao;
		}
		else {
			if(!rotaDAO.incluir(rota)) {
				return "Rota ja existente";
			}
			else {
				return null;
			}
			
		}
	}
	
	public String alterar(Rota rota) {
		String validacao = validar(rota);
		
		if(validacao != null) {
			return validacao;
		}
		else {
			if(!rotaDAO.alterar(rota)) {
				return "Rota inexistente";
			}
			else {
				return null;
			}
			
		}
	}
	
	public String excluir(String endereco) {
		if(StringUtils.isVaziaOuNula(endereco)) {
			return "Endereço errado";
		}
		else {
			if(!rotaDAO.excluir(endereco)) {
				return "Rota inexistente";
			}
			else {
				return null;
			}
		}
	}
	
	public List<Rota> buscarTodas() {
		return rotaDAO.buscarTodos();
	}

}
