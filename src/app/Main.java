package app;

import lib.Grafo;
import lib.Vertice;

public class Main {
    public static void main(String[] args) {
        // Criando um grafo de exemplo
        Grafo<Integer> grafo = new Grafo<>();

        // Adicionando vértices
        Vertice<Integer> v1 = grafo.adicionarVertice(1);
        Vertice<Integer> v2 = grafo.adicionarVertice(2);
        Vertice<Integer> v3 = grafo.adicionarVertice(3);

        // Adicionando arestas
        grafo.adicionarAresta(v1.getValor(), v2.getValor(), 1.0f);
        grafo.adicionarAresta(v2.getValor(), v3.getValor(), 2.0f);
        grafo.adicionarAresta(v3.getValor(), v1.getValor(), 3.0f);

        // Realizando busca em largura
        System.out.println("Busca em Largura:");
        grafo.buscaEmLargura();

        // Verificando se o grafo tem ciclo
        System.out.println("Tem Ciclo: " + grafo.temCiclo());

        // Executando ordenação topológica
        System.out.println("Ordenação Topológica:");
        for (Vertice<Integer> vertice : grafo.ordenacaoTopologica()) {
            System.out.print(vertice.getValor() + " ");
        }
    }
}