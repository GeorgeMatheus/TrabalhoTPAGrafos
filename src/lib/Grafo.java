package lib;
import java.util.ArrayList;
import java.util.Stack;

public class Grafo<T> {
    private ArrayList<Vertice<T>> vertices;


    public Grafo() {
        this.vertices = new ArrayList<>();
    }

    public Vertice<T> adicionarVertice(T valor){
        Vertice<T> novo = new Vertice<T>(valor);
        this.vertices.add(novo);
        return novo;
    }

    private Vertice<T> obterVertice(T valor){

        for(Vertice<T> v : this.vertices) {
            if(v.getValor().equals(valor)) {
                return v;
            }
        }

        return  null;
    }


    public void adicionarAresta(T origem, T destino, float peso){
        Vertice<T> verticeOrigem, verticeDestino;

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

        while (!fila.isEmpty()){
            atual = fila.get(0);
            fila.remove(0);
            marcados.add(atual);


            for (Aresta<T> destino : atual.getDestinos()) {
                Vertice<T> proximo = destino.getDestino();

                if (!marcados.contains(proximo) && !fila.contains(proximo)) {
                  fila.add(proximo);
                }
            }
        }

    }

    public boolean temCiclo() {
        ArrayList<Vertice<T>> visitados = new ArrayList<>();
        ArrayList<Vertice<T>> pilhaRecursao = new ArrayList<>();

        for (Vertice<T> vertice : vertices) {
            if (!visitados.contains(vertice) && temCicloUtil(vertice, visitados, pilhaRecursao)) {
                return true;
            }
        }

        return false;
    }

    private boolean temCicloUtil(Vertice<T> vertice, ArrayList<Vertice<T>> visitados, ArrayList<Vertice<T>> pilhaRecursao) {
        visitados.add(vertice);
        pilhaRecursao.add(vertice);

        for (Aresta<T> aresta : vertice.getDestinos()) {
            Vertice<T> destino = aresta.getDestino();

            if (!visitados.contains(destino)) {
                if (temCicloUtil(destino, visitados, pilhaRecursao)) {
                    return true;
                }
            } else if (pilhaRecursao.contains(destino)) {
                return true;
            }
        }

        pilhaRecursao.remove(vertice);
        return false;
    }

    public ArrayList<Vertice<T>> ordenacaoTopologica() {
        ArrayList<Vertice<T>> resultado = new ArrayList<>();
        Stack<Vertice<T>> pilha = new Stack<>();
        ArrayList<Vertice<T>> visitados = new ArrayList<>();

        for (Vertice<T> vertice : vertices) {
            if (!visitados.contains(vertice)) {
                ordenacaoTopologicaUtil(vertice, visitados, pilha);
            }
        }


        // A pilha agora contém a ordenação topológica inversa
        while (!pilha.isEmpty()) {
            resultado.add(pilha.pop());
        }

        return resultado;
    }

    private void ordenacaoTopologicaUtil(Vertice<T> vertice, ArrayList<Vertice<T>> visitados, Stack<Vertice<T>> pilha) {
        visitados.add(vertice);

        for (Aresta<T> aresta : vertice.getDestinos()) {
            Vertice<T> destino = aresta.getDestino();

            if (!visitados.contains(destino)) {
                ordenacaoTopologicaUtil(destino, visitados, pilha);
            }
        }

        pilha.push(vertice);
    }

}
