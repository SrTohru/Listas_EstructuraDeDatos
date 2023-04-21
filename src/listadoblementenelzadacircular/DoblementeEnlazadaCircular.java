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
        ListaDoblementeEnlazadaCircula lista1 = new ListaDoblementeEnlazadaCircula();
    
        System.out.println("Agregar inicio");
        lista1.agregarAlInicio(8);
        lista1.agregarAlInicio(6);
        System.out.println("Agregar fiinal");
        lista1.agregarAlFinal("z");
        lista1.agregarAlFinal("x");

        lista1.imprimir();
        System.out.println("Agregar por indice");
       // lista1.insertarPorIndice(1, "ASD");

        System.out.println("Eliminando por indice");
        lista1.eliminarPorIndice(0);
        lista1.imprimir();
        System.out.println("Eliminandopor dato");
        lista1.eliminarPorDato("z");
        lista1.imprimir();

        // Probamos el método buscarPorDato
        System.out.println("Buscando por dato");
       // lista1.buscarPorDato("B");
        lista1.imprimir();
        System.out.println("Eliminando inicio");
        // Probamos el método eliminarAlInicio
       lista1.eliminarAlInicio();
        lista1.imprimir();
        System.out.println("Eliminandofinal");
        // Probamos el método eliminarAlFinal
       // lista1.eliminarAlFinal();
        lista1.imprimir();

        // Imprimimos la lista enlazada resultante
        System.out.println("Lista enlazada resultante:");
        lista1.imprimir();
    }

}
