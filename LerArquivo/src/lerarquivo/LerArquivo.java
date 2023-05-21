/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lerarquivo;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luciano Pelissoli
 */
public class LerArquivo {

    /**
     * @param args the command line arguments
     */

    private static String endereco;

    public static void main(String[] args) {
        try {
            endereco = "https://www.saopaulo.sp.gov.br/"
                    + "wp-content/uploads/2022/"
                    + "11/20221115_estatisticas_gerais.csv";
            URL site = new URL(endereco);
            PrintWriter saidaArquivo = gravarArquivo("c:\\_dev\\dados.csv");
            BufferedReader br = abrirSite(site);
            String conteudo;
            // le o conteudo do site.
            while ((conteudo = br.readLine()) != null) {

                // grava a informação no arquivo de saida
                saidaArquivo.println(conteudo);
            }
            // fecha o acesso ao site
            br.close();

            // fecha o arquivo gravado.
            saidaArquivo.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(LerArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LerArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // rotina para abrir um site e ler um arquivo dele.
    // retorna um objeto para acessar os dados
    private static BufferedReader abrirSite(URL site) throws IOException {
        return new BufferedReader(
                new InputStreamReader(site.openStream()));
    }

    // rotina para abrir um arquivo para gravação
    // esta rotina sobrepoem o arquivo existente
    private static PrintWriter gravarArquivo(String local) throws IOException {
        FileWriter arquivo = new FileWriter(local);
        return new PrintWriter(arquivo);
    }

}
