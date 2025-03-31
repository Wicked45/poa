package ap3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Listar Contatos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    agenda.adicionarContato(new Contato(nome, telefone));
                    break;
                case "2":
                    agenda.listarContatos();
                    break;
                case "3":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("3"));

        scanner.close();
    }
}