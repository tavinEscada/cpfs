package com.mycompany.cpfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Funcs{
    /**
     * método que calcula o dígito verificador 1 para cada possibilidade de 9
     * digitos
     *
     * @param cpf9 lista com os 9 primeiros dígitos do CPF a ser
     * analisado/gerado
     * @return int - digito verificador 1 calculado para os 9 primeiros dígitos
     * de um cpf
     */
    public int dV1(ArrayList<Integer> cpf9) {

        int s = 0;

        // multiplica cada um dos 9 primeiros dígitos por seu multiplicador
        for (int i = 0; i <= 8; i++) {
            s += (10 - i) * cpf9.get(i);
        }

        int digito1 = 0;

        // define o dígito verificador 1
        if (s % 11 >= 2) {
            digito1 = 11 - (s % 11);
        }

        // retorna o resultado
        return digito1;
    }

    /**
     * método que calcula o dígito verificador 2 com base nos 9 dígitos
     * anteriores + o dv1 calculado
     *
     * @param cpf10 vetor com os 9 dígitos do cpf e o dígito verificador 1
     * calculado
     * @return int - dv2
     */
    public int dV2(ArrayList<Integer> cpf10) {

        int s = 0;

        /*
         * multiplicando os nove primeiros digitos e o primeiro
         * dígito verificador calculado por seus multiplicadores
         */
        for (int i = 0; i <= 9; i++) {
            s += (11 - i) * cpf10.get(i);
        }

        int digito2 = 0;

        // define o dígito verificador 2
        if (s % 11 >= 2) {
            digito2 = 11 - (s % 11);
        }

        // retorna o resultado
        return digito2;
    }

    /**
     * verificando se um dado cpf tem todos os dígitos iguais
     *
     * @param cpf cpf a ser avaliado
     * @return boolean - true para cpfs com todos os dígitos iguais, false para
     * o restante
     */
    public boolean igualdade(ArrayList<Integer> cpf) {
        int d1 = cpf.get(0);

        for (int i = 1; i <= 10; i++) {
            if (d1 != cpf.get(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * formatando a escrita dos cpfs
     *
     * @param cpf CPF a ser exibido
     */
    public void mostraCpf(ArrayList<Integer> cpf) {

        int a;
        // exibindo o CPF, separando os dígitos com "." e "-"
        for (a = 0; a <= 2; a++) {
            System.out.print(cpf.get(a));
        }
        System.out.print(".");

        for (a = 3; a <= 5; a++) {
            System.out.print(cpf.get(a));
        }
        System.out.print(".");

        for (a = 6; a <= 8; a++) {
            System.out.print(cpf.get(a));
        }
        System.out.print("-");

        for (a = 9; a <= 10; a++) {
            System.out.print(cpf.get(a));
        }
        // saltando uma linha para o próximo CPF
        System.out.println("");
    }

    /**
     * dado um número de CPF, realiza as verificações necessárias para saber se ele é valido ou não e printa o resultado
     * 
     * @param entrada scanner inicializado na main
     */
    public void verificaValidade(Scanner entrada) {

        System.out.println("Digite o CPF de teste (apenas números):");

        String cpf = entrada.nextLine();

        String[] vet = cpf.split("");

        if (vet.length != 11) {
            System.out.println("Entrada inválida.\n");
            return;

        }
        ArrayList<Integer> cpfInt = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            cpfInt.add(Integer.valueOf(vet[i]));
        }

        if (dV1(cpfInt) != cpfInt.get(9) || dV2(cpfInt) != cpfInt.get(10) || igualdade(cpfInt)) {
            System.out.println("CPF inválido.\n");
        } else {
            System.out.println("CPF válido!!!\n");
        }
    }

    /**
     * printa todos os cpfs, a partir do cálculo dos dígitos verificadores (se houverem), para cada sequencia de 9 dígitos
     */
    public void printaTodos() {
        // vetor onde o CPF a ser analisado será armazenado
        ArrayList<Integer> cpf = new ArrayList<>();

        // preenchendo os 11 índices do vetor "cpf" com 0s
        for (int i = 0; i <= 10; i++) {
            cpf.add(0);
        }

        for (int a = 9; a >= 0; a--) {
            cpf.set(0, a);
            for (int b = 9; b >= 0; b--) {
                cpf.set(1, b);
                for (int c = 9; c >= 0; c--) {
                    cpf.set(2, c);
                    for (int d = 9; d >= 0; d--) {
                        cpf.set(3, d);
                        for (int e = 9; e >= 0; e--) {
                            cpf.set(4, e);
                            for (int f = 9; f >= 0; f--) {
                                cpf.set(5, f);
                                for (int g = 9; g >= 0; g--) {
                                    cpf.set(6, g);
                                    for (int h = 9; h >= 0; h--) {
                                        cpf.set(7, h);
                                        for (int i = 9; i >= 0; i--) {
                                            cpf.set(8, i);
                                            cpf.set(9, dV1(cpf));
                                            cpf.set(10, dV2(cpf));

                                            if (igualdade(cpf) == false) {
                                                mostraCpf(cpf);
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}
