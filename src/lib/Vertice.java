package lib;
import java.util.ArrayList;

public class Vertice<T> {
    private T valor;
    private ArrayList<Aresta<T>> destinos;

    public Vertice(T valor){
        setValor(valor);
        this.destinos = new ArrayList<>();
    }

    public T getValor(){
        return valor;
    }

    public void setValor(T valor){
        this.valor = valor;
    }

    public void adicionarDestino(Aresta<T> aresta){
        this.destinos.add(aresta);
    }

    public ArrayList<Aresta<T>> getDestinos(){
        return destinos;
    }

    @Override
    public String toString() {
        return this.valor.toString();
    }
}
