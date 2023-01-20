/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jogodaforca;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class JogoDaForca {

    /**
     * @param args the command line arguments
     */
    static Scanner teclado;
    static char boneco[][] = {
        //    0    1    2    3    4    5    6    7    8
        {'+', '-', '-', '-', '-', '-', '+', ' ', ' '}, // 0
        {'|', ' ', ' ', ' ', ' ', ' ', 'O', ' ', ' '}, // 1
        {'|', ' ', ' ', ' ', ' ', '_', '|', '_', ' '}, // 2
        {'|', ' ', ' ', ' ', '/', ' ', '|', ' ', '\\'}, // 3
        {'|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' '}, // 4
        {'|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' '}, // 5
        {'|', ' ', ' ', ' ', ' ', '/', ' ', '\\', ' '}, // 6
        {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, // 7  => 56
    };
    static char palavraForca[] = new char[20];
    static String palavra[] = {
        "INGLATERRA", "JAPAO", "EUA", "BRASIL", "CANADA",
        "CHILE", "RUSSIA", "ITALIA", "FRANCA", "AFEGANISTAO",
        "ALBANIA", "ALEMANHA", "ANDORRA", "ANGOLA", "ARGELIA",
        "ARGENTINA", "AUSTRALIA", "BAHAMAS", "BARBADOS", "BELGICA",
        "BOLIVIA", "BUTAO", "CAMBOJA", "CATAR", "CHINA",
        "CAZAQUISTAO", "ESPANHA", "ESTONIA", "ETIOPIA", "FIJI",
        "FILIPINA", "GABAO", "GANA", "GEORGIA", "HAITI",
        "HONDURAS", "HUNGRIA", "INDIA", "INDONESIA", "IRAQUE",
        "ISRAEL", "JIBUTI", "JORDANIA", "GRECIA", "MOCAMBIQUE",
        "VENEZUELA", "MEXICO", "HONDURAS", "PORTUGAL", "SUECIA"
    };
    static String palavraDefinida;
    static boolean eLetra;
    static byte contErros = 0;
    static byte tamanhoC;
    static byte tamanhoL;
    static byte tentativas = 0;
    static double posicao = Math.random();

    public static void main(String[] args) {
        System.out.println("***         Vamos jogar FORCA?          ***");
        criaForca("===========================================", contErros, tamanhoC, tamanhoL);
        palavraDefinida = definePalavra();
        criaCampo(palavraDefinida);
        System.out.println("\n\nPALAVRA CORRETA: " + palavraDefinida);
        System.out.println("------- FIM DO JOGO, VOCE PERDEU!!! -------\n\n\n");
    }

    public static String definePalavra() {
        if (posicao < 0) {
            posicao = posicao * (-1);
        }
        posicao = (posicao * 50);
        int p = (int) posicao;

        //System.out.println("\n\n Essa e a palavra definida: " + palavra[p]);
        //return palavra[p];
        return palavra[p];
    }

    ;
    
    public static void criaForca(String mensagem, int contErros, int tamanhoC, int tamanhoL) {
        System.out.println(mensagem);
        if (contErros == 0) {
            tamanhoL = 7;
            tamanhoC = 6;
        }
        for (byte l = 0; l <= tamanhoL; l++) {
            System.out.println();
            if ((contErros == 0 && l > 0)
                    || (contErros == 1 && l > 1)
                    || (contErros == 2 && l > 2)
                    || (contErros == 3 && l > 3)
                    || (contErros == 4 && l > 4)
                    || (contErros == 5 && l > 5)) {
                tamanhoC = 3;
            } else if ((contErros == 6 && l > 2)
                    || (contErros == 7 && l > 2)
                    || (contErros == 8 && l > 3)
                    || (contErros == 9 && l > 3)) {
                tamanhoC = 6;
            }
            for (byte c = 0; c <= tamanhoC; c++) {
                System.out.print(boneco[l][c]);
            }
        }
    }

    public static void criaCampo(String palavra) {
        char[] letras = palavra.toCharArray();

        //System.out.println(letras.length);
        for (byte i = 0; i < letras.length; i++) {
            palavraForca[i] = '_';
            System.out.print(palavraForca[i] + "    ");
        }
        System.out.println("\n");

        escolherLetra("-------------------------------------------", letras, palavra);
    }

    public static void escolherLetra(String mensagem, char letras[], String palavra) {
        tentativas++;
        String letra;
        System.out.println(mensagem);
        letra = entradaString("DIGITE A " + tentativas + " LETRA: ");
        //System.out.println("\n LETRA: " + letra);
        //letrasEscolhidas[tentativas-1] = letra;
        verificaLetraPosicao(letras, palavra, letra);
    }

    public static void verificaLetraPosicao(char letras[], String palavra, String letra) {
        boolean letraErrada = true;

        if (contErros <= 10) {
            letra = letra.toUpperCase();
            char letraC = letra.charAt(0);

            for (byte i = 0; i < letras.length; i++) {
                if (palavra.charAt(i) == letraC) {
                    palavraForca[i] = letraC;
                    letraErrada = false;
                }
            }
            if (letraErrada) {
                contErros++;
            }
            System.out.println("LETRAS ERRADAS: " + contErros);

            atualizaForca("");
            atualizaCampo(palavraForca, letras);
            System.out.println("\n\n");

            if (contErros < 10) {
                escolherLetra("-------------------------------------------", letras, palavra);
            }
        }
    }
    public static void atualizaCampo(char palavraForca[], char letras[]) {
        for (byte i = 0; i < letras.length; i++) {
            System.out.print(palavraForca[i] + "    ");
        }
    }
    public static void atualizaForca(String mensagem) {
        System.out.println(mensagem);
        tamanhoC = 6;
        tamanhoL = 7;

        switch (contErros) {
            case 1 ->
                criaForca(" ", contErros, tamanhoC, tamanhoL);
            case 2 -> {
                boneco[2][5] = ' ';
                criaForca(" ", contErros, tamanhoC, tamanhoL);
            }
            case 3 ->
                igualCase3();
            case 4 ->
                igualCase3();
            case 5 ->
                igualCase3();
            case 6 -> {
                tamanhoC = 7;
                boneco[2][5] = '_';
                boneco[6][5] = ' ';
                criaForca(" ", contErros, tamanhoC, tamanhoL);
            }
            case 7 -> {
                tamanhoC = 7;
                boneco[3][4] = '/';
                criaForca(" ", contErros, tamanhoC, tamanhoL);
            }
            case 8 -> {
                tamanhoC = 8;
                criaForca(" ", contErros, tamanhoC, tamanhoL);
            }
            case 9 -> {
                tamanhoC = 8;
                boneco[6][5] = '/';
                criaForca(" ", contErros, tamanhoC, tamanhoL);
            }
            default -> {
                tamanhoC = 8;
                criaForca(" ", contErros, tamanhoC, tamanhoL);
            }
        }
    }

    public static void igualCase3() {
        boneco[2][5] = ' ';
        boneco[3][4] = ' ';
        criaForca(" ", contErros, tamanhoC, tamanhoL);
    }

    public static String entradaString(String mensagem) {
        teclado = new Scanner(System.in);
        System.out.print(mensagem);
        return teclado.nextLine();
    }

    public static int entradaInt(String mensagem) {
        teclado = new Scanner(System.in);
        System.out.print(mensagem);
        return teclado.nextInt();
    }
}
