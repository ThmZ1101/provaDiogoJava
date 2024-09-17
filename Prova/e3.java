import java.util.InputMismatchException;
import java.util.Scanner;

// Classe base para operações matemáticas
abstract class Operacao {
    public abstract double calcular(double a, double b) throws ArithmeticException;
}

// Subclasse para Soma
class Soma extends Operacao {
    @Override
    public double calcular(double a, double b) {
        return a + b;
    }
}

// Subclasse para Subtração
class Subtracao extends Operacao {
    @Override
    public double calcular(double a, double b) {
        return a - b;
    }
}

// Subclasse para Multiplicação
class Multiplicacao extends Operacao {
    @Override
    public double calcular(double a, double b) {
        return a * b;
    }
}

// Subclasse para Divisão
class Divisao extends Operacao {
    @Override
    public double calcular(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Erro: Divisão por zero.");
        }
        return a / b;
    }
}

// Subclasse para Raiz Quadrada
class RaizQuadrada extends Operacao {
    @Override
    public double calcular(double a, double b) throws ArithmeticException {
        if (a < 0) {
            throw new ArithmeticException("Erro: Raiz quadrada de número negativo.");
        }
        return Math.sqrt(a);
    }

    // Método sobrecarregado para calcular apenas uma entrada
    public double calcular(double a) throws ArithmeticException {
        if (a < 0) {
            throw new ArithmeticException("Erro: Raiz quadrada de número negativo.");
        }
        return Math.sqrt(a);
    }

}

// Classe principal para a calculadora
public class CalculadoraAvancada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            try {
                // Exibir menu de operações
                System.out.println("\n=== Calculadora Avançada ===");
                System.out.println("1. Soma");
                System.out.println("2. Subtração");
                System.out.println("3. Multiplicação");
                System.out.println("4. Divisão");
                System.out.println("5. Raiz Quadrada");
                System.out.println("6. Sair");
                System.out.print("Escolha uma operação: ");

                int escolha = scanner.nextInt();

                if (escolha == 6) {
                    continuar = false;
                    System.out.println("Saindo da calculadora.");
                    break;
                }

                double numero1, numero2;
                Operacao operacao = null;

                switch (escolha) {
                    case 1:
                        operacao = new Soma();
                        System.out.print("Digite o primeiro número: ");
                        numero1 = scanner.nextDouble();
                        System.out.print("Digite o segundo número: ");
                        numero2 = scanner.nextDouble();
                        System.out.println("Resultado: " + operacao.calcular(numero1, numero2));
                        break;
                    case 2:
                        operacao = new Subtracao();
                        System.out.print("Digite o primeiro número: ");
                        numero1 = scanner.nextDouble();
                        System.out.print("Digite o segundo número: ");
                        numero2 = scanner.nextDouble();
                        System.out.println("Resultado: " + operacao.calcular(numero1, numero2));
                        break;
                    case 3:
                        operacao = new Multiplicacao();
                        System.out.print("Digite o primeiro número: ");
                        numero1 = scanner.nextDouble();
                        System.out.print("Digite o segundo número: ");
                        numero2 = scanner.nextDouble();
                        System.out.println("Resultado: " + operacao.calcular(numero1, numero2));
                        break;
                    case 4:
                        operacao = new Divisao();
                        System.out.print("Digite o primeiro número: ");
                        numero1 = scanner.nextDouble();
                        System.out.print("Digite o segundo número: ");
                        numero2 = scanner.nextDouble();
                        System.out.println("Resultado: " + operacao.calcular(numero1, numero2));
                        break;
                    case 5:
                        operacao = new RaizQuadrada();
                        System.out.print("Digite o número: ");
                        numero1 = scanner.nextDouble();
                        System.out.println("Resultado: " + ((RaizQuadrada) operacao).calcular(numero1));
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                scanner.next(); // Limpa a entrada inválida
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
