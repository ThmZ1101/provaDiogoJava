import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe Funcionario
class Funcionario {
    private String nome;
    private int idade;
    private double salario;

    public Funcionario(String nome, int idade, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Salário: R$" + salario;
    }
}

// Classe de gerenciamento de funcionários
public class GerenciamentoDeFuncionarios {
    private List<Funcionario> funcionarios;

    public GerenciamentoDeFuncionarios() {
        funcionarios = new ArrayList<>();
    }

    // Adiciona um novo funcionário
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("Funcionário adicionado com sucesso.");
    }

    // Remove um funcionário pelo nome
    public void removerFuncionario(String nome) throws Exception {
        boolean removido = funcionarios.removeIf(funcionario -> funcionario.getNome().equalsIgnoreCase(nome));
        if (!removido) {
            throw new Exception("Erro: Funcionário '" + nome + "' não encontrado.");
        }
        System.out.println("Funcionário removido com sucesso.");
    }

    // Lista todos os funcionários cadastrados
    public void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            System.out.println("Funcionários cadastrados:");
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }
        }
    }

    // Calcula a média salarial dos funcionários
    public void calcularMediaSalarial() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado para calcular a média salarial.");
            return;
        }

        double somaSalarios = 0;
        for (Funcionario funcionario : funcionarios) {
            somaSalarios += funcionario.getSalario();
        }

        double mediaSalarial = somaSalarios / funcionarios.size();
        System.out.println("A média salarial dos funcionários é: R$" + mediaSalarial);
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciamentoDeFuncionarios sistema = new GerenciamentoDeFuncionarios();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Gerenciamento de Funcionários ===");
            System.out.println("1. Adicionar funcionário");
            System.out.println("2. Remover funcionário");
            System.out.println("3. Listar funcionários");
            System.out.println("4. Calcular média salarial");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome do funcionário: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite a idade do funcionário: ");
                        int idade = scanner.nextInt();
                        System.out.print("Digite o salário do funcionário: ");
                        double salario = scanner.nextDouble();
                        scanner.nextLine(); // Limpar buffer
                        Funcionario funcionario = new Funcionario(nome, idade, salario);
                        sistema.adicionarFuncionario(funcionario);
                        break;
                    case 2:
                        System.out.print("Digite o nome do funcionário a ser removido: ");
                        nome = scanner.nextLine();
                        sistema.removerFuncionario(nome);
                        break;
                    case 3:
                        sistema.listarFuncionarios();
                        break;
                    case 4:
                        sistema.calcularMediaSalarial();
                        break;
                    case 5:
                        continuar = false;
                        System.out.println("Saindo do programa.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}
