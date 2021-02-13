import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Collator;
import java.util.*;

/* Executar em Java 8 ou superior
*
* Para Executar, basta colocar o arquivo que quer ordenar nomeado como "ArquivoParaLeitura
* */

public class Main {

    public static void main(String[] args){

        ArrayList<String> listaPontuacoes = new ArrayList<>();
        ArrayList<String> linhasDoArquivo;

        try{
        System.out.println("Lendo arquivo no diretório do .jar ---");
        Path path = Paths.get("arquivoParaLeitura.txt");
        linhasDoArquivo = (ArrayList<String>) Files.readAllLines(path);
            for (String linha  : linhasDoArquivo){

                //Limpa espaços e pontuações
                linha = linha.replaceAll(" ", "");
                linha = linha.replaceAll("\\p{Punct}", "");

                //Adiciona a pontuação na lista que acumula os pontos
                listaPontuacoes.add(pontuaLinhaPorLetra(linha) + linha);
            }


            try{
                System.out.println("Criando arquivo de repositório ---");
                FileOutputStream arquivo = new FileOutputStream("arquivoOrdenado.txt");
                PrintWriter pr = new PrintWriter(arquivo);

                Collections.sort(listaPontuacoes);


                for(String linha : listaPontuacoes) {
                    linha = linha.replaceAll("[0-9]", "");
                    linha = linha.replaceAll(",", "");
                    pr.println(linha);
                }

                pr.close();
                arquivo.close();
                System.out.println("Processamento Concluído ---");
            }catch(Exception e){
                System.err.println("Arquivo não foi criado!");
            }
        }catch(Exception e){
            System.err.println("Arquivo não foi carregado!");
        }
    }


    public static String pontuaLinhaPorLetra(String linhaAvaliada){
        String pontuacaoDaPalavra = new String();

        for (int i = 0; i < linhaAvaliada.length(); i++){
             switch(linhaAvaliada.toLowerCase().charAt(i)) {
                 case 'a':pontuacaoDaPalavra = pontuacaoDaPalavra+ "1,"; break;
                 case 'b': pontuacaoDaPalavra = pontuacaoDaPalavra+ "2,"; break;
                 case 'c': pontuacaoDaPalavra = pontuacaoDaPalavra+ "3,"; break;
                 case 'd': pontuacaoDaPalavra = pontuacaoDaPalavra+ "4,"; break;
                 case 'e': pontuacaoDaPalavra = pontuacaoDaPalavra+ "5,"; break;
                 case 'f': pontuacaoDaPalavra = pontuacaoDaPalavra+ "6,"; break;
                 case 'g': pontuacaoDaPalavra = pontuacaoDaPalavra+ "7,"; break;
                 case 'h': pontuacaoDaPalavra = pontuacaoDaPalavra+ "8,"; break;
                 case 'i': pontuacaoDaPalavra = pontuacaoDaPalavra+ "9,"; break;
                 case 'j': pontuacaoDaPalavra = pontuacaoDaPalavra+ "10,"; break;
                 case 'k': pontuacaoDaPalavra = pontuacaoDaPalavra+ "11,"; break;
                 case 'l': pontuacaoDaPalavra = pontuacaoDaPalavra+ "12"; break;
                 case 'm': pontuacaoDaPalavra = pontuacaoDaPalavra+ "13,"; break;
                 case 'n': pontuacaoDaPalavra = pontuacaoDaPalavra+ "14,"; break;
                 case 'o': pontuacaoDaPalavra = pontuacaoDaPalavra+ "15,"; break;
                 case 'p': pontuacaoDaPalavra = pontuacaoDaPalavra+ "16,"; break;
                 case 'q': pontuacaoDaPalavra = pontuacaoDaPalavra+ "17,"; break;
                 case 'r': pontuacaoDaPalavra = pontuacaoDaPalavra+ "18,"; break;
                 case 's': pontuacaoDaPalavra = pontuacaoDaPalavra+ "19,"; break;
                 case 't': pontuacaoDaPalavra = pontuacaoDaPalavra+ "20,"; break;
                 case 'u': pontuacaoDaPalavra = pontuacaoDaPalavra+ "21,"; break;
                 case 'v': pontuacaoDaPalavra = pontuacaoDaPalavra+ "22,"; break;
                 case 'w': pontuacaoDaPalavra = pontuacaoDaPalavra+ "23,"; break;
                 case 'x': pontuacaoDaPalavra = pontuacaoDaPalavra+ "24,"; break;
                 case 'y': pontuacaoDaPalavra = pontuacaoDaPalavra+ "25,"; break;
                 case 'z': pontuacaoDaPalavra = pontuacaoDaPalavra+ "26,"; break;
             }
        }

        int tamanho = pontuacaoDaPalavra.length();
        pontuacaoDaPalavra = pontuacaoDaPalavra.substring(0, tamanho-1);


       return pontuacaoDaPalavra;
    }
}