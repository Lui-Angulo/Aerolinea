/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aerolinea;

/**
 *
 * @author Lucho
 */
public class Pasajero {

    private String numPasaporte;
    private String nombre;
    private String apellidos;
    public Boleto boleto;

    public Pasajero(String numPasaporte, String nombre, String apellidos, Boleto boleto) {
        this.numPasaporte = numPasaporte;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.boleto = boleto;
    }

    public Pasajero() {
    }

    public String getNumPasaporte() {
        return numPasaporte;
    }

    public void setNumPasaporte(String numPasaporte) {
        this.numPasaporte = numPasaporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    @Override
    public String toString() {
        return "\n Pasajero: " + this.getNumPasaporte() + " - " + this.getNombre() + ", " + this.getApellidos()
                + "\n Tiquete # " + this.getBoleto().getNumBoleto()
                + "\n Partida: " + this.getBoleto().getcOrigen().getNombreCiudad() + " - " + this.getBoleto().getpOrigen().getAbreviatura()
                + "\n Destino: " + this.getBoleto().getcDestino().getNombreCiudad() + " - " + this.getBoleto().getpDestino().getAbreviatura() + "\n";

    }
}
