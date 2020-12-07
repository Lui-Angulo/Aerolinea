/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aerolinea;

import Colas.ListaEnlazada;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static String pedir, nombre, apellidos, pasaporte;
    static int select = -1;
    static int paisO, paisD;
    static double valorPO, valorPD, valorTotal;

    public static void main(String[] args) {
        // TODO code application logic here

        Pais pOrigen = new Pais();
        Pais pDestino = new Pais();
        Ciudad cOrigen = new Ciudad();
        Ciudad cDestino = new Ciudad();
        Vuelo avion = new Vuelo();
        ListaEnlazada<Pasajero> people = new ListaEnlazada<>();
        DecimalFormat formato = new DecimalFormat("#.##");

        while (select != 0) {
            select = -1;
            try {
                String lectura = JOptionPane.showInputDialog(null, "************************\nElige opción:\n1.- Agregar un pasajero"
                        + "\n2.- Agregar pasajeros al avión\n"
                        + "3.- Abandonar el avión\n"
                        + "4.- Detalle Pasajero\n"
                        + "5.- Total recaudado\n"
                        + "0.- Salir\n************************");
                //Recoger una variable por consola
                select = Integer.parseInt(lectura);

                //Switch case en Java
                switch (select) {
                    case 1:
                        //Llenar pasajero
                        pideDatos(pOrigen, pDestino, cOrigen, cDestino, people);
                        break;
                    case 2:
                        //Agregar pasajero al avion
                        avion.abordarAvion(people, avion);

                        break;
                    case 3:
                        // Abandonar avion
                        avion.abandonarAvion(avion);
                        break;
                    case 4:
                        //Ver detalle pasajero 
                        String x = buscarPasajero(avion);
                        JOptionPane.showMessageDialog(null, x);
                        break;
                    case 5:
                        //total dinero recaudado y muestra el avion
                        sumTotalVuelo(avion, formato);
                        avion.mostrarAvion(avion);
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Adios!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Número no reconocido");
                        break;
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Uoop! Error!");
            }

        }

    }

    public static void pideDatos(Pais pOrigen, Pais pDestino, Ciudad cOrigen, Ciudad cDestino, ListaEnlazada<Pasajero> people) {
        nombre = JOptionPane.showInputDialog(null, "Digite el nombre: ");

        apellidos = JOptionPane.showInputDialog(null, "Digite los apellidos: ");

        pasaporte = JOptionPane.showInputDialog(null, "Digite el numero de pasaporte: ");
        paisO = 0;
        paisD = 0;

        while (paisO == paisD) {

            try {

                String[] vectorPaises = pOrigen.llamadaPaises();
                String[] vectorAbreviaturas = pOrigen.llamadaAbreviaturas();
                String[] vectorCiudades = cDestino.llamadaCiudades();

                String listaPaises = "";
                for (int i = 0; i < 6; i++) {
                    int m = i + 1;
                    listaPaises += m + ". –   " + vectorAbreviaturas[i] + vectorPaises[i] + vectorCiudades[i] + " \n ";

                }
                String lectura = JOptionPane.showInputDialog(null, listaPaises, "");
                String lectura2 = JOptionPane.showInputDialog(null, listaPaises, "");

                //Recoger una variable por consola
                paisO = Integer.parseInt(lectura) - 1;
                paisD = Integer.parseInt(lectura2) - 1;

                //Revisar si esta bien declarado o si se tiene que hacer Pais pO = new Pais
                pOrigen.setAbreviatura(vectorAbreviaturas[paisO]);
                pOrigen.setNombrePais(vectorPaises[paisO]);
                pDestino.setAbreviatura(vectorAbreviaturas[paisD]);
                pDestino.setNombrePais(vectorPaises[paisD]);
                cOrigen.setNombreCiudad(vectorCiudades[paisO]);
                cDestino.setNombreCiudad(vectorCiudades[paisD]);

                //Switch case en Java
                switch (paisO + 1) {
                    case 1:
                        valorPO = 120;
                        break;
                    case 2:
                        valorPO = 90;
                        break;
                    case 3:
                        valorPO = 85;
                        break;
                    case 4:
                        valorPO = 105;
                        break;
                    case 5:
                        valorPO = 95;
                        break;
                    case 6:
                        valorPO = 75;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Número no reconocido");
                        break;
                }
                switch (paisD + 1) {
                    case 1:
                        valorPD = 120;
                        break;
                    case 2:
                        valorPD = 90;
                        break;
                    case 3:
                        valorPD = 85;
                        break;
                    case 4:
                        valorPD = 105;
                        break;
                    case 5:
                        valorPD = 95;
                        break;
                    case 6:
                        valorPD = 75;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Número no reconocido");
                        break;
                }

                select = -1;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Uoop! Error!");
            }
            if (paisO == paisD) {
                JOptionPane.showMessageDialog(null, "El pais origen y destino no pueden ser iguales");
            } else {
                Boleto bol = new Boleto();
                double total = bol.valorBol(valorPO, valorPD);

                Boleto bolFull = new Boleto(cOrigen, pOrigen, cDestino, pDestino, total);
                Pasajero passenger = new Pasajero(pasaporte, nombre, apellidos, bolFull);

                // accion de agregar a la lista o cola o esa mierda
                people.insertarFinal(passenger);

                double valorSinTax = valorPO + valorPD;

                String x = pOrigen.getAbreviatura() + pOrigen.getNombrePais();
                String y = pDestino.getAbreviatura() + pDestino.getNombrePais();

                JOptionPane.showMessageDialog(null, "~ El precio del boleto es de: $" + valorSinTax + "\n~ Precio con impuestos: $" + total + "\n ~ Origen: " + x + "\n ~ Destino: " + y);
            }
        }

    }

    public static void sumTotalVuelo(Vuelo avion, DecimalFormat formato) {

        double acumulado = 0;

        for (int i = 0; i < avion.getPasajeros().cantidadElementosLista(); i++) {

            acumulado += avion.getPasajeros().obtenerValorNodo(i).getBoleto().valorBol(valorPO, valorPO);

        }

        JOptionPane.showMessageDialog(null, "Total acumulado: $" + Double.parseDouble(formato.format(acumulado)));
        select = -1;
    }

    public static String buscarPasajero(Vuelo avion) {

        String pasaporteX = JOptionPane.showInputDialog(null, "Digite el numero de pasaporte del pasajero: ");

        for (int i = 0; i < avion.getPasajeros().cantidadElementosLista(); i++) {

            // System.out.println(avion.getPasajeros().obtenerValorNodo(i).getNumPasaporte());
            if (pasaporteX.equals(avion.getPasajeros().obtenerValorNodo(i).getNumPasaporte())) {

                return avion.getPasajeros().obtenerValorNodo(i).toString();
            }

        }

        return "No se encontro el pasajero";
    }

}
