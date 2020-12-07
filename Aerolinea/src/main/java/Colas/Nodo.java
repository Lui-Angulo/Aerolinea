/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colas;

/**
 *
 * @author Lucho
 */
public class Nodo<T> {
        private T valor;
    private Nodo<T> siguiente;
    
    //constructor por defecto
    public Nodo(){
        this.siguiente = null;
    }
    
    //constructor con sobrecarga
    public Nodo(T pValor){
        this.valor = pValor;
        this.siguiente = null;
    }
    
    //constructor con sobrecarga (enlace conocido)
    public Nodo(T pValor, Nodo<T> pSiguiente){
        this.valor = pValor;
        this.siguiente = pSiguiente;
    }
    
    //métodos encapsulados
    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}
