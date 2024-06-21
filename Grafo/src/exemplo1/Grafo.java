package exemplo1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Grafo {
    ArrayList<String> vertices;
    int matriz[][];
    int qtdVertices;
    int qtdArestas;

    public Grafo (ArrayList<String> vertices) {
        this.vertices = new ArrayList<>();
        this.vertices.addAll(vertices);
        this.qtdVertices = vertices.size();
        this.matriz = new int[vertices.size()][vertices.size()];
        this.qtdArestas = 0;

        for (int i = 0; i < this.qtdVertices; i++) {
            for (int j = 0; j < this.qtdVertices; j++) {
                this.matriz[i][j] = 0;
            }
        }
    }
    public void montarConexoesSimetricas(ArrayList<String> linhas) {
        String dadosLinha[];
        String nomeOrigem, nomeDestino;
        int indiceOrigem, indiceDestino;
        int custo;
        for (String linha : linhas) {
            dadosLinha = linha.split("@");
            nomeOrigem = dadosLinha[0];
            nomeDestino = dadosLinha[1];
            custo = Integer.parseInt(dadosLinha[2]);
            indiceOrigem = this.vertices.indexOf(nomeOrigem);
            indiceDestino = this.vertices.indexOf(nomeDestino);

            if (this.matriz[indiceOrigem][indiceDestino] == 0 && this.matriz[indiceDestino][indiceOrigem] == 0) {
                this.matriz[indiceOrigem][indiceDestino] = custo;
                this.matriz[indiceOrigem][indiceDestino] = custo;
                this.qtdArestas += 2;
            }
        }
    }
    public void mostrarMatriz() {
        for (int i = 0; i < this.qtdVertices; i++) {
            System.out.print("\t" + i + ":");
        }
        System.out.println("");
        for (int i = 0; i < this.qtdVertices; i++) {
            System.out.print(i + "\t:");
            for (int j = 0; j < this.qtdVertices; j++) {
                System.out.print(this.matriz[i][j] + "\t");
            }
            System.out.println("");
        }
        for (int i = 0; i < this.qtdVertices; i++) {
            System.out.println(i + ": " + vertices.get(i));
        }
    }
     public void mostrarGrafo() {
        for (int i = 0; i < this.qtdVertices; i++) {
            System.out.print(i + ":\t");
            for (int j = 0; j < this.qtdVertices; j++) {
                if (this.matriz[i][j] != 0) {
                    System.out.print(this.vertices.get(j) + "\t");
                }
            }
            System.out.println("");
        }
    }
    public static void LerArquivo_MontarGrafo(String nomeArquivo, ArrayList<String> vertices, ArrayList<String> linhas){
        try {
            FileReader arquivo = new FileReader(nomeArquivo);
            BufferedReader leitor = new BufferedReader(arquivo);

            String linha;
            String[] dadosLinha;
            while ((linha = leitor.readLine()) != null) {
                dadosLinha = linha.split("@");
                linhas.add(linha);
               if(!vertices.contains(dadosLinha[0])){
                   vertices.add(dadosLinha[0]);
               }
               if(!vertices.contains(dadosLinha[1])){
                   vertices.add(dadosLinha[1]);
               }
            }
            arquivo.close();
            vertices.sort(null);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

}
