/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listasenlazadas;

/**
 *
 * @author lv1822
 */
public class Nodo {
    private Object data;
    private Nodo next;

    public Nodo(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data + ", " + next ;
    }
    
    
}
