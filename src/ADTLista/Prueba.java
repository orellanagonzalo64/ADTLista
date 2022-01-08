/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADTLista;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Orellana, Gonzalo Leandro
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Lista lista1 = new Lista();

        //Cargo nuevos valores para mostrar el funcionamiento correcto de otros metodos
        lista1.insertarAlInicio(5);
        lista1.insertarAlInicio(4);
        lista1.insertarAlInicio(3);
        lista1.insertarAlInicio(2);
        lista1.insertarAlInicio(1);

        lista1.mostrar();

        //Metodo para insertar un nodo al inicio
        lista1.insertarAlInicio(Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero para insertar al inicio: ")));

        lista1.mostrar();

        //Metodo para insertar un nodo al final
        lista1.insertarAlFinal(Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero para insertar al final: ")));

        lista1.mostrar();

        //Metodo para eliminar el primer nodo de la lista
        lista1.eliminarPrimerNodo();

        System.out.println("Lista con el primer nodo borrado: ");

        lista1.mostrar();

        //Metodo para eliminar el ultimo nodo de la lista
        lista1.eliminarUltimoNodo();

        System.out.println("Lista con el ultimo nodo borrado: ");

        lista1.mostrar();

        //Metodo para borrar todo nodo que contenga un valor
        lista1.eliminarNodosValor(Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero para borrar todos los nodos que lo contengan: ")));

        System.out.println("La lista con el valor borrado es: ");
        lista1.mostrar();

        //Metodo para obtener el contenido de un nodo segun su posicion
        System.out.println(lista1.obtenerValor(Integer.parseInt(JOptionPane.showInputDialog("Introduzca la posicion del nodo a obtener su valor: "))));

        lista1.mostrar();

        //Metodo para modificar el contenido de un nodo segun su posicion
        lista1.modificarValor(Integer.parseInt(JOptionPane.showInputDialog("Introduzca la posicion del nodo a modificar su valor: ")), Integer.parseInt(JOptionPane.showInputDialog("Introduzca la posicion del nodo a modificar su valor: ")));

        lista1.mostrar();

        //Metodo para insertar un nodo segun su posicion
        lista1.insertarNodo(Integer.parseInt(JOptionPane.showInputDialog("Introduzca la posicion donde insertar el nodo: ")), Integer.parseInt(JOptionPane.showInputDialog("Introduzca el valor del contenido del nuevo nodo: ")));

        lista1.mostrar();

        //Metodo para eliminar un nodo segun su posicion
        lista1.eliminarNodoPosicionI(Integer.parseInt(JOptionPane.showInputDialog("Introduzca la posicion del nodo a borrar: ")));

        lista1.mostrar();

        //Listas vacias
        Lista l1 = new Lista();
        Lista l2 = new Lista();

        determinarParImpar(l1, l2);

        System.out.println("Lista con valores par: ");
        l1.mostrar();

        System.out.println("Lista con valores impar: ");
        l2.mostrar();

    }

    private static void determinarParImpar(Lista lista1, Lista lista2) {

        if (lista1.esVacia() && lista2.esVacia()) {

            int i = 0, aleatorio;
            String cantidad = JOptionPane.showInputDialog("Introduzca la cantidad de valores: ");

            for (i = 0; i < Integer.parseInt(cantidad); i++) {

                aleatorio = (int) (Math.random() * 10 + 1);

                if (aleatorio % 2 == 0) {  //añade numeros pares a la lista 1 
                    lista1.insertarAlInicio(aleatorio);
                } else {         //añade numeros impares a la lista 2
                    lista2.insertarAlInicio(aleatorio);
                }

            }

            return;

        } else {
            System.out.println("Ambas listas deben estar vacias."
                    + "");
        }

    }

}
