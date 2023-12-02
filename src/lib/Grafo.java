package lib;
import java.util.ArrayList;

public class Grafo<T> {
    private ArrayList<Aresta<T>> arestas;
    private ArrayList<Vertice<T>> vertices;


    public Vertice<T> adicionarVertice(T valor){
        Vertice<T> novo = new Vertice<T>(valor);
        this.vertices.add(novo);
        return novo;
    }

    private Vertice<T> obterVertice(T valor){
        Vertice<T> v;


        for(int i=0; i<this.vertices.size();i++){
            v = this.vertices.get(i);

            if(v.getValor().equals(valor)){
                return v;
            }
        }

        return null;
    }

    public void adicionarAresta(T origem, T destino, float peso){
        Vertice<T> verticeOrigem, verticeDestino;
        Aresta<T> novaAresta;


        verticeOrigem = obterVertice(origem);

        if(verticeOrigem == null){
            verticeOrigem = adicionarVertice(origem);
        }

        verticeDestino = obterVertice(destino);

        if(verticeDestino == null){
            verticeDestino = adicionarVertice(destino);
        }

        verticeOrigem.adicionarDestino(new Aresta<T>(verticeDestino, peso));
    }

    public void buscaEmLargura(){
        ArrayList<Vertice<T>> marcados = new ArrayList<Vertice<T>>();
        ArrayList<Vertice<T>> fila = new ArrayList<Vertice<T>>();

        Vertice<T> atual = this.vertices.get(0);
        fila.add(atual);

        while (fila.size() > 0){
            atual = fila.get(0);
            fila.remove(0);
            marcados.add(atual);

            ArrayList<Aresta<T>> destinos = atual.getDestinos();

            Vertice<T> proximo;
            for (int i = 0; i < destinos.size(); i++){
                proximo = destinos.get(i).getDestino();

                if(!marcados.contains(proximo)&&!fila.contains(proximo)){
                    fila.add(proximo);
                }
            }
        }

    }



}
