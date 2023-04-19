package listadoblementeenlazadas;

public class ListaDoblementeEnlazada {

    private Nodo cabeza;
    private Nodo cola;
    int tamaño = 0;

    public ListaDoblementeEnlazada() {
        this.cabeza = null;
        this.cola = null;
    }

    public void agregarAlInicio(Object valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            tamaño++;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;
            tamaño++;
        }
    }

    public void agregarAlFinal(Object valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (cola == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            tamaño++;
        } else {
            nuevoNodo.anterior = cola;
            cola.siguiente = nuevoNodo;
            cola = nuevoNodo;
            tamaño++;
        }
    }

    public void eliminar(Object valor) {
        Nodo actual = cabeza;

        while (actual != null && actual.getValor() != valor) {
            actual = actual.siguiente;
        }

        if (actual != null) {
            if (actual == cabeza) {
                cabeza = actual.siguiente;
                tamaño--;
                if (cabeza != null) {
                    cabeza.anterior = null;
                }
            } else if (actual == cola) {
                cola = actual.anterior;
                tamaño--;
                if (cola != null) {
                    cola.siguiente = null;
                }
            } else {
                tamaño--;
                actual.anterior.siguiente = actual.siguiente;
                actual.siguiente.anterior = actual.anterior;
            }
        }
    }

    public void agregarPorIndice(int indice, Object valor) {
        if (indice < 0 || (indice > 0 && cabeza == null)) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        if (indice == 0) {
            agregarAlInicio(valor);
            tamaño++;
            return;
        }
        Nodo actual = cabeza;
        for (int i = 1; i < indice; i++) {
            if (actual == null) {
                throw new IndexOutOfBoundsException("Índice fuera de rango");
            }
            tamaño++;
            actual = actual.siguiente;
        }
        if (actual == null) {
            agregarAlFinal(valor);
            tamaño++;
            return;
        }
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.anterior = actual;
        nuevoNodo.siguiente = actual.siguiente;
        actual.siguiente.anterior = nuevoNodo;
        actual.siguiente = nuevoNodo;
    }

    public void eliminarAlInicio() {
        if (cabeza != null) {
            Nodo temp = cabeza;
            cabeza = cabeza.siguiente;
            if (cabeza != null) {
                cabeza.anterior = null;
            } else {
                cola = null;
            }
            temp.siguiente = null;
            tamaño--;
        } else {
            System.out.println("La lista está vacía. No se puede eliminar ningún elemento.");
        }
    }

    public void eliminarAlFinal() {
        if (cabeza == null) {
            return;
        }else if (cabeza.siguiente == cabeza) {
            cabeza = null;
            return;
        }
        Nodo aux = cabeza;
        while (aux.getSiguiente() != null) {
            aux = aux.getSiguiente();
        }
        
        aux.getAnterior().setSiguiente(null);
    }

    public void eliminarPorDato(Object valor) {
        if (cabeza == null) {
            return;
        }
        Nodo actual = cabeza;
        do {
            if (actual.getValor() == valor) {
                if (actual == cabeza) {
                    eliminarAlInicio();
                } else if (actual.getSiguiente() == cola) {
                    eliminarAlFinal();
                } else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getAnterior().setAnterior(actual.anterior);
                }
                return;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    public Object buscarPorIndice(int indice) {
        if (indice < 0 || (indice > 0 && cabeza == null)) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Nodo actual = cabeza;
        for (int i = 0; i < indice; i++) {
            if (actual == null) {
                throw new IndexOutOfBoundsException("Índice fuera de rango");
            }
            actual = actual.siguiente;
        }
        if (actual == null) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        return actual.valor;
    }

    public boolean buscarPorDato(Object valor) {
        if (cabeza == null) {
            return false;
        }
        Nodo actual = cabeza;
        do {
            if (actual.valor == valor) {
                return true;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
        return false;
    }

    public void imprimir() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}
