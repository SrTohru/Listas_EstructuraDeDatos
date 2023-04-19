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
        lista1.addIni(8);
        lista1.addIni(6);
        lista1.add2End("z");
        lista1.add2End("x");

        lista1.printList();
        System.out.println(lista1.size());
        System.out.println("Eliminando");
        lista1.eliminarPorIndice(0);
        lista1.printList();
        System.out.println("Eliminando");
       lista1.eliminarPorDato("z");
        lista1.printList();
    }

}
