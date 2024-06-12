package br.edu.cesarschool.projetos.caminhao;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class RotaDAO {
	private CadastroObjetos cadastro = new CadastroObjetos(Rota.class);
	private String obterIdUnico(Rota rota) {
		return rota.getEndereco();
	}
	
	public Rota buscar(String endereco) {
		return (Rota)cadastro.buscar(endereco);
	}
	
	public boolean incluir(Rota rota) {
		String idUnico = obterIdUnico(rota);
		Rota ro = buscar(idUnico);
		if (ro == null) {
			cadastro.incluir(rota, idUnico);
			return true;
		}
		return false;

	}
	
	public boolean alterar(Rota rota) {
		String idUnico = obterIdUnico(rota);
		Rota ro = buscar(idUnico);
		if (ro != null) {
			cadastro.alterar(rota, idUnico);
			return true;
		}
		return false;
	}
	
	
	public boolean excluir(String endereco) {
		Rota ro = buscar(endereco);
		if (ro != null) {
			cadastro.excluir(endereco);
			return true;
		}
		return false;
	}
	
	public List<Rota> buscarTodos() {
        Serializable[] objetos = cadastro.buscarTodos();
        return Arrays.stream(objetos)
                     .filter(obj -> obj instanceof Rota)
                     .map(obj -> (Rota) obj)
                     .collect(Collectors.toList());
    }

}
