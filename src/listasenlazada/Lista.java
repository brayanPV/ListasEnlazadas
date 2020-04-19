/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasenlazada;

/**
 *
 * @author stive
 */
public class Lista {

    NodoLista inicio;
    String nombre;

    public Lista() {
        inicio = null;
        nombre = null;
    }

    static void insertarAlPrincipio(Lista lista, int dato) {
//¡ATENCION! No  se verifica la introducción de claves repetidas.
        NodoLista aux;
        aux = new NodoLista(dato);
        aux.sig = lista.inicio;
        lista.inicio = aux;
    }

    //Elimina el primer dato de la lista    
    static void eliminarPrimero(Lista lista) {
        if (lista.inicio != null) {
            lista.inicio = lista.inicio.sig;
        } else {
            System.out.println("Error, lista vacia");
        }
    }

    public void mostrarLista() {
        mostrarLista(inicio);
    }

    static void mostrarLista(NodoLista nodoLista) {
        if (nodoLista != null) {
            System.out.println(nodoLista.clave + " ");
            mostrarLista(nodoLista.sig);
        } else {
            System.out.println("FIN");
        }
    }

    static void insertarAlFinal(Lista l, int dato) {
        //¡ATENCION! No  se verifica la introduccion de claves repetidas.
        l.inicio = insertarAlFinal(l.inicio, dato);
    }

    static NodoLista insertarAlFinal(NodoLista nodoLista, int dato) {
        NodoLista resul = nodoLista;
        if (nodoLista != null) {
            if (nodoLista.clave != dato) {
                nodoLista.sig = insertarAlFinal(nodoLista.sig, dato);
            } else {
                System.out.println("Error.La clave " + dato + " ya existe");
            }
        } else {
            resul = new NodoLista(dato);
            //resul.sig = nodoLista; (Innecesario, ya es null)
        }
        return resul;
    }
//Envio una lista y el dato que quiero intercambiar, cuando lo encuentre va a mover ese dato al siguiente 
    static void intercambiarNodo(Lista l, int dato) {
        l.inicio = intercambiarNodo(l.inicio, dato);
    }

    static NodoLista intercambiarNodo(NodoLista nodoLista, int dato) {
        //NodoLista resul = nodoLista;
        if (nodoLista != null) {
            if (nodoLista.clave != dato) {
                nodoLista.sig = intercambiarNodo(nodoLista.sig, dato);
            } else {
                int aux = nodoLista.clave;
                nodoLista.clave = nodoLista.sig.clave;
                nodoLista.sig.clave = aux;
                return nodoLista;
            }
        } else {
            System.out.println("La lista esta vacia");
        }
        return nodoLista;
    }

    public static void main(String[] args) {
        Lista l = new Lista();
        insertarAlPrincipio(l, 10);
        insertarAlPrincipio(l, 5);
        insertarAlFinal(l, 15);
        insertarAlFinal(l, 20);
        insertarAlFinal(l, 30);
        //insertarAlFinal(l, 20);
        l.mostrarLista();
        System.out.println("INTERCAMBIAR NODO");
        intercambiarNodo(l, 15);
        l.mostrarLista();
    }

}
