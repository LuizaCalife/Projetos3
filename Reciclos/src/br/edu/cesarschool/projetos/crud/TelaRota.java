package br.edu.cesarschool.projetos.crud;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.edu.cesarschool.projetos.caminhao.Rota;
import br.edu.cesarschool.projetos.caminhao.RotaMediator;

public class TelaRota {
    private RotaMediator rotaMediator = RotaMediator.obterInstancia();
    private Scanner scanner = new Scanner(System.in);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public void exibirMenuPrincipal() {
        System.out.println("Menu Principal de Rotas");
        System.out.println("1. Incluir Rota");
        System.out.println("2. Alterar Rota");
        System.out.println("3. Excluir Rota");
        System.out.println("4. Buscar Rota");
        System.out.println("5. Sair");
    }

    public void iniciar() {
        boolean rodar = true;
        while (rodar) {
            exibirMenuPrincipal();
            int opcao = lerOpcao();
            switch (opcao) {
                case 1:
                    incluirRota();
                    break;
                case 2:
                    alterarRota();
                    break;
                case 3:
                    excluirRota();
                    break;
                case 4:
                    buscarRota();
                    break;
                case 5:
                    rodar = false;
                    scanner.close();
                    System.out.println("Saindo do sistema de rotas...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private int lerOpcao() {
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    private void incluirRota() {
        System.out.println("Incluir nova rota:");
        Rota novaRota = lerDadosRota();
        String resultado = rotaMediator.incluir(novaRota);
        if (resultado == null) {
            System.out.println("Rota incluída com sucesso!");
        } else {
            System.out.println(resultado);
        }
    }

    private void alterarRota() {
        System.out.println("Alterar dados de uma rota:");
        Rota rota = lerDadosRota();
        String resultado = rotaMediator.alterar(rota);
        if (resultado == null) {
            System.out.println("Rota alterada com sucesso!");
        } else {
            System.out.println(resultado);
        }
    }

    private void excluirRota() {
        System.out.print("Informe o endereço da rota a ser excluída: ");
        String endereco = scanner.nextLine();
        String resultado = rotaMediator.excluir(endereco);
        if (resultado == null) {
            System.out.println("Rota excluída com sucesso!");
        } else {
            System.out.println(resultado);
        }
    }

    private void buscarRota() {
        System.out.print("Informe o endereço da rota a ser buscada: ");
        String endereco = scanner.nextLine();
        Rota rota = rotaMediator.buscar(endereco);
        if (rota != null) {
            mostrarDadosRota(rota);
        } else {
            System.out.println("Rota não encontrada.");
        }
    }

    private Rota lerDadosRota() {
        System.out.print("Digite a data e hora da rota (dd/MM/yyyy HH:mm): ");
        String dataString = scanner.nextLine();
        LocalDateTime data = LocalDateTime.parse(dataString, formatter);
        System.out.print("Digite o endereço da rota: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o CEP da rota: ");
        String cep = scanner.nextLine();
        
        return new Rota(data, endereco, cep);
    }

    private void mostrarDadosRota(Rota rota) {
        System.out.println("Data: " + rota.getData().format(formatter));
        System.out.println("Endereço: " + rota.getEndereco());
        System.out.println("CEP: " + rota.getCep());
    }
}
