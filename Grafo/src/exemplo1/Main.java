package exemplo1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Ler o arquivo e montar o Grafo
        ArrayList<String> vertices = new ArrayList<>();
        ArrayList<String> LinhasDoArquivo = new ArrayList<>();
        String nomeArquivo = "C:\\Users\\laboratorio\\IdeaProjects\\Grafo\\src\\exemplo1\\mapaCentral.txt";

        Grafo.LerArquivo_MontarGrafo(nomeArquivo, vertices, LinhasDoArquivo);

        Grafo g = new Grafo(vertices);
        // montar as conexões do arquivo
        g.montarConexoesSimetricas(LinhasDoArquivo);
        g.mostrarMatriz();
        /*g.mostrarGrafo();*/

    }
}