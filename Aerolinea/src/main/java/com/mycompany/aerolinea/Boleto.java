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
public class Boleto {

    private Pais pOrigen;
    private Pais pDestino;
    private Ciudad cOrigen;
    private Ciudad cDestino;
    private String numBoleto;
    private double valorBoleto;
    private double tax = 0.13;

    public Boleto(Ciudad cOrigen, Pais pOrigen, Ciudad cDestino, Pais pDestino, double valorBoleto) {
        this.cOrigen = cOrigen;
        this.pOrigen = pOrigen;
        this.cDestino = cDestino;
        this.pDestino = pDestino;
        this.numBoleto = crearNumBoleto();
        this.valorBoleto = valorBoleto;
    }

    public Boleto(Pais pOrigen, Pais pDestino, Ciudad cOrigen, Ciudad cDestino, String numBoleto, double valorBoleto) {
        this.pOrigen = pOrigen;
        this.pDestino = pDestino;
        this.cOrigen = cOrigen;
        this.cDestino = cDestino;
        this.numBoleto = numBoleto;
        this.valorBoleto = valorBoleto;
    }

    public Boleto() {
    }

    public Ciudad getcOrigen() {
        return cOrigen;
    }

    public void setcOrigen(Ciudad cOrigen) {
        this.cOrigen = cOrigen;
    }

    public Ciudad getcDestino() {
        return cDestino;
    }

    public void setcDestino(Ciudad cDestino) {
        this.cDestino = cDestino;
    }

    public Pais getpOrigen() {
        return pOrigen;
    }

    public void setpOrigen(Pais pOrigen) {
        this.pOrigen = pOrigen;
    }

    public Pais getpDestino() {
        return pDestino;
    }

    public void setpDestino(Pais pDestino) {
        this.pDestino = pDestino;
    }

    public String getNumBoleto() {
        return numBoleto;
    }

    public void setNumBoleto(String numBoleto) {
        this.numBoleto = numBoleto;
    }

    public double getValorBoleto() {
        return valorBoleto;
    }

    public void setValorBoleto(double valorBoleto) {
        this.valorBoleto = valorBoleto;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public static int generaNumAleatorio() {
        int minimo = 100000;
        int maximo = 20000000;

        int num = (int) Math.floor(Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
    }

    private String crearNumBoleto() {
        int ran = generaNumAleatorio();
        numBoleto = String.valueOf(ran);
        return numBoleto;
    }

    public double valorBol(double x, double y) {
        valorBoleto = (x + y) + ((x + y) * tax);
        return valorBoleto;
    }

}
