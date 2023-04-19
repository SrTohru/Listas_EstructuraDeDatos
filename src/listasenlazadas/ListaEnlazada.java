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

    
    //Agregar al inicio
    public void addIni(Object d) {
        //1
        Nodo nNodo = new Nodo(d);
        //2
        Nodo nAux = this.nodoInicial;
        //3
        this.nodoInicial = nNodo;
        //4
        this.nodoInicial.setNext(nAux);
        //5
        size++;

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
        
        if(auxAnterior != null){
            auxAnterior.setNext(aux.getNext());
            size--;
        }else{
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

    public Object search(Nodo n) {
        return null;
    }

    public void removeIni() {

    }

    public void removeByIndex(int index) {

    }

    public Nodo getNodoInicial() {
        return nodoInicial;
    }

    public void printList() {
        System.out.println(this.nodoInicial);
    }

    public void add2End(Object o) {
        Nodo nNodo = new Nodo(o);
        Nodo aux = this.nodoInicial;
        while (aux.getNext() != null) {
            aux = aux.getNext();

        }
        aux.setNext(nNodo);
        size++;

    }
}
