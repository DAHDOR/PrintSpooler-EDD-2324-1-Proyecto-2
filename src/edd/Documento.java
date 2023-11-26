/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd;

/**
 *
 * @author José Ignacio
 */
// Clase que representa un documento en la simulación
public class Documento {
    String nombre;
    int tamaño;
    String tipo;

    // Constructor de la clase Documento
    public Documento(String nombre, int tamaño, String tipo) {
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.tipo = tipo;
    }
    
    public String getName() {
        return nombre;
    }
    
    public int getSize() {
        return tamaño;
    }
}

