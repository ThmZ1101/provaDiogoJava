import java.util.Scanner;

// Classe Contato
class Contato {
    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone;
    }
}

// Exceção personalizada para quando a agenda estiver cheia
class AgendaCheiaException extends Exception {
    public AgendaCheiaException(String mensagem) {
        super(mensagem);
    }
}

// Exceção personalizada para quando um contato não for encontrado
class ContatoNaoEncontradoException extends Exception {
    public ContatoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}

// Classe Agenda Telefônica
public class AgendaTelefonica {
    private Contato[] contatos;
    private int contador;

    public AgendaTelefonica() {
        contatos = new Contato[100]; // Limite de 100 contatos
        contador = 0;
    }

    // Método para adicionar contato
    public void adicionarContato(Contato contato) throws AgendaCheiaException {
        if (contador >= 100) {
            throw new AgendaCheiaException("Erro: A agenda está cheia, não é possível adicionar mais contatos.");
        }
        contatos[contador] = contato;
        contador++;
        System.out.println("Contato adicionado com sucesso.");
    }

    // Método para remover contato pelo nome
    public void removerContato(String nome) throws ContatoNaoEncontradoException {
        for (int i = 0; i < contador; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                // Remover o contato e reorganizar o array
                for (int j = i; j < contador - 1; j++) {
                    contatos[j] = contatos[j + 1];
                }
                contatos[contador - 1] = null;
                contador--;
                System.out.println("Contato removido com sucesso.");
                return;
            }
        }
        throw new ContatoNaoEncontradoException("Erro: Contato '" + nome + "' não encontrado.");
    }

    // Método para buscar contato pelo nome
    public Contato buscarContato(String nome) throws ContatoNaoEncontradoException {
        for (int i = 0; i < contador; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                return contatos[i];
            }
        }
        throw new ContatoNaoEncontradoException("Erro: Contato '" + nome + "' não encontrado.");
    }

    // Método para listar todos os contatos
    public void listarContatos() {
        if (contador == 0) {
            System.out.println("Agenda vazia.");
        } else {
            System.out.println("Contatos na agenda:");
            for (int i = 0; i < contador; i++) {
                System.out.println(contatos[i]);
            }
        }
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaTelefonica agenda = new AgendaTelefonica();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Agenda Telefônica ===");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Remover contato");
            System.out.println("3. Buscar contato");
            System.out.println("4. Listar todos os contatos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome do contato: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o telefone do contato: ");
                        String telefone = scanner.nextLine();
                        Contato novoContato = new Contato(nome, telefone);
                        agenda.adicionarContato(novoContato);
                        break;
                    case 2:
                        System.out.print("Digite o nome do contato a ser removido: ");
                        nome = scanner.nextLine();
                        agenda.removerContato(nome);
                        break;
                    case 3:
                        System.out.print("Digite o nome do contato a ser buscado: ");
                        nome = scanner.nextLine();
                        Contato contato = agenda.buscarContato(nome);
                        System.out.println("Contato encontrado: " + contato);
                        break;
                    case 4:
                        agenda.listarContatos();
                        break;
                    case 5:
                        continuar = false;
                        System.out.println("Saindo da agenda.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (AgendaCheiaException | ContatoNaoEncontradoException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
