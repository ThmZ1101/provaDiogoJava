import java.util.Scanner;

// Exceção personalizada para valores inválidos
class ValorInvalidoException extends Exception {
    public ValorInvalidoException(String mensagem) {
        super(mensagem);
    }
}

public class FatorialComRecursao {

    // Método recursivo para calcular o fatorial
    public static int calcularFatorial(int n) throws ValorInvalidoException {
        if (n < 0) {
            throw new ValorInvalidoException("Erro: O valor deve ser um número inteiro positivo.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * calcularFatorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Digite um número inteiro positivo para calcular o fatorial: ");
                int numero = scanner.nextInt();

                // Verifica e calcula o fatorial
                int resultado = calcularFatorial(numero);
                System.out.println("O fatorial de " + numero + " é: " + resultado);
                entradaValida = true; // Se o cálculo foi bem-sucedido, sai do loop

            } catch (ValorInvalidoException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next(); // Limpa a entrada inválida
            }
        }

        scanner.close();
    }
}
