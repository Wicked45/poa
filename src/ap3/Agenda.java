package ap3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos;
    private final String arquivo = "contatos.txt";

    public Agenda() {
        contatos = new ArrayList<>();
        verificarArquivo();
        carregarContatos();
    }

    private void verificarArquivo() {
        File file = new File(arquivo);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Erro ao criar o arquivo: " + e.getMessage());
            }
        }
    }

    private void carregarContatos() {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                contatos.add(new Contato(dados[0], dados[1]));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar contatos: " + e.getMessage());
        }
    }

    public void adicionarContato(Contato contato) {
        if (telefoneExistente(contato.getTelefone())) {
            System.out.println("Erro: Telefone já cadastrado.");
        } else {
            contatos.add(contato);
            salvarContatos();
            System.out.println("Contato adicionado com sucesso.");
        }
    }

    private boolean telefoneExistente(String telefone) {
        for (Contato contato : contatos) {
            if (contato.getTelefone().equals(telefone)) {
                return true;
            }
        }
        return false;
    }

    private void salvarContatos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Contato contato : contatos) {
                bw.write(contato.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar contatos: " + e.getMessage());
        }
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
        } else {
            for (Contato contato : contatos) {
                System.out.println("Nome: " + contato.getNome() + ", Telefone: " + contato.getTelefone());
            }
        }
    }
}