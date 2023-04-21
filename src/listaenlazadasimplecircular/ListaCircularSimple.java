package listaenlazadasimplecircular;

public class ListaCircularSimple {

    private Nodo cabeza;
    private Nodo cola;
    private int tamanio;

    public ListaCircularSimple() {
        this.cabeza = null;
        this.cola = new Nodo("test");
        this.tamanio = 0;
    }

    public void agregarAlInicio(Object dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            nuevoNodo.siguiente = cabeza;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
            cola.siguiente = cabeza;
        }
    }

    public void agregarAlFinal(Object dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            nuevoNodo.siguiente = cabeza;
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.siguiente = cabeza;
            cola = nuevoNodo;
        }
    }

    public void agregarPorIndice(int indice, Object dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            nuevoNodo.siguiente = cabeza;
        } else {
            Nodo temp = cabeza;
            for (int i = 0; i < indice - 1; i++) {
                temp = temp.siguiente;
            }
            nuevoNodo.siguiente = temp.siguiente;
            temp.siguiente = nuevoNodo;
            if (nuevoNodo.siguiente == cabeza) {
                cola = nuevoNodo;
            }
        }
    }

    public void eliminarAlInicio() {
        if (cabeza == null) {
            return;
        } else if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cabeza = cabeza.siguiente;
            cola.siguiente = cabeza;
        }
    }

    public void eliminarAlFinal() {
        if (cabeza == null) {
            return;
        } else if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != cola) {
                temp = temp.siguiente;
            }
            temp.siguiente = cabeza;
            cola = temp;
        }
    }

    public void eliminarPorIndice(int indice) {
        if (cabeza == null) {
            return;
        } else {
            Nodo temp = cabeza;
            for (int i = 0; i < indice - 1; i++) {
                temp = temp.siguiente;
            }
            if (temp.siguiente == cabeza) {
                cabeza = cabeza.siguiente;
                cola.siguiente = cabeza;
            } else if (temp.siguiente == cola) {
                cola = temp;
                temp.siguiente = cabeza;
            } else {
                temp.siguiente = temp.siguiente.siguiente;
            }
        }
    }
    
public void eliminarPorDato(Object dato) {
        if (cabeza == null) {
            return;
        } else {
            Nodo temp = cabeza;
            Nodo prev = null;
            do {
                if (temp.getDato() == dato) {
                    if (prev == null) {
                        cabeza = cabeza.siguiente;
                        cola.siguiente = cabeza;
                    } else if (temp == cola) {
                        prev.siguiente = cabeza;
                        cola = prev;
                    } else {
                        prev.siguiente = temp.siguiente;
                    }
                    return;
                }
                prev = temp;
                temp = temp.siguiente;
            } while (temp != cabeza);
        }
    }

    public Object buscarPorIndice(int indice) {
        if (cabeza == null) {
            return -1;
        } else {
            Nodo temp = cabeza;
            int contador = 0;
            do {
                if (contador == indice) {
                    return temp.dato;
                }
                temp = temp.siguiente;
                contador++;
            } while (temp != cabeza);
            return -1;
        }
    }

    public Object buscarPorDato(Object dato) {
        if (cabeza == null) {
            return -1;
        } else {
            Nodo temp = cabeza;
            int contador = 0;
            do {
                if (temp.dato == dato) {
                    return contador;
                }
                temp = temp.siguiente;
                contador++;
            } while (temp != cabeza);
            return -1;
        }
    }

    public void listar() {
        if (cabeza == null) {
            return;
        } else {
            Nodo temp = cabeza;
            do {
                System.out.print(temp.dato + " ");
                temp = temp.siguiente;
            } while (temp != cabeza);
            System.out.println();
        }
    }

    public void imprimir() {
        if (this.cabeza == null) {
            System.out.println("La lista está vacía");
        } else {
            Nodo actual = this.cabeza;
            do {
                System.out.print(actual.dato + " ");
                actual = actual.siguiente;
            } while (actual != this.cabeza);
            System.out.println();
        }
    }
}
