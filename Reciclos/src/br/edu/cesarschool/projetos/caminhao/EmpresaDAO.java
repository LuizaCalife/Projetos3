package br.edu.cesarschool.projetos.caminhao;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class EmpresaDAO {
	private CadastroObjetos cadastro = new CadastroObjetos(Empresa.class);
	private String obterIdUnico(Empresa empresa) {
		return empresa.getCnpj();
	}
	
	public Empresa buscar(String cnpj) {
		return (Empresa)cadastro.buscar(cnpj);
	}
	
	public boolean incluir(Empresa empresa) {
		String idUnico = obterIdUnico(empresa);
		Empresa em = buscar(idUnico);
		if (em == null) {
			cadastro.incluir(empresa, idUnico);
			return true;
		}
		return false;

	}
	
	public boolean alterar(Empresa empresa) {
		String idUnico = obterIdUnico(empresa);
		Empresa em = buscar(idUnico);
		if (em != null) {
			cadastro.alterar(empresa, idUnico);
			return true;
		}
		return false;
	}
	
	
	public boolean excluir(String cnpj) {
		Empresa em = buscar(cnpj);
		if (em != null) {
			cadastro.excluir(cnpj);
			return true;
		}
		return false;
	}
	
    public List<Empresa> buscarTodos() {
        Serializable[] objetos = cadastro.buscarTodos();
        return Arrays.stream(objetos)
                     .filter(obj -> obj instanceof Empresa)
                     .map(obj -> (Empresa) obj)
                     .collect(Collectors.toList());
    }

}
