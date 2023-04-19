/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listadoblementeenlazadas;

public class Nodo {

    public Object valor;
    public Nodo siguiente;
    public Nodo anterior;

    public Nodo(Object valor) {
        this.valor = valor;
        this.siguiente = null;
        this.anterior = null;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "Nodo{" + "valor=" + valor + ", siguiente=" + siguiente + ", anterior=" + anterior + '}';
    }
    
    
    
}


