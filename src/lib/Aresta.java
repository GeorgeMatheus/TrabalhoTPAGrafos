package lib;

public class Aresta<T> {
    private float peso;
    private Vertice<T> destino;

    public Aresta(Vertice<T> destino, float peso){
        setPeso(peso);
        setDestino(destino);
    }

    public float getPeso(){
        return peso;
    }

    public void setPeso(float peso){
        this.peso = peso;
    }

    public Vertice<T> getDestino(){
        return destino;
    }

    public void setDestino(Vertice<T> destino){
        this.destino = destino;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return destino.getValor() + "; peso: " + this.peso;
    }
}