/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aerolinea;

import Colas.ListaEnlazada;
import static com.mycompany.aerolinea.Main.select;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucho
 */
public class Vuelo {

    private String idVuelo;
    ListaEnlazada<Pasajero> pasajeros = new ListaEnlazada<>();

    public Vuelo() {
        this.idVuelo = crearID();
    }

    public ListaEnlazada<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(ListaEnlazada<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }

    public String getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    // ID vuelo = AAZ + random generator (100-999) <- pasarlo a string
    public static int generaNumeroAleatorio() {
        int minimo = 100;
        int maximo = 999;

        int num = (int) Math.floor(Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
    }

    public static String crearID() {
        int ran = generaNumeroAleatorio();
        String numS = String.valueOf(ran);
        String iVuelo = "AAZ" + numS;
        return iVuelo;
    }

    public void abordarAvion(ListaEnlazada<Pasajero> people, Vuelo avion) {

        avion.getPasajeros().insertarPrimero(people.obtenerYBorrarPrimero());

        if (people.cantidadElementosLista() == 1) {
            JOptionPane.showMessageDialog(null, "~ Queda " + people.cantidadElementosLista() + " pasajero en espera");
        } else {
            JOptionPane.showMessageDialog(null, "~ Quedan " + people.cantidadElementosLista() + " pasajeros en espera");
        }

        select = -1;

    }

    public void abandonarAvion(Vuelo avion) {
        avion.getPasajeros().quitarPrimero();

        if (avion.getPasajeros().cantidadElementosLista() == 1) {
            JOptionPane.showMessageDialog(null, "~ Queda " + avion.getPasajeros().cantidadElementosLista() + " en el avion");
        } else {
            JOptionPane.showMessageDialog(null, "~ Quedan " + avion.getPasajeros().cantidadElementosLista() + " en el avion");
        }

        select = -1;
    }

    public void mostrarAvion(Vuelo avion) {
        JOptionPane.showMessageDialog(null, avion.getPasajeros().toString());
    }

}
