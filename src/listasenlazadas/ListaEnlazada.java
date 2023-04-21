/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listasenlazadas;

/**
 *
 * @author lv1822
 */
public class ListaEnlazada {

    private Nodo nodoInicial;
    private int size;

    public ListaEnlazada() {
    }

    public ListaEnlazada(Nodo n) {
        this.nodoInicial = n;
        this.size = 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void agregarAlInicio(Object d) {
        Nodo nNodo = new Nodo(d);
        Nodo nAux = this.nodoInicial;
        this.nodoInicial = nNodo;
        this.nodoInicial.setNext(nAux);
        size++;

    }

    public void agregarAlFinal(Object o) {
        Nodo nNodo = new Nodo(o);
        Nodo aux = this.nodoInicial;
        while (aux.getNext() != null) {
            aux = aux.getNext();

        }
        aux.setNext(nNodo);
        size++;

    }


  public void insertarPorIndice(int indice, Object dato) {
    Nodo nuevoNodo = new Nodo(dato);
    
    if (indice == 0) {
        nodoInicial = nuevoNodo;
        return;
    }
    
    Nodo nodoActual = nodoInicial;
    int indiceActual = 0;
    
    while (nodoActual.getNext() != null && indiceActual < indice - 1) {
        nodoActual = nodoActual.getNext();
        indiceActual++;
    }
    
    if (indiceActual == indice - 1) {
        nuevoNodo.setNext(nodoActual.getNext());
        nodoActual.setNext(nuevoNodo);
    } else {
        throw new IndexOutOfBoundsException("Índice fuera de rango");
    }
}

    
    public void eliminarPorDato(Object dato) {

        Nodo aux = nodoInicial;
        Nodo auxAnteror = nodoInicial;

        if (aux.getData() == dato) {
            nodoInicial = aux.getNext();
        }

        while (aux != null && aux.getData() != dato) {
            auxAnteror = aux;
            aux = aux.getNext();
        }
        if (aux != null) {
            auxAnteror.setNext(aux.getNext());
        }
    }

    public void eliminarPorIndice(int indice) {
        Nodo aux = nodoInicial;
        Nodo auxAnterior = null;
        for (int i = 0; i < indice; i++) {
            auxAnterior = aux;
            aux = aux.getNext();
        }

        if (auxAnterior != null) {
            auxAnterior.setNext(aux.getNext());
            size--;
        } else {
            nodoInicial = aux.getNext();
            size--;
        }

    }

    public int size() {
        return size;
    }

    public Object search(int index) {
        Nodo aux = nodoInicial;
        for (int i = 0; i <= size; i++) {

            if (index == i) {
                break;
            }
            aux = aux.getNext();
        }
        return aux;
    }

public Nodo buscarPorDato(Object dato) {
    Nodo nodoActual = nodoInicial;
    
    while (nodoActual != null) {
        if (nodoActual.getData().equals(dato)) {
            return nodoActual;
        }
        nodoActual = nodoActual.getNext();
    }
    
    return null;
}

public Nodo eliminarAlInicio() {
    nodoInicial = nodoInicial.getNext();
    return nodoInicial;
}

public void eliminarAlFinal() {
    if (nodoInicial.getNext() == null) {
        nodoInicial = null;
    } else {
        Nodo nodoActual = nodoInicial;
        
        while (nodoActual.getNext().getNext() != null) {
            nodoActual = nodoActual.getNext();
        }
        
        nodoActual.setNext(null);
    }
}

    public Nodo getNodoInicial() {
        return nodoInicial;
    }

    public void printList() {
        System.out.println(this.nodoInicial);
    }
}
