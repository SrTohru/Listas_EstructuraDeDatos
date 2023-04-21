package listaenlazadasimplecircular;

public class ListaCircularSimple {

    private Nodo nodoInciial;
    private Nodo nodoFinal;
    private int size;

    public ListaCircularSimple() {
        this.nodoInciial = null;
        this.nodoFinal = null;
        this.size = 0;
    }

    public void agregarAlInicio(Object dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (nodoInciial == null) {
            nodoInciial = nuevoNodo;
            nodoFinal = nuevoNodo;
            nuevoNodo.setSiguiente(nodoInciial);
        } else {
            nuevoNodo.setSiguiente(nodoInciial);
            nodoInciial = nuevoNodo;
            nodoFinal.setSiguiente(nodoInciial);
        }
    }

    public void agregarAlFinal(Object dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (nodoInciial == null) {
            nodoInciial = nuevoNodo;
            nodoFinal = nuevoNodo;
            nuevoNodo.setSiguiente(nodoInciial);
        } else {
            nodoFinal.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(nodoInciial);
            nodoFinal = nuevoNodo;
        }
    }

    public void agregarPorIndice(int indice, Object dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (nodoInciial == null) {
            nodoInciial = nuevoNodo;
            nodoFinal = nuevoNodo;
            nuevoNodo.setSiguiente(nodoInciial);
        } else {
            Nodo temp = nodoInciial;
            for (int i = 0; i < indice - 1; i++) {
                temp = temp.getSiguiente();
            }
            nuevoNodo.setSiguiente(temp.siguiente);
            temp.setSiguiente(nuevoNodo);
            if (nuevoNodo.getSiguiente() == nodoInciial) {
                nodoFinal = nuevoNodo;
            }
        }
    }

    public void eliminarAlInicio() {
        if (nodoInciial == null) {
            return;
        } else if (nodoInciial == nodoFinal) {
            nodoInciial = null;
            nodoFinal = null;
        } else {
            nodoInciial = nodoInciial.getSiguiente();
            nodoFinal.setSiguiente(nodoInciial);
        }
    }

    public void eliminarAlFinal() {
        if (nodoInciial == null) {
            return;
        } else if (nodoInciial == nodoFinal) {
            nodoInciial = null;
            nodoFinal = null;
        } else {
            Nodo temp = nodoInciial;
            while (temp.getSiguiente() != nodoFinal) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nodoInciial);
            nodoFinal = temp;
        }
    }

    public void eliminarPorIndice(int indice) {
        if (nodoInciial == null) {
            return;
        } else {
            Nodo temp = nodoInciial;
            for (int i = 0; i < indice - 1; i++) {
                temp = temp.getSiguiente();
            }
            if (temp.siguiente == nodoInciial) {
                nodoInciial = nodoInciial.getSiguiente();
                nodoFinal.setSiguiente(nodoInciial);
            } else if (temp.siguiente == nodoFinal) {
                nodoFinal = temp;
                temp.setSiguiente(nodoInciial);
            } else {
                temp.setSiguiente(temp.siguiente.siguiente);
            }
        }
    }
    
public void eliminarPorDato(Object dato) {
        if (nodoInciial == null) {
            return;
        } else {
            Nodo temp = nodoInciial;
            Nodo prev = null;
            do {
                if (temp.getDato() == dato) {
                    if (prev == null) {
                        nodoInciial = nodoInciial.siguiente;
                        nodoFinal.siguiente = nodoInciial;
                    } else if (temp == nodoFinal) {
                        prev.siguiente = nodoInciial;
                        nodoFinal = prev;
                    } else {
                        prev.siguiente = temp.siguiente;
                    }
                    return;
                }
                prev = temp;
                temp = temp.siguiente;
            } while (temp != nodoInciial);
        }
    }

    public Object buscarPorIndice(int indice) {
        if (nodoInciial == null) {
            return -1;
        } else {
            Nodo temp = nodoInciial;
            int contador = 0;
            do {
                if (contador == indice) {
                    return temp.dato;
                }
                temp = temp.siguiente;
                contador++;
            } while (temp != nodoInciial);
            return -1;
        }
    }

    public Object buscarPorDato(Object dato) {
        if (nodoInciial == null) {
            return -1;
        } else {
            Nodo temp = nodoInciial;
            int contador = 0;
            do {
                if (temp.dato == dato) {
                    return contador;
                }
                temp = temp.getSiguiente();
                contador++;
            } while (temp != nodoInciial);
            return -1;
        }
    }
    
    public void imprimir() {
        if (nodoInciial == null) {
            System.out.println("La lista está vacía");
        } else {
            Nodo actual = nodoInciial;
            do {
                System.out.print(actual.getDato() + " ");
                actual = actual.getSiguiente();
            } while (actual != nodoInciial);
            System.out.println();
        }
    }
}
