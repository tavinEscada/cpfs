package com.mycompany.cpfs;

import java.util.Scanner;

public class Cpfs {

    public static void main(String[] args) {

        Funcs funcs = new Funcs();

        System.out.println("Teste o algoritmo!!!");

        String op;

        try (Scanner entrada = new Scanner(System.in)) {
            do {
                System.out.println("""
                        Digite:
                        1 - para verificar se um CPF é válido
                        2 - para gerar todos os CPFs válidos (boa sorte na execução!!!)
                        0 - para sair""");

                op = entrada.nextLine();

                if (op.equals("1")) {

                    funcs.verificaValidade(entrada);

                } else {
                    if (op.equals("2")) {
                        funcs.printaTodos();

                    } else {
                        if (op.equals("0")) {
                            System.exit(0);
                        } else {
                            System.out.println("Entrada inválida.\n");
                        }
                    }
                }
            } while (!op.equals("0"));
        }
    }
}
