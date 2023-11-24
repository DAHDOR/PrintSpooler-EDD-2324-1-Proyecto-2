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
import java.util.ArrayList;
import java.util.List;

// Clase que representa a un usuario en la simulación
public class Usuario {
    String nombre;
    String tipo;
    List <Documento> documentos;

    // Constructor de la clase Usuario
    public Usuario(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.documentos = new ArrayList<>();
    }

    // Método para agregar un documento al usuario
    public void agregarDocumento(String nombre, int tamaño, String tipo) {
        Documento documento = new Documento(nombre, tamaño, tipo);
        documentos.add(documento);
        System.out.println("Se agregó el documento '" + nombre + "' al usuario '" + this.nombre + "'");
    }

    // Método para obtener la lista de documentos del usuario
    public List<Documento> getDocumentos() {
        return documentos;
    }
}

