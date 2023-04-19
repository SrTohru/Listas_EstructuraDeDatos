package listadoblementenelzadacircular;

public class Nodo {

  private Object dato;
    private Nodo previo;private Nodo siguiente;

    public Nodo(Object dato) {
        this.dato = dato;
        this.previo = null;
        this.siguiente = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getAnterior() {
        return previo;
    }

    public void setAnterior(Nodo previo) {
        this.previo = previo;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}

    
