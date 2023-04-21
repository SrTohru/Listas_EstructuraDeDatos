package listadoblementeenlazadas;

public class ListaDoblementeEnlazada {

    private Nodo nodoInicial;
    private Nodo nodoFinal;
    int size = 0;

    public ListaDoblementeEnlazada() {
        this.nodoInicial = null;
        this.nodoFinal = null;
    }

    public void agregarAlInicio(Object valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (nodoInicial == null) {
            nodoInicial = nuevoNodo;
            nodoFinal = nuevoNodo;
            size++;
        } else {
            nuevoNodo.setSiguiente(nodoInicial);
            nodoInicial.setAnterior(nuevoNodo);
            nodoInicial = nuevoNodo;
            size++;
        }
    }

    public void agregarAlFinal(Object valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (nodoFinal == null) {
            nodoInicial = nuevoNodo;
            nodoFinal = nuevoNodo;
            size++;
        } else {
            nuevoNodo.setAnterior(nodoFinal);
            nodoFinal.setSiguiente(nuevoNodo);
            nodoFinal = nuevoNodo;
            size++;
        }
    }

    public void eliminar(Object valor) {
        Nodo actual = nodoInicial;

        while (actual != null && actual.getValor() != valor) {
            actual = actual.getSiguiente();
        }

        if (actual != null) {
            if (actual == nodoInicial) {
                nodoInicial = actual.getSiguiente();
                size--;
                if (nodoInicial != null) {
                    nodoInicial.setAnterior(null);
                }
            } else if (actual == nodoFinal) {
                nodoFinal = actual.getAnterior();
                size--;
                if (nodoFinal != null) {
                    nodoFinal.setSiguiente(null);
                }
            } else {
                size--;
                actual.getAnterior().setSiguiente(actual.siguiente);
                actual.getSiguiente().setAnterior(actual.anterior);
            }
        }
    }

    public void agregarPorIndice(int indice, Object valor) {
        if (indice < 0 || (indice > 0 && nodoInicial == null)) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        if (indice == 0) {
            agregarAlInicio(valor);
            size++;
            return;
        }
        Nodo actual = nodoInicial;
        for (int i = 1; i < indice; i++) {
            if (actual == null) {
                throw new IndexOutOfBoundsException("Dato nulo");
            }
            size++;
            actual = actual.getSiguiente();
        }
        if (actual == null) {
            agregarAlFinal(valor);
            size++;
            return;
        }
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.setAnterior(actual);
        nuevoNodo.setSiguiente(actual.getSiguiente());
        actual.siguiente.anterior = nuevoNodo;
        actual.siguiente = nuevoNodo;
    }

    public void eliminarAlInicio() {
        if (nodoInicial != null) {
            Nodo temp = nodoInicial;
            nodoInicial = nodoInicial.getSiguiente();
            if (nodoInicial != null) {
                nodoInicial.setAnterior(null);
            } else {
                nodoFinal = null;
            }
            temp.setSiguiente(null);
            size--;
        } else {
            System.out.println("La lista está vacía. No se puede eliminar ningún elemento.");
        }
    }

    public void eliminarAlFinal() {
        if (nodoInicial == null) {
            return;
        }else if (nodoInicial.getSiguiente() == nodoInicial) {
            nodoInicial = null;
            return;
        }
        Nodo aux = nodoInicial;
        while (aux.getSiguiente() != null) {
            aux = aux.getSiguiente();
        }
        
        aux.getAnterior().setSiguiente(null);
    }

    public void eliminarPorDato(Object valor) {
        if (nodoInicial == null) {
            return;
        }
        Nodo actual = nodoInicial;
        do {
            if (actual.getValor() == valor) {
                if (actual == nodoInicial) {
                    eliminarAlInicio();
                } else if (actual.getSiguiente() == nodoFinal) {
                    eliminarAlFinal();
                } else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getAnterior().setAnterior(actual.getAnterior());
                }
                return;
            }
            actual = actual.siguiente;
        } while (actual != nodoInicial);
    }

    public Object buscarPorIndice(int indice) {
        if (indice < 0 || (indice > 0 && nodoInicial == null)) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Nodo actual = nodoInicial;
        for (int i = 0; i < indice; i++) {
            if (actual == null) {
                throw new IndexOutOfBoundsException("Índice fuera de rango");
            }
            actual = actual.getSiguiente();
        }
        if (actual == null) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        return actual.valor;
    }

    public boolean buscarPorDato(Object valor) {
        if (nodoInicial == null) {
            return false;
        }
        Nodo actual = nodoInicial;
        do {
            if (actual.getValor() == valor) {
                return true;
            }
            actual = actual.getSiguiente();
        } while (actual != nodoInicial);
        return false;
    }

    
    public void eliminarPorIndice(int indice) {
        // Si el índice es 0, eliminar el primer nodo
        if (indice == 0) {
            if (nodoInicial == null) {
                return;
            }
            nodoInicial = nodoInicial.getSiguiente();
            if (nodoInicial == null) {
                nodoFinal = null;
            } else {
                nodoInicial.setAnterior(null);
            }
            size--;
            return;
        }

        // Si el índice es igual al size de la lista - 1, eliminar el último nodo
        if (indice == size - 1) {
            if (nodoFinal == null) {
                return;
            }
            nodoFinal = nodoFinal.getAnterior();
            if (nodoFinal == null) {
                nodoInicial = null;
            } else {
                nodoFinal.siguiente = null;
            }
            size--;
            return;
        }

        // Si el índice está en medio de la lista, buscar el nodo en ese índice
        Nodo nodoActual = nodoInicial;
        int contador = 0;
        while (nodoActual != null && contador < indice) {
            nodoActual = nodoActual.siguiente;
            contador++;
        }

        // Eliminar el nodo actual
        nodoActual.anterior.siguiente = nodoActual.siguiente;
        nodoActual.siguiente.anterior = nodoActual.anterior;
        size--;
    }

    
     public void insertarPorIndice( int indice, Object valor) {
        Nodo nuevoNodo = new Nodo(valor);

        // Si el índice es 0, insertar al principio de la lista
        if (indice == 0) {
            nuevoNodo.siguiente = nodoInicial;
            if (nodoInicial != null) {
                nodoInicial.anterior = nuevoNodo;
            }
            nodoInicial = nuevoNodo;
            if (nodoFinal == null) {
                nodoFinal = nuevoNodo;
            }
            size++;
            return;
        }

        // Si el índice es igual al size de la lista, insertar al final de la lista
        if (indice == size) {
            nuevoNodo.anterior = nodoFinal;
            if (nodoFinal != null) {
                nodoFinal.siguiente = nuevoNodo;
            }
            nodoFinal = nuevoNodo;
            if (nodoInicial == null) {
                nodoInicial = nuevoNodo;
            }
            size++;
            return;
        }

        // Si el índice está en medio de la lista, buscar el nodo en ese índice
        Nodo nodoActual = nodoInicial;
        int contador = 0;
        while (nodoActual != null && contador < indice) {
            nodoActual = nodoActual.siguiente;
            contador++;
        }

        // Insertar el nuevo nodo antes del nodo actual
        nuevoNodo.siguiente = nodoActual;
        nuevoNodo.anterior = nodoActual.anterior;
        nodoActual.anterior.siguiente = nuevoNodo;
        nodoActual.anterior = nuevoNodo;
        size++;
    }
    
    public void imprimir() {
        Nodo actual = nodoInicial;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}
