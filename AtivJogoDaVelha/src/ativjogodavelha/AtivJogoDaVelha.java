/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ativjogodavelha;
import static ativjogodavelha.funcoesSecundarias.*;

/*
  @author aluno -- Mágila
       Jogo da velha em Portugol.
   	*      |   |   
   	*   ---+---+---
   	*      |   |
   	*   ---+---+---
   	*      |   |
 */
public class AtivJogoDaVelha {
    static String[][] matriz = {
        {" ", " ", " "},
        {" ", " ", " "},
        {" ", " ", " "}
    };
    static String marcacao;
    // Função Principal
    public static void main(String[] args) {
        //String tabuleiro[][] = new String[3][3];
        boolean ganhou = false;
        byte jogadas = 0;
        int jog;
        inicioJogo("\n=====================================================\n");
        do {
            jog = defineJog(jogadas);
            jogada("\n                   JOGADOR " + jog + "\n");
            imprimeTabuleiro(matriz);
            ganhou = verificaGanhador(ganhou);
            jogadas++;
        } while (ganhou == false && jogadas < 9);
        fimDeJogo(ganhou, jog);
    }
    // Funções primárias
    public static void inicioJogo(String mensagem) {
        System.out.print(mensagem);
        System.out.print("***               JOGO DA VELHA                  ***");
    }
    public static int defineJog(int jogadas) {
        int jogador;
        if (jogadas % 2 == 0) {
            jogador = 1;
            marcacao = "X";
        } else {
            jogador = 2;
            marcacao = "0";
        }
        return jogador;
    }
    public static void jogada(String mensagem) {
        System.out.print("\n=====================================================\n");
        System.out.println(mensagem);
        System.out.println("Escolha uma linha e coluna para jogar, entre [0, 1, 2]");

        boolean erro;
        int aux = 0;
        int linha = 0;
        int coluna = 0;
        String definicao;

        for (int cont = 0; cont < 2; cont++) {
            if (cont == 0) {
                definicao = "LINHA: ";
            } else {
                definicao = "COLUNA: ";
            }

            do {
                try {
                    aux = entradaInt(definicao);
                    erro = verificaDados(aux);
                } catch (Exception e) {
                    erro = true;
                    System.out.println(e.getMessage());
                }
            } while (erro);
            if (cont == 0) {
                linha = aux;
            } else {
                coluna = aux;
            }
        }
        // .equals - sugestão do editor: verifica a igualdade na variável
        if (" ".equals(matriz[linha][coluna])) {
            matriz[linha][coluna] = marcacao;            
        } else {
            jogada("\nOpcao assinalada, escolha outra posicao!\n");
        }
    }
    public static void imprimeTabuleiro(String matriz[][]) {
        System.out.println("                    TABULEIRO                        ");

        // impressão do tabuleiro
        System.out.println("                    0   1   2");

        for (int l = 0; l < 3; l++) {
            System.out.print("               ");
            for (int c = 0; c < 3; c++) {
                if (c == 0) {System.out.print(l + " ");}
                System.out.print("  " + matriz[l][c]);
                if (c < 2) {
                    System.out.print(" |");
                } 
                if (c == 2) {System.out.println();}
            }
            if (l < 2) {
                System.out.print("                  ");
                System.out.print("---+----+---");
                System.out.println();
            }
        }
    }
    public static boolean verificaGanhador(boolean ganhou) {
        for (int l = 0; l < 3; l++) {
            int c = 0;
            // Verifica ganhador linha
            if (((matriz[l][c] == "X" && matriz[l][c+1] == "X" && matriz[l][c+2] == "X") || 
                 (matriz[l][c] == "0" && matriz[l][c+1] == "0" && matriz[l][c+2] == "0"))) {
                ganhou = true;
            }
        }
        for (int c = 0; c < 3; c++) {
            int l = 0;
            // Verifica ganhador coluna
            if (((matriz[l][c] == "X" && matriz[l+1][c] == "X" && matriz[l+2][c] == "X") || 
                 (matriz[l][c] == "0" && matriz[l+1][c] == "0" && matriz[l+2][c] == "0"))) {
                ganhou = true;
            }
        }
        // Verifica ganhador diagonais
        int i = 0;
        if (((matriz[i][i] == "X" && matriz[i+1][i+1] == "X" && matriz[i+2][i+2] == "X")) ||
            ((matriz[i][i] == "0" && matriz[i+1][i+1] == "0" && matriz[i+2][i+2] == "0"))) {
            ganhou = true;
        }
        if (((matriz[i][i+2] == "X" && matriz[i+1][i+1] == "X" && matriz[i+2][i] == "X")) ||
            ((matriz[i][i+2] == "0" && matriz[i+1][i+1] == "0" && matriz[i+2][i] == "0"))) {
            ganhou = true;
        }
        return ganhou;
    }
    public static void fimDeJogo(boolean ganhou, int jog) {
        if (ganhou && jog == 1) {
            System.out.println("Parabens jogador 1, voce venceu!!! [X]");
        } else if (!ganhou) {
            System.out.println("EMPATE!");
        } else {
            System.out.println("Parabens jogador 2, voce venceu!!! [0]");
        }
    }
}


