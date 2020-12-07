/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colas;
import Colas.Nodo;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucho
 */
public class ListaEnlazada<T> {

    private Nodo<T> primero;

    //constructor por defecto
    public ListaEnlazada() {
        this.listaVacia();
    }

    //métodos de la clase
    /*método que permite vaciar la lista*/
    private void listaVacia() {
        this.primero = null;
    }

    /*método que verifica si la lista está vacía*/
    public boolean estaVacia() {
        return this.primero == null;
        /* la sentencia anterior equivale al siguiente if
        
        if(this.primero == null){
            return true;
        }else{
            return false;
        }
         */
    }

    /*insertar un valor al principio de la lista*/
    public void insertarPrimero(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);

        if (!this.estaVacia()) {
            //si la lista no est{a vacía, el primero actual pasa a ser
            //el siguiente (enlace) del nuevo nodo.
            nuevo.setSiguiente(this.primero);
        }

        this.primero = nuevo;
    }

    /*insertar un valor al final de la lista*/
    public void insertarFinal(T valor) {
        Nodo<T> auxiliar = new Nodo<>(valor);
        Nodo<T> recibe = new Nodo<>();

        if (this.estaVacia()) {
            this.insertarPrimero(valor);
        } else {
            recibe = this.primero;

            //buscar el nodo al final de la lista
            while (recibe.getSiguiente() != null) {
                recibe = recibe.getSiguiente();
            }

            //modificar el siguiente (enlace) del último nodo
            recibe.setSiguiente(auxiliar);
        }
    }

    /*quitar o eliminar el primer elemento de la lista*/
    public void quitarPrimero() {
        Nodo<T> auxiliar;
        if (!this.estaVacia()) {
            auxiliar = this.primero;
            this.primero = this.primero.getSiguiente();
            auxiliar = null;
        }
    }

    /*quitar o eliminar el último elemento de la lista*/
    public void quitarUltimo() {
        Nodo<T> auxiliar = this.primero;
        if (auxiliar.getSiguiente() == null) { //si solo hay un nodo en la lista
            this.listaVacia();
        }

        if (!this.estaVacia()) {
            auxiliar = this.primero;

            //buscar el penúltimo nodo
            while (auxiliar.getSiguiente().getSiguiente() != null) {
                auxiliar = auxiliar.getSiguiente();
            }

            //asignar el siguiente del antepenúltimo como nulo, eliminando el último
            auxiliar.setSiguiente(null);
        }
    }

    /*obtener el último nodo de la lista*/
    public T obtenerUltimoLista() {
        T elemento = null;
        Nodo<T> auxiliar;
        if (!this.estaVacia()) {
            auxiliar = this.primero;

            //buscar el último
            while (auxiliar.getSiguiente() != null) {
                auxiliar = auxiliar.getSiguiente();
            }

            elemento = auxiliar.getValor();
        }

        return elemento;
    }

    /*obtener el primer elemento de la lista*/
    public T obtenerPrimeroLista() {
        T elemento = null;
        if (!this.estaVacia()) {
            elemento = this.primero.getValor();
        }
        return elemento;
    }

    /*obtener la cantidad de elementos de la lista*/
    public int cantidadElementosLista() {
        Nodo<T> auxiliar;
        int cantElementos = 0;
        auxiliar = this.primero;

        //recorrer uno a uno los nodos hasta determinar que no hay nodos
        while (auxiliar != null) { //si retorna true, hay un nodo en la lista, si retorna false, ya no hay más nodos
            cantElementos++;
            auxiliar = auxiliar.getSiguiente();
        }

        return cantElementos;
    }

    /*obtener el valor de un nodo en una posición (índice) específico*/
    public T obtenerValorNodo(int indice) {
        T valor = null;
        Nodo<T> auxiliar = this.primero;
        int posicion = 0;

        if (indice < 0 || indice >= this.cantidadElementosLista()) {
            JOptionPane.showMessageDialog(null, "Índice buscado es menor a 0 o excede el tamaño de la lista.");
        } else {
            while (auxiliar != null) {
                if (posicion == indice) {
                    valor = auxiliar.getValor();
                    auxiliar = null;
                } else {
                    auxiliar = auxiliar.getSiguiente();
                    posicion++;
                }
            }
        }

        return valor;
    }

    /*obtener el nodo en una posición (índice) específico*/
    public Nodo<T> obtenerNodo(int indice) {
        Nodo<T> nodo = null;
        Nodo<T> auxiliar = this.primero;
        int posicion = 0;

        if (indice < 0 || indice >= this.cantidadElementosLista()) {
            JOptionPane.showMessageDialog(null, "Índice buscado es menor a 0 o excede el tamaño de la lista.");
        } else {
            while (auxiliar != null) {
                if (posicion == indice) {
                    nodo = auxiliar;
                    auxiliar = null;
                } else {
                    auxiliar = auxiliar.getSiguiente();
                    posicion++;
                }
            }
        }

        return nodo;
    }

    /*insertar un nodo en una posición específica*/
    public void insertarNodoPosicion(int indice, T valor) {
        Nodo<T> auxiliar = this.primero;
        Nodo<T> nuevo = null;
        Nodo<T> anterior = this.primero;
        int posicion = 0;

        if (indice < 0 || indice >= this.cantidadElementosLista()) {
            JOptionPane.showMessageDialog(null, "Índice buscado es menor a 0 o excede el tamaño de la lista.");
        } else {
            if (indice == 0) {
                this.insertarPrimero(valor);
            } else if (indice == this.cantidadElementosLista()) {
                this.insertarFinal(valor);
            } else {
                while (auxiliar != null) {
                    if (indice == posicion) {
                        //crear el nodo en la posición indicada, y su enlace sería
                        //el nodo que estaba en esa posición (auxiliar)
                        nuevo = new Nodo<>(valor, auxiliar);
                        //asignar al nodo anterior, el nuevo nodo como su siguiente (enlace)
                        anterior.setSiguiente(nuevo);
                        auxiliar = null;
                    } else {
                        anterior = auxiliar;
                        auxiliar = auxiliar.getSiguiente();
                        posicion++;
                    }
                }
            }
        }
    }

    /*modificare valor de un nodo en una posición (índice) específico*/
    public void modificarValorNodo(int indice, T nuevoValor) {
        Nodo<T> auxiliar = this.primero;
        int posicion = 0;

        if (indice < 0 || indice >= this.cantidadElementosLista()) {
            JOptionPane.showMessageDialog(null, "Índice buscado es menor a 0 o excede el tamaño de la lista.");
        } else {
            while (auxiliar != null) {
                if (posicion == indice) {
                    //se modifica el valor actual del nodo y se sustituye por nuevoValor
                    auxiliar.setValor(nuevoValor);
                    auxiliar = null;
                } else {
                    auxiliar = auxiliar.getSiguiente();
                    posicion++;
                }
            }
        }
    }

    /*eliminar un nodo de la lista ubicado en una posición (índice) específico*/
    public void borrarNodoPosicion(int indice) {
        Nodo<T> auxiliar = this.primero;
        Nodo<T> anterior = null;
        int posicion = 0;

        if (indice < 0 || indice >= this.cantidadElementosLista()) {
            JOptionPane.showMessageDialog(null, "Índice buscado es menor a 0 o excede el tamaño de la lista.");
        } else {
            while (auxiliar != null) {
                if (indice == posicion) {
                    if (anterior == null) {
                        this.primero = primero.getSiguiente();
                    } else {
                        anterior.setSiguiente(auxiliar.getSiguiente());
                    }
                    auxiliar = null;
                } else {
                    anterior = auxiliar;
                    auxiliar = auxiliar.getSiguiente();
                    posicion++;
                }
            }
        }
    }

    /*obtiene el primer elemento de la lista y lo elimina de esta*/
    public T obtenerYBorrarPrimero() {
        T elemento = this.obtenerPrimeroLista();
        this.quitarPrimero();
        return elemento;
    }

    /*indicar la primera posición en la que se encuentra un valor específico*/
    public int indiceDeValor(T valor) {
        Nodo<T> auxiliar = this.primero;
        if (this.estaVacia()) {
            return -1;
        } else {
            int posicion = 0;
            boolean encontrado = false;

            //buscar el valor en cada nodo, forzar a finalizar el ciclo cuando encontrado = true
            while (auxiliar != null && !encontrado) {
                //se compara si el valor buscado es igual al valor del nodo actual
                if (valor.equals(auxiliar.getValor())) {
                    //si es igual, se cambia encontrado a true para finalizar la búsqueda
                    encontrado = true;
                } else {
                    posicion++;
                    auxiliar = auxiliar.getSiguiente();
                }
            }

            if (encontrado) {
                return posicion; //primera posición donde fue hallado el valor que se busca
            } else {
                return -1; //no fue encontrado
            }
        }
    }

    /*indicar la primera posición (índice) de un valor, a partir de una posición (índice) específica*/
    public int indiceDeValor(T valor, int indice) {
        Nodo<T> auxiliar;
        if (this.estaVacia()) {
            return -1;
        } else {
            int posicion = 0;
            boolean encontrado = false;

            //se inicia a partir del nodo ubicado en la posición indicada por parámetro (índice).
            //se considera que ese sería el "primer" nodo de la lista para efectos de esta búsqueda
            auxiliar = this.obtenerNodo(indice);

            while (auxiliar != null && !encontrado) {
                //se compara si el valor buscado es igual al valor del nodo actual
                if (valor.equals(auxiliar.getValor())) {
                    //si es igual, se cambia encontrado a true para finalizar la búsqueda
                    encontrado = true;
                } else {
                    posicion++;
                    auxiliar = auxiliar.getSiguiente();
                }
            }

            if (encontrado) {
                return posicion; //primera posición donde fue hallado el valor que se busca
            } else {
                return -1; //no fue encontrado
            }
        }
    }

    /*indicar si un valor existe en la lista*/
    public boolean existeValorLista(T valor) {
        boolean existe = false;
        Nodo<T> auxiliar = this.primero;

        while (auxiliar != null && !existe) {
            if (auxiliar.getValor().equals(valor)) {
                existe = true;
            } else {
                auxiliar = auxiliar.getSiguiente();
            }
        }

        return existe;
    }

    /*imprimir el contenido de la lista*/
    @Override
    public String toString() {
        String imprimir = "";
        Nodo<T> auxiliar = this.primero;

        while (auxiliar != null) {
            imprimir += auxiliar.getValor().toString();
            auxiliar = auxiliar.getSiguiente();
        }

        return imprimir;
    }
}
