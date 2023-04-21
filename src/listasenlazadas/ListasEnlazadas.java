/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listasenlazadas;

/**
 *
 * @author lv1822
 */
public class ListasEnlazadas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaEnlazada lista1 = new ListaEnlazada(new Nodo("n1"));
        System.out.println("Agregar inicio");
        lista1.agregarAlInicio(8);
        lista1.agregarAlInicio(6);
        System.out.println("Agregar fiinal");
        lista1.agregarAlFinal("z");
        lista1.agregarAlFinal("x");

        lista1.printList();
        System.out.println("Agregar por indice");
        lista1.insertarPorIndice(1, "ASD");
       
        System.out.println("Eliminando por indice");
        lista1.eliminarPorIndice(0);
        lista1.printList();
        System.out.println("Eliminandopor dato");
        lista1.eliminarPorDato("z");
        lista1.printList();

        // Probamos el método buscarPorDato
        System.out.println("Buscando por dato");
        lista1.buscarPorDato("B");
        lista1.printList();
System.out.println("Eliminando inicio");
        // Probamos el método eliminarAlInicio
        lista1.eliminarAlInicio();
        lista1.printList();
System.out.println("Eliminandofinal");
        // Probamos el método eliminarAlFinal
        lista1.eliminarAlFinal();
        lista1.printList();

        // Imprimimos la lista enlazada resultante
        System.out.println("Lista enlazada resultante:");
        lista1.printList();
    }

}
