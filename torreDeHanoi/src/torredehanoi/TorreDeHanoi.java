/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package torredehanoi;

import static torredehanoi.entrada.*;

/**
 *
 * @author aluno
 */
public class TorreDeHanoi {

    public static char torreCompleta[] = {'1', '2', '3', '4', '5'};
    public static int linhas[] = {1, 2, 3, 4, 5};
    public static char a[] = {'|', '|', '|', '|', '|'};
    public static char b[] = {'1', '2', '3', '4', '5'};
    public static char c[] = {'|', '|', '|', '|', '|'};
    public static char torreOrigem[] = {' ', ' ', ' ', ' ', ' '};
    public static String torreDestino;
    public static String torreAtual = "B";
    public static char pecaEmMovimento;
    public static int localMovimento = 0;
    public static int aux;
    public static int cont = 0;
    public static int posicao;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        do {
            System.out.println("===================================================================================================");
            System.out.println("\t\t\t\tMÁGILA MORGANA FERREIRA - TORRE DE HANOI ");
            System.out.println("===================================================================================================");
            impressao();
            System.out.println("\n" + (cont + 1) + "ª Jogada");
            torreDestino = escolheTorre();
            mudarDisco(torreDestino, torreAtual);
            cont++;
        } while (a != torreCompleta || c != torreCompleta);
    }

    public static void mudarDisco(String torreDestino, String torreAtual) {
        torreDestino = torreDestino.toUpperCase();
        torreAtual = torreAtual.toUpperCase();
        torreOrigem = definetorreOrigem(torreAtual);

        if (torreDestino.equals(torreAtual)) {
            movimentoInvalido();
        } else {
            pecaEmMovimento = verificaPeca(torreOrigem);
            switch (torreDestino) {
                case "A":
                    torreOrigem = movimentaPeca(pecaEmMovimento, a, torreOrigem);
                    break;
                case "B":
                    torreOrigem = movimentaPeca(pecaEmMovimento, b, torreOrigem);
                    break;
                case "C":
                    torreOrigem = movimentaPeca(pecaEmMovimento, c, torreOrigem);
                    break;
                default:
                    System.out.println("Torre inexistente!");
                    torreDestino = escolheTorre();
                    mudarDisco(torreDestino, torreAtual);
            }
            atualizaTorre(torreAtual, torreOrigem);
        }
    }

    public static void atualizaTorre(String torreAtual, char torreOrigem[]) {
        switch (torreAtual) {
            case "A":
                a = torreOrigem;
                break;
            case "B":
                b = torreOrigem;
                break;
            case "C":
                c = torreOrigem;
                break;
        }
    }

    public static char[] movimentaPeca(char pecaEmMovimento, char torreEscolhida[], char torreOrigem[]) {
        for (byte i = 0; i < linhas.length; i++) { 
            aux = linhas.length - (i + 1);
            if (torreEscolhida[aux] == '|') {
                torreEscolhida[aux] = pecaEmMovimento;
                torreOrigem = limpaTorre();
                break;

            } else if (torreEscolhida[aux] > pecaEmMovimento) {
                localMovimento = recebePeca(torreEscolhida);
                torreEscolhida[localMovimento] = pecaEmMovimento;              
                torreOrigem = limpaTorre();
                break;

            } else {
                System.out.println("\nMovimento inválido! ");
                torreDestino = escolheTorre();
                mudarDisco(torreDestino, torreAtual);
                break;
            }
        }
        
        return torreOrigem;
    }
    public static char[] limpaTorre() {
        torreOrigem[posicao] = '|';
        return torreOrigem;
    }
    public static int recebePeca(char torreFinal[]) {
        System.out.println(torreFinal);
        for (int i = 0; i < linhas.length; i++) {
            if (torreFinal[i] != '|') {
                localMovimento = i - 1;
                break;
            }
        }
        return localMovimento;
    }
    public static char verificaPeca(char torreOrigem[]) {
        for (byte i = 0; i < linhas.length; i++) {
            if (torreOrigem[i] != '|') {
                pecaEmMovimento = torreOrigem[i];
                posicao = i;
                break;
            } else if (i == linhas.length) {
                System.out.println("Torre vazia: escolha outra torre! ");
                escolheTorre();
            }
        }
        return pecaEmMovimento;
    }
    public static void movimentoInvalido() {
        System.out.println("\nMovimento inválido: a peça que você deseja mover já está na torre de destino ou é maior que ela. Refaça sua escolha!");
        torreDestino = escolheTorre();
        mudarDisco(torreDestino, torreAtual);
    }
    public static char[] definetorreOrigem(String torreAtual) {
        switch (torreAtual) {
            case "A":
                torreOrigem = a;
                break;
            case "B":
                torreOrigem = b;
                break;
            case "C":
                torreOrigem = c;
                break;
            default:
                System.out.println("Torre_ORIGEM INVÁLIDA!!!");
        }
        return torreOrigem;
    }
    public static String defineTorreAtual() {
            torreAtual = texto("\nTorre_ORIGEM [letra - A, B ou C]: ");
            torreAtual = torreAtual.toUpperCase();
            
            if (!torreAtual.equals("A")) { 
                if (!torreAtual.equals("B")) {
                    if (!torreAtual.equals("C")) {
                        defineTorreAtual();
                    }
                }
            }
        return torreAtual;
    }
    public static String escolheTorre() {
        if (cont > 0) {
            torreAtual = defineTorreAtual();
        }
        torreDestino = texto("\nTorre_DESTINO [letra - A, B ou C]: ");
        System.out.println("");
        
        return torreDestino;
    }    
    public static void impressao() {
        System.out.println("\n\t\t\t\t       Linha  \tA \tB \tC");
        System.out.println("\t\t\t\t\t__________________________");
        for (byte i = 0; i < linhas.length; i++) {
            System.out.println("");
            System.out.print("\t\t\t\t\t" + linhas[i] + "|\t" + a[i] + "\t" + b[i] + "\t" + c[i]);
            System.out.println("");
        }
    }
}
