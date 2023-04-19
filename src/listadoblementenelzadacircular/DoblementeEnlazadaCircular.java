/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listadoblementenelzadacircular;

/**
 *
 * @author usuario
 */
public class DoblementeEnlazadaCircular {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaDoblementeEnlazadaCircula lista = new ListaDoblementeEnlazadaCircula();

        // Agregar elementos al principio de la lista
        lista.addFirst("Elemento 1");
        lista.addFirst("Elemento 2");
        lista.addFirst("Elemento 3");

        // Agregar elementos al final de la lista
        lista.addLast("Elemento 4");
        lista.addLast("Elemento 5");
        lista.addLast("Elemento 6");

        // Imprimir la lista
        lista.imprimir();

        // Eliminar elementos del principio de la lista
        lista.removeFirst();
        lista.removeFirst();
        lista.removeFirst();

        // Imprimir la lista actualizada
        lista.imprimir();

        // Eliminar elementos del final de la lista
        lista.removeLast();
        lista.removeLast();


        // Imprimir la lista final
        lista.imprimir();
    }

}
