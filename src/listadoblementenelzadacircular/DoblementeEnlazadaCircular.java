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
        lista.agregarAlInicio("Elemento 1");
        lista.agregarAlInicio("Elemento 2");
        lista.agregarAlInicio("Elemento 3");

        // Agregar elementos al final de la lista
        lista.agregarAlFinal("Elemento 4");
        lista.agregarAlFinal("Elemento 5");
        lista.agregarAlFinal("Elemento 6");

        lista.agregarPorIndice(3, "Elemento 7");
        // Imprimir la lista
        lista.imprimir();

        // Eliminar elementos del principio de la lista
        lista.eliminarPrimero();
        lista.eliminarPrimero();

        // Imprimir la lista actualizada
        lista.imprimir();

        // Eliminar elementos del final de la lista
        lista.eliminarUltimo();
        lista.eliminarUltimo();

        lista.eliminarPorIndice(1);
        lista.eliminarPorDato("Elemento 3");
        
        lista.obtenerPorDato("Elemento 4");
        lista.obtenerPorIndice(3);
        
        // Imprimir la lista final
        lista.imprimir();
    }

}
