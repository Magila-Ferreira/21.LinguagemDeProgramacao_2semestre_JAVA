/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package torredehanoi;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class entrada {
    private static Scanner x ;
    
    public entrada(){
        x = new Scanner(System.in);
    }
    public static String texto(String mensagem){
        System.out.print(mensagem);
        x = new Scanner(System.in);
        return x.nextLine();
    }
}
