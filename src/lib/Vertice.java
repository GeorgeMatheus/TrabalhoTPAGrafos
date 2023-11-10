package lib;
import java.util.Comparator;

public class Vertice<T> {
    private T valor;

    public Vertice(T valor){
        setValor(valor);
    }

    public T getValor() {
        return this.valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
}
