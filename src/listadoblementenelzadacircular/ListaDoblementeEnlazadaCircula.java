package listadoblementenelzadacircular;

public class ListaDoblementeEnlazadaCircula {

    private int size;
    private Nodo cabeza;
    private Nodo cola;

    public ListaDoblementeEnlazadaCircula() {
        size = 0;
        cabeza = null;
        cola = null;
    }

    public boolean estaVacia() {
        return size == 0;
    }

    public int size() {
        return size;
    }
    
   public void addFirst(Object dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (isEmpty()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevoNodo);
            cabeza = nuevoNodo;
        }
        cola.setSiguiente(cabeza);
        cabeza.setAnterior(cola);
        size++;
    }

    public void addLast(Object dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (isEmpty()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(cola);
            cola = nuevoNodo;
        }
        cola.setSiguiente(cabeza);
        cabeza.setAnterior(cola);
        size++;
    }

    public void addByIndex(int index, Object dato) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        } else if (index == 0) {
            addFirst(dato);
        } else if (index == size) {
            addLast(dato);
        } else {
            Nodo nuevoNodo = new Nodo(dato);
            Nodo temp = getNodeByIndex(index);
            Nodo anterior = temp.getAnterior();
            anterior.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(anterior);
            temp.setAnterior(nuevoNodo);
            nuevoNodo.setSiguiente(temp);
            size++;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Lista vacia");
        } else if (size == 1) {
            cabeza = null;
            cola = null;
        } else {
            cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(cola);
            cola.setSiguiente(cabeza);
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Lista vacia");
        } else if (size == 1) {
            cabeza = null;
            cola = null;
        } else {
            cola = cola.getAnterior();
            cola.setSiguiente(cabeza);
            cabeza.setAnterior(cola);
        }
        size--;
    }

    public void removeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        } else if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Nodo temp = getNodeByIndex(index);
            Nodo anterior = temp.getAnterior();
            Nodo siguiente = temp.getSiguiente();
            anterior.setSiguiente(siguiente);
            siguiente.setAnterior(anterior);
            size--;
        }
    }

    public void removeByData(Object dato) {
        if (isEmpty()) {
         System.out.println("Lista vacia");
        } else {
            Nodo temp = cabeza;
            int index = 0;
    
               while (temp != null && !temp.getDato().equals(dato)) {
                temp = temp.getSiguiente();
                index++;
            }
            if (temp == null) {
                 System.out.println("no esta ese valor");
            } else {
                removeByIndex(index);
            }
        }
    }

    public Object getByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        } else {
            Nodo temp = getNodeByIndex(index);
            return temp.getDato();
        }
    }

    public int getByData(Object dato) {
        Nodo temp = cabeza;
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

    private Nodo getNodeByIndex(int index) {
        Nodo temp = cabeza;
        int contador = 0;
        while (contador < index) {
            temp = temp.getSiguiente();
            contador++;
        }
        return temp;
    }
    
        public void imprimir() {
        if (this.cabeza == null) {
            System.out.println("La lista está vacía");
        } else {
            Nodo actual = this.cabeza;
            do {
                System.out.print(actual.getDato() + " ");
                actual = actual.getSiguiente();
            } while (actual != this.cabeza);
            System.out.println();
        }
    }
}
    


