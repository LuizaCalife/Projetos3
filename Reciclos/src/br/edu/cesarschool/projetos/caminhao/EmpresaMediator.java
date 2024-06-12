package br.edu.cesarschool.projetos.caminhao;

import java.util.List;

import br.edu.cesarschool.projetos.utils.StringUtils;
import br.edu.cesarschool.projetos.utils.ValidaCNPJ;
import br.edu.cesarschool.projetos.utils.ValidaTelefone;

public class EmpresaMediator {
	private static EmpresaMediator instancia;
	private EmpresaDAO empresaDAO = new EmpresaDAO();
	
	private EmpresaMediator() {
		
	}
	
	public static EmpresaMediator obterInstancia() {
		if(instancia == null) {
			instancia = new EmpresaMediator();
		}
		return instancia;
	}
	
	public Empresa buscar(String cnpj){
		return empresaDAO.buscar(cnpj);
	}
	
	public String validar(Empresa empresa) {
		if(ValidaCNPJ.isCNPJ(empresa.getCnpj()) == false) {
			return "CNPJ inválido";
		}
		if(StringUtils.isVaziaOuNula(empresa.getNome()) || empresa.getNome().length() < 2) {
			return "Nome inválido";
		}
		if(StringUtils.isVaziaOuNula(empresa.getEndereco()) || empresa.getEndereco().length() < 2) {
			return "Endereço inválido";
		}
		if(ValidaTelefone.validarTelefone(empresa.getTelefone()) == false) {
			return "Telefone inválido";
		}
		else {
			return null;
		}
		
	}
	
	public String incluir(Empresa empresa) {
		String validacao = validar(empresa);
		
		if(validacao != null) {
			return validacao;
		}
		else {
			if(!empresaDAO.incluir(empresa)) {
				return "Empresa ja existente";
			}
			else {
				return null;
			}
			
		}
	}
	
	public String alterar(Empresa empresa) {
		String validacao = validar(empresa);
		
		if(validacao != null) {
			return validacao;
		}
		else {
			if(!empresaDAO.alterar(empresa)) {
				return "Empresa inexistente";
			}
			else {
				return null;
			}
			
		}
	}
	
	public String excluir(String cnpj) {
		if(StringUtils.isVaziaOuNula(cnpj)) {
			return "CNPJ errado";
		}
		else {
			if(!empresaDAO.excluir(cnpj)) {
				return "Empresa inexistente";
			}
			else {
				return null;
			}
		}
	}
	
    public List<Empresa> buscarTodas() {
        return empresaDAO.buscarTodos();
    }

}
