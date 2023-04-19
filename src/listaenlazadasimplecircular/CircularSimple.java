/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listaenlazadasimplecircular;

/**
 *
 * @author usuario
 */
public class CircularSimple {

    public static void main(String[] args) {
         ListaCircularSimple lista = new ListaCircularSimple();
        
        lista.agregarAlFinal(1);
        lista.agregarAlFinal(2);
        lista.agregarAlFinal(3);
        lista.agregarAlFinal(4);
        lista.agregarAlFinal(5);
        
        System.out.println("Lista inicial: ");
        lista.imprimir();
        
        lista.eliminarPorDato(3);
        System.out.println("Lista después de eliminar el dato 3: ");
        lista.imprimir();
        
        System.out.println("El elemento en el índice 2 es: " + lista.buscarPorIndice(2));
        System.out.println("El elemento con el valor 4 está en el índice: " + lista.buscarPorDato(4));
        
        lista.agregarPorIndice(2, 7);
        System.out.println("Lista después de agregar el valor 7 en el índice 2: ");
        lista.imprimir();
                
        lista.eliminarAlInicio();
        System.out.println("Lista después de eliminar al inicio: ");
        lista.imprimir();
        
        lista.eliminarAlFinal();
        System.out.println("Lista después de eliminar al final: ");
        lista.imprimir();
    }
}

    
