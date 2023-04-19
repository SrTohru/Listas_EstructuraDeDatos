package listaenlazadasimplecircular;

public class ListaCircularSimple {

    private Nodo cabeza;
    private Nodo cola;
    private int tamanio;

    public ListaCircularSimple() {
        this.cabeza = null;
        this.cola = null;
        this.tamanio = 0;
    }

    public void agregar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (this.cabeza == null) {
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
            nuevoNodo.siguiente = this.cabeza;
        } else {
            this.cola.siguiente = nuevoNodo;
            this.cola = nuevoNodo;
            this.cola.siguiente = this.cabeza;
        }
        this.tamanio++;
    }

    public int buscarPorDato(int dato) {
        if (tamanio == 0) {
            return -1;
        }

        int indice = 0;
        Nodo actual = cabeza;

        do {
            if (actual.dato == dato) {
                return indice;
            }

            actual = actual.siguiente;
            indice++;
        } while (actual != cabeza);

        return -1;
    }

    public void agregarAlFinal(int dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (tamanio == 0) {
            cabeza = nuevoNodo;
        } else {
            Nodo ultimoNodo = cabeza;
            while (ultimoNodo.siguiente != cabeza) {
                ultimoNodo = ultimoNodo.siguiente;
            }
            ultimoNodo.siguiente = nuevoNodo;
        }

        nuevoNodo.siguiente = cabeza;
    }

    public void agregarPorIndice(int indice, int dato) {
        if (indice < 0 || indice > this.tamanio) {
            throw new IndexOutOfBoundsException();
        }

        Nodo nuevoNodo = new Nodo(dato);

        if (indice == 0) {
            nuevoNodo.siguiente = this.cabeza;
            this.cabeza = nuevoNodo;
            this.cola.siguiente = this.cabeza;
        } else if (indice == this.tamanio) {
            this.cola.siguiente = nuevoNodo;
            this.cola = nuevoNodo;
            this.cola.siguiente = this.cabeza;
        } else {
            Nodo actual = this.cabeza;
            for (int i = 0; i < indice - 1; i++) {
                actual = actual.siguiente;
            }
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
        }
        this.tamanio++;
    }

    public void eliminarAlInicio() {
        if (this.cabeza != null && cola != null) {
            if (this.cabeza == this.cola) {
                this.cabeza = null;
                this.cola = null;
                this.tamanio--;
            } else {
                this.cabeza = this.cabeza.siguiente;
                this.cola.setSiguiente(cabeza);
                this.tamanio--;
            }

        }
    }

    public void eliminarAlFinal() {
        if (this.cabeza != null) {
            if (this.cabeza == this.cola) {
                this.cabeza = null;
                this.cola = null;
            } else {
                Nodo actual = this.cabeza;
                while (actual.siguiente != this.cola) {
                    actual = actual.siguiente;
                }
                actual.siguiente = this.cabeza;
                this.cola = actual;
            }
            this.tamanio--;
        }
    }

    public void eliminarPorDato(int dato) {
        if (this.cabeza != null) {
            if (this.cabeza.dato == dato) {
                this.eliminarAlInicio();
            } else if (this.cola.getDato() == dato) {
                this.eliminarAlFinal();
            } else {
                Nodo actual = this.cabeza;
                while (actual.siguiente != this.cola) {
                    if (actual.siguiente.dato == dato) {
                        actual.siguiente = actual.siguiente.siguiente;
                        this.tamanio--;
                        return;
                    }
                    actual = actual.siguiente;
                }
            }
        }
    }

    public int buscarPorIndice(int indice) {
        if (indice < 0 || indice >= this.tamanio) {
            throw new IndexOutOfBoundsException();
        }

        Nodo actual = this.cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
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
