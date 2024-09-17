import java.util.Scanner;

public class SistemaAprovacaoAlunos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Número de disciplinas
        final int NUMERO_DISCIPLINAS = 4;
        double[] notas = new double[NUMERO_DISCIPLINAS];
        double somaNotas = 0.0;
        boolean todasNotasAcimaDeNove = true;

        // Captura as notas de cada disciplina
        for (int i = 0; i < NUMERO_DISCIPLINAS; i++) {
            System.out.print("Digite a nota da disciplina " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
            somaNotas += notas[i];

            // Verifica se alguma nota é menor ou igual a 9
            if (notas[i] <= 9) {
                todasNotasAcimaDeNove = false;
            }
        }

        // Calcula a média
        double media = somaNotas / NUMERO_DISCIPLINAS;

        // Aplica bônus de 10% se todas as notas forem maiores que 9
        if (todasNotasAcimaDeNove) {
            media += media * 0.10;
            System.out.println("Bônus aplicado! Média aumentada em 10%.");
        }

        // Verifica o status do aluno com base na média
        System.out.printf("Média final: %.2f%n", media);

        if (media >= 7.0) {
            System.out.println("Status: Aprovado");
        } else if (media >= 5.0 && media < 7.0) {
            System.out.println("Status: Recuperação");
        } else {
            System.out.println("Status: Reprovado");
        }

        scanner.close();
    }
}
