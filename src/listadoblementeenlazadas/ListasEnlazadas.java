/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listadoblementeenlazadas;

public class ListasEnlazadas {
  public static void main(String[] args) {
    ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();

    // Agregar algunos nodos al inicio
    lista.agregarAlInicio(3);
    lista.agregarAlInicio(2);
    lista.agregarAlInicio(1);

    // Agregar algunos nodos al final
    lista.agregarAlFinal(4);
    lista.agregarAlFinal(5);
    lista.agregarAlFinal(6);

    // Agregar un nodo por índice
    lista.agregarPorIndice(3, 10);

    // Imprimir la lista
    System.out.println("Lista actual: ");
    lista.imprimir();

    // Eliminar el primer nodo
    lista.eliminarAlInicio();

    // Eliminar el último nodo
  //  lista.eliminarAlFinal();

    // Eliminar un nodo por dato
    lista.eliminarPorDato(5);

    // Imprimir la lista nuevamente
    System.out.println("Lista actualizada: ");
    lista.imprimir();

    // Buscar un nodo por índice
    System.out.println("Valor del nodo en el índice 2: " + lista.buscarPorIndice(2));

    // Buscar un nodo por dato
    System.out.println("¿El valor 4 está en la lista? " + lista.buscarPorDato(4));
}


}