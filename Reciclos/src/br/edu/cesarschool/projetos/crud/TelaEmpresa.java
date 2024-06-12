package br.edu.cesarschool.projetos.crud;

import java.util.Scanner;
import br.edu.cesarschool.projetos.caminhao.Empresa;
import br.edu.cesarschool.projetos.caminhao.EmpresaMediator;

public class TelaEmpresa {
    private EmpresaMediator empresaMediator = EmpresaMediator.obterInstancia();
    Scanner scanner = new Scanner(System.in);
    
    public void exibirMenuPrincipal() {
        System.out.println("Menu Principal");
        System.out.println("1. Incluir Empresa");
        System.out.println("2. Alterar Empresa");
        System.out.println("3. Excluir Empresa");
        System.out.println("4. Buscar Empresa");
        System.out.println("5. Sair");
    }
    
    public void iniciar() {
        boolean rodar = true;
        while (rodar) {
            exibirMenuPrincipal();
            int opcao = lerOpcao();
            switch (opcao) {
                case 1:
                    incluirEmpresa();
                    break;
                case 2:
                    alterarEmpresa();
                    break;
                case 3:
                    excluirEmpresa();
                    break;
                case 4:
                    buscarEmpresa();
                    break;
                case 5:
                    rodar = false;
                    scanner.close();
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
    
    public int lerOpcao() {
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
    
    public void incluirEmpresa() {
        System.out.println("Incluir nova empresa:");
        Empresa novaEmpresa = lerDadosEmpresa();
        String resultado = empresaMediator.incluir(novaEmpresa);
        if (resultado == null) {
            System.out.println("Empresa incluída com sucesso!");
        } else {
            System.out.println(resultado);
        }
    }
    
    public void alterarEmpresa() {
        System.out.println("Alterar dados de uma empresa:");
        Empresa empresa = lerDadosEmpresa();
        String resultado = empresaMediator.alterar(empresa);
        if (resultado == null) {
            System.out.println("Empresa alterada com sucesso!");
        } else {
            System.out.println(resultado);
        }
    }
    
    public void excluirEmpresa() {
        System.out.print("Informe o CNPJ da empresa a ser excluída: ");
        String cnpj = scanner.nextLine();
        String resultado = empresaMediator.excluir(cnpj);
        if (resultado == null) {
            System.out.println("Empresa excluída com sucesso!");
        } else {
            System.out.println(resultado);
        }
    }
    
    public void buscarEmpresa() {
        System.out.print("Informe o CNPJ da empresa a ser buscada: ");
        String cnpj = scanner.nextLine();
        Empresa empresa = empresaMediator.buscar(cnpj);
        if (empresa != null) {
            mostrarDadosEmpresa(empresa);
        } else {
            System.out.println("Empresa não encontrada.");
        }
    }
    
    private Empresa lerDadosEmpresa() {
        System.out.print("Digite o nome da empresa: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CNPJ da empresa: ");
        String cnpj = scanner.nextLine();
        System.out.print("Digite o endereço da empresa: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o telefone da empresa: ");
        String telefone = scanner.nextLine();
        
        return new Empresa(nome, cnpj, endereco, telefone);
    }
    
    private void mostrarDadosEmpresa(Empresa empresa) {
        System.out.println("Nome: " + empresa.getNome());
        System.out.println("CNPJ: " + empresa.getCnpj());
        System.out.println("Endereço: " + empresa.getEndereco());
        System.out.println("Telefone: " + empresa.getTelefone());
    }
}
