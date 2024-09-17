import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe Item
class Item {
    private String nome;
    private int quantidade;

    public Item(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return nome + "," + quantidade;
    }

    // Construtor para criar um Item a partir de uma linha de texto
    public static Item fromString(String linha) {
        String[] partes = linha.split(",");
        return new Item(partes[0], Integer.parseInt(partes[1]));
    }
}

// Classe de gerenciamento de estoque
public class SistemaDeEstoque {
    private List<Item> estoque;
    private static final String ARQUIVO_ESTOQUE = "estoque.txt";

    public SistemaDeEstoque() {
        estoque = new ArrayList<>();
        carregarEstoque();
    }

    // Adiciona um item ao estoque
    public void adicionarItem(Item item) {
        for (Item i : estoque) {
            if (i.getNome().equalsIgnoreCase(item.getNome())) {
                i.setQuantidade(i.getQuantidade() + item.getQuantidade());
                return;
            }
        }
        estoque.add(item);
    }

    // Remove um item do estoque
    public void removerItem(String nome) {
        for (int i = 0; i < estoque.size(); i++) {
            if (estoque.get(i).getNome().equalsIgnoreCase(nome)) {
                estoque.remove(i);
                return;
            }
        }
        System.out.println("Item não encontrado.");
    }

    // Lista todos os itens do estoque
    public void listarItens() {
        if (estoque.isEmpty()) {
            System.out.println("O estoque está vazio.");
        } else {
            System.out.println("Itens no estoque:");
            for (Item item : estoque) {
                System.out.println(item);
            }
        }
    }

    // Salva o estoque no arquivo
    public void salvarEstoque() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_ESTOQUE))) {
            for (Item item : estoque) {
                writer.write(item.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o estoque: " + e.getMessage());
        }
    }

    // Carrega o estoque do arquivo
    private void carregarEstoque() {
        File arquivo = new File(ARQUIVO_ESTOQUE);
        if (arquivo.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_ESTOQUE))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    estoque.add(Item.fromString(linha));
                }
            } catch (IOException e) {
                System.out.println("Erro ao carregar o estoque: " + e.getMessage());
            }
        }
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaDeEstoque sistema = new SistemaDeEstoque();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Sistema de Estoque ===");
            System.out.println("1. Adicionar item");
            System.out.println("2. Remover item");
            System.out.println("3. Listar itens");
            System.out.println("4. Salvar e sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do item: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a quantidade do item: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    sistema.adicionarItem(new Item(nome, quantidade));
                    break;
                case 2:
                    System.out.print("Digite o nome do item a ser removido: ");
                    nome = scanner.nextLine();
                    sistema.removerItem(nome);
                    break;
                case 3:
                    sistema.listarItens();
                    break;
                case 4:
                    sistema.salvarEstoque();
                    continuar = false;
                    System.out.println("Estoque salvo. Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
