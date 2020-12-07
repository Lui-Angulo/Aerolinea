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
public class Pais {

    protected String abreviatura;
    protected String nombrePais;
    protected String[] showPaises;
    protected String[] showAbreviaturas;
    String[] paises = new String[6];
    String[] abreviaturas = new String[6];

    public Pais(String abreviatura, String nombrePais) {
        this.abreviatura = abreviatura;
        this.nombrePais = nombrePais;
        this.showPaises = llamadaPaises();
        this.showAbreviaturas = llamadaAbreviaturas();
    }

    public Pais() {
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String[] llamadaPaises() {

        paises[0] = " – 6568 – Andorra ";
        paises[1] = " – 6569 – United Arab Emirates ";
        paises[2] = " – 6665 – Bosnia and Herzegovina ";
        paises[3] = " – 6666 – Barbados ";
        paises[4] = " – 7778 – Mongolia ";
        paises[5] = " – 7879 – Norway ";

        return paises;
    }

    public String[] llamadaAbreviaturas() {

        abreviaturas[0] = "AD";
        abreviaturas[1] = "AE";
        abreviaturas[2] = "BA";
        abreviaturas[3] = "BB";
        abreviaturas[4] = "MN";
        abreviaturas[5] = "NO";

        return abreviaturas;
    }

}
