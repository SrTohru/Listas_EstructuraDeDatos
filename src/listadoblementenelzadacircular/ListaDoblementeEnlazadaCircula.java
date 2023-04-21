package listadoblementenelzadacircular;

public class ListaDoblementeEnlazadaCircula {

    private int size;
    private Nodo nodoInicial;
    private Nodo nodoFinal;

    public ListaDoblementeEnlazadaCircula() {
        size = 0;
        nodoInicial = null;
        nodoFinal = null;
    }

    public boolean estaVacia() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void eliminarAlInicio() {
        if (nodoInicial == null) {
            return;
        }

        if (nodoInicial.getSiguiente() == nodoInicial) {
            nodoInicial = null;
            size = 0;
            return;
        }

        Nodo nodoEliminado = nodoInicial;
        nodoInicial = nodoInicial.getSiguiente();
        nodoInicial.setAnterior(nodoEliminado.getAnterior());
        nodoInicial.getAnterior().setSiguiente(nodoInicial);
        size--;
    }

    public void agregarAlInicio(Object dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (isEmpty()) {
            nodoInicial = nuevoNodo;
            nodoFinal = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(nodoInicial);
            nodoInicial.setAnterior(nuevoNodo);
            nodoInicial = nuevoNodo;
        }
        nodoFinal.setSiguiente(nodoInicial);
        nodoInicial.setAnterior(nodoFinal);
        size++;
    }

    public void agregarAlFinal(Object dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (isEmpty()) {
            nodoInicial = nuevoNodo;
            nodoFinal = nuevoNodo;
        } else {
            nodoFinal.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(nodoFinal);
            nodoFinal = nuevoNodo;
        }
        nodoFinal.setSiguiente(nodoInicial);
        nodoInicial.setAnterior(nodoFinal);
        size++;
    }

    public void agregarPorIndice(int index, Object dato) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        } else if (index == 0) {
            agregarAlInicio(dato);
        } else if (index == size) {
            agregarAlFinal(dato);
        } else {
            Nodo nuevoNodo = new Nodo(dato);
            Nodo temp = obtenerPorElIndice(index);
            Nodo anterior = temp.getAnterior();
            anterior.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(anterior);
            temp.setAnterior(nuevoNodo);
            nuevoNodo.setSiguiente(temp);
            size++;
        }
    }

    public void eliminarPrimero() {
        if (isEmpty()) {
            System.out.println("Lista vacia");
        } else if (size == 1) {
            nodoInicial = null;
            nodoFinal = null;
        } else {
            nodoInicial = nodoInicial.getSiguiente();
            nodoInicial.setAnterior(nodoFinal);
            nodoFinal.setSiguiente(nodoInicial);
        }
        size--;
    }

    public void eliminarUltimo() {
        if (isEmpty()) {
            System.out.println("Lista vacia");
        } else if (size == 1) {
            nodoInicial = null;
            nodoFinal = null;
        } else {
            nodoFinal = nodoFinal.getAnterior();
            nodoFinal.setSiguiente(nodoInicial);
            nodoInicial.setAnterior(nodoFinal);
        }
        size--;
    }

    public void eliminarPorIndice(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        } else if (index == 0) {
            eliminarPrimero();
        } else if (index == size - 1) {
            eliminarUltimo();
        } else {
            Nodo temp = obtenerPorElIndice(index);
            Nodo anterior = temp.getAnterior();
            Nodo siguiente = temp.getSiguiente();
            anterior.setSiguiente(siguiente);
            siguiente.setAnterior(anterior);
            size--;
        }
    }

    public void eliminarPorDato(Object dato) {
        if (isEmpty()) {
            System.out.println("Lista vacia");
        } else {
            Nodo temp = nodoInicial;
            int index = 0;

            while (temp != null && !(temp.getDato() == dato)) {
                temp = temp.getSiguiente();
                index++;
            }
            if (temp == null) {
                System.out.println("no esta ese valor");
            } else {
                eliminarPorIndice(index);
            }
        }
    }

    public Object obtenerPorIndice(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        } else {
            Nodo temp = obtenerPorElIndice(index);
            return temp.getDato();
        }
    }

    public Object obtenerPorDato(Object dato) {
        Nodo temp = nodoInicial;
        int index = 0;
        while (temp != null && !temp.getDato().equals(dato)) {
            temp = temp.getSiguiente();
            index++;
        }
        if (temp == null) {
            System.out.println("no esta ese valor");
        } else {
            return index;
        }
        return -1;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private Nodo obtenerPorElIndice(int index) {
        Nodo temp = nodoInicial;
        int contador = 0;
        while (contador < index) {
            temp = temp.getSiguiente();
            contador++;
        }
        return temp;
    }

    public void imprimir() {
        if (nodoInicial == null) {
            System.out.println("La lista está vacía");
        } else {
            Nodo actual = nodoInicial;
            do {
                System.out.print(actual.getDato() + " ");
                actual = actual.getSiguiente();
            } while (actual != nodoInicial);
        }
    }
}
