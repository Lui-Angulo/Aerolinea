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
public class Ciudad {

    private String nombreCiudad;
    private Pais nomPais;
    protected String[] showCiudades;
    String[] ciudades = new String[6];

    public Ciudad(String nombreCiudad, Pais nomPais) {
        this.nombreCiudad = nombreCiudad;
        this.nomPais = nomPais;
        this.showCiudades = llamadaCiudades();
    }

    public Ciudad() {

    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public Pais getNomPais() {
        return nomPais;
    }

    public void setNomPais(Pais nomPais) {
        this.nomPais = nomPais;
    }

    public String[] llamadaCiudades() {

        ciudades[0] = "- Canillo";
        ciudades[1] = "- Dubai";
        ciudades[2] = "- Tuzla";
        ciudades[3] = "- Holetown";
        ciudades[4] = "- Murun";
        ciudades[5] = "- Bergen";

        return ciudades;
    }

}
