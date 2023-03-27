package Prova;

import java.util.Scanner;

public class Exe1 {
    Scanner sc = new Scanner(System.in);

    public void exe1() {
        System.out.println("Digite o primeiro numero:");
        int n1 = sc.nextInt();
        System.out.println("Escolha a operação Aritmética:");
        System.out.println("1 (Adição)");
        System.out.println("2 (Subtração)");
        System.out.println("3 (Multiplicação)");
        System.out.println("4 (Divisão)");
        double op = sc.nextDouble();
        System.out.println("Digite o segundo numero:");
        int n2 = sc.nextInt();
        double res = 0;
        if (op == 1) {
            res = n1 + n2;
            System.out.println(n1 + "+" + n2 + "=" + res);
        } else if (op == 2) {
            res = n1 - n2;
            System.out.println(n1 + "-" + n2 + "=" + res);
        } else if (op == 3) {
            res = n1 * n2;
            System.out.println(n1 + "*" + n2 + "=" + res);
        } else if (op == 4 && n2 != 0) {
            res = n1 / n2;
            System.out.println(n1 + "/" + n2 + "=" + res);
        } else {
            System.out.println("Algum erro de digitação foi encontrado");
        }
    }

    public void exe2() {
        System.out.println("Digite o numero da matricula");
        int mat = sc.nextInt();
        if (mat % 4 == 0){
            System.out.println("Esse aluno esta no Time do Chris");

        } else if (mat % 4 == 1){
            System.out.println("Esse aluno esta no Time do Greg");

        } else if (mat % 4 == 2){
            System.out.println("Esse aluno esta no Time do Caruso");

        } else{
            System.out.println("Esse aluno esta no Time do Jerome");
        }
    }
    public void exe3(){
        System.out.println("Quantidade de Morangos(Kg):");
        double km = sc.nextDouble();
        System.out.println("Quantidade de Maças(Kg):");
        double kma = sc.nextDouble();
        System.out.println("Quantidade de Bananas(Kg):");
        double kb = sc.nextDouble();
        double cus = (km*3.50) + (kma*2.30) + (kb*1.80);
        double kg = km + kma + kb;
        double des = 0;
        double cusF = cus;
        if(cus >= 30 || kg >= 15){
            des = cus*0.1;
            cusF = cus-des;
            System.out.println("O valor a ser pago é"+cusF);
        }else{
            System.out.println("O valor a ser pago é"+cusF);
        }
    }
}
