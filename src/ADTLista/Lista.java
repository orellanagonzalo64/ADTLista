/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADTLista;

/**
 *
 * @author Orellana, Gonzalo Leandro
 */
public class Lista {

    private Nodo primero;

    class Nodo {

        private int numero;
        private Nodo siguiente;

        Nodo(int numero) {
            this.numero = numero;
            this.siguiente = null;
        }

        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

    }

    Lista() {
        this.primero = null;
    }

    public boolean esVacia() {

        if (this.primero == null) {
            return true;
        }

        return false;

    }

    public void insertarAlInicio(int numero) {

        Nodo aux = new Nodo(numero);

        aux.setSiguiente(primero);

        primero = aux;

    }

    public void insertarAlFinal(int numero) {

        Nodo nuevo = new Nodo(numero);

        if (this.esVacia()) {
            primero = nuevo;
        } else {

            Nodo aux = primero;

            while (aux.siguiente != null) {
                aux = aux.getSiguiente();
            }

            aux.setSiguiente(nuevo);

        }

    }

    public int cantidadNodos() {

        Nodo aux;

        if (this.esVacia()) {
            System.out.println("Lista vacia");
            return 0;
        } else {

            aux = primero;
            int cantidad = 0;

            while (aux != null) {
                aux = aux.getSiguiente();
                cantidad++;

            }

            System.out.println("La cantidad de nodos es: " + cantidad);

            return cantidad;

        }

    }

    public void eliminarPrimerNodo() {

        Nodo aux;

        if (this.esVacia()) {
            System.out.println("Lista vacia");
        } else {

            aux = primero.getSiguiente();

            primero = aux;

        }

    }

    public void eliminarUltimoNodo() {

        Nodo aux;

        if (this.esVacia()) {
            System.out.println("No se puede eliminar el ultimo nodo, lista vacia");
        } else {

            aux = primero;

            //Movemos la referencia hasta el penultimo nodo
            while (aux.getSiguiente().getSiguiente() != null) {
                aux = aux.getSiguiente();
            }

            //Hacemos que su siguiente nodo sea null
            aux.setSiguiente(null);

        }

    }

    //Funcion auxiliar para eliminar un nodo, es private porque no se usara fuera
    private void eliminarNodo(Nodo nodoABorrar) {

        Nodo aux;

        aux = primero;

        if (nodoABorrar == aux) {
            this.eliminarPrimerNodo();
            return;
        } else {

            while (aux.getSiguiente() != nodoABorrar || aux.getSiguiente() == null) {
                aux = aux.getSiguiente();
            }

            aux.setSiguiente(aux.getSiguiente().getSiguiente());
        }

    }

    public void eliminarNodosValor(int valor) {

        Nodo aux;

        aux = primero;

        int i, bandera = 0;

        //Recorro todo la lista buscando ese valor
        while (aux != null) {
            if (aux.getNumero() == valor) {
                bandera = 1;
                //Si lo encuentro elimino el nodo que contenga ese valor
                this.eliminarNodo(aux);
            }
            aux = aux.getSiguiente();

        }

        if (bandera == 0) {
            System.out.println("Valor no encontrado");
            return;
        }

    }

    public int obtenerValor(int posicion) {

        Nodo aux;

        aux = primero;

        int i;

        if (primero == null) {
            System.out.println("No hay elementos en la lista");
            return 0;
        }

        if (posicion >= this.cantidadNodos() || posicion < 0) {
            System.out.println("La posicion no existe, por lo tanto no se puede obtener el valor");
            return 0;
        } else {

            for (i = 0; i < posicion; i++) {
                aux = aux.getSiguiente();
            }

            return aux.getNumero();

        }

    }

    public void modificarValor(int posicion, int nuevoValor) {

        Nodo aux;

        aux = primero;

        int i;

        if (primero == null) {
            System.out.println("No hay elementos en la lista");

        }

        if (posicion >= this.cantidadNodos() || posicion < 0) {
            System.out.println("La posicion no existe, por lo tanto no se puede modificar el valor");
        } else {

            for (i = 0; i < posicion; i++) {
                aux = aux.getSiguiente();
            }

            aux.setNumero(nuevoValor);

        }

    }

    public void insertarNodo(int posicion, int valor) {

        if (posicion >= this.cantidadNodos() || posicion < 0) {
            System.out.println("La posicion no existe, por lo tanto no se puede modificar el valor");
        } else {

            if (posicion == 0) {
                this.insertarAlInicio(valor);
            }

            if (posicion == (this.cantidadNodos() - 1)) {
                this.insertarAlFinal(valor);
                return;
            }

            Nodo aux;

            aux = primero;

            Nodo aux2;

            aux2 = primero;

            Nodo nuevo = new Nodo(valor);

            int i;

            for (i = 0; i < posicion - 1; i++) {
                aux = aux.getSiguiente();
            }

            for (i = 0; i < posicion; i++) {
                aux2 = aux2.getSiguiente();
            }

            aux.setSiguiente(nuevo);

            nuevo.siguiente = aux2;

        }

    }

    public void eliminarNodoPosicionI(int posicion) {

        Nodo aux;

        aux = primero;
        int i = 0;

        if (posicion >= this.cantidadNodos() || posicion < 0) {
            System.out.println("La posicion no existe, por lo tanto no se puede borrar");
        } else {

            if (posicion == 0) {
                this.eliminarPrimerNodo();
            } else {

                for (i = 1; i <= posicion - 1; i++) {
                    aux = aux.getSiguiente();
                }

                aux.setSiguiente(aux.getSiguiente().getSiguiente());
            }
        }

    }

    public void mostrar() {

        Nodo aux;

        aux = primero;

        while (aux != null) {
            System.out.print(aux.getNumero() + "->");
            aux = aux.getSiguiente();
        }

        System.out.println("null");

    }

}
