/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ativjogodavelha;
import java.util.Scanner;

/**
 * @author MMSF
 */
public class funcoesSecundarias {
    public static String entradaString(String mensagem) {
        Scanner teclado = new Scanner(System.in);
        System.out.print(mensagem);
        return teclado.nextLine();
    }
    public static int entradaInt(String mensagem) throws Exception {
        int num = 0;
        String aux = entradaString(mensagem);
        try {
            num = Integer.parseInt(aux);
        } catch (Exception e) {
            throw new Exception("ERRO - Digite um numero inteiro entre 0 e 2\n");
        }
        return num;
    }
    public static boolean verificaDados(int aux) {
        // Configurar entrada entre 0 e 3
        boolean erro = aux < 0 || aux > 2;
        if (erro) {
            System.out.println("ERRO - Digite um numero entre 0 e 2 \n");
        }
        return erro;
    }
}
