/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colaprioridad;

/**
 *
 * @author José Ignacio
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// Clase que representa la cola de prioridad para la simulación de impresora
public class ColaPrioridad {
    List<Usuario> usuarios;
    List<Documento> documentos;
    Map<String, Integer> prioridades;
    Map<String, Integer> indiceDocumento; // HashMap para almacenar índices de documentos por nombre

    // Constructor de la clase ColaPrioridad
    public ColaPrioridad() {
        this.usuarios = new ArrayList<>();
        this.documentos = new ArrayList<>();
        this.prioridades = new HashMap<>();
        this.prioridades.put("prioridad_alta", 1);
        this.prioridades.put("prioridad_media", 2);
        this.prioridades.put("prioridad_baja", 3);
        this.indiceDocumento = new HashMap<>();
    }

    // Método para agregar un usuario a la simulación
    public void agregarUsuario(String nombre, String tipo) {
        Usuario usuario = new Usuario(nombre, tipo);
        usuarios.add(usuario);
        System.out.println("Se agregó el usuario: " + nombre);
    }

    // Método para cargar usuarios desde un archivo CSV
    public void cargarUsuariosDesdeCSV(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                agregarUsuario(partes[0].trim(), partes[1].trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para agregar un documento a la cola de impresión
    public void agregarDocumento(String nombreUsuario, String nombreDocumento, int tamaño, String tipoDocumento) {
        Optional<Usuario> optionalUsuario = usuarios.stream().filter(u -> u.nombre.equals(nombreUsuario)).findFirst();

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.agregarDocumento(nombreDocumento, tamaño, tipoDocumento);
            Documento nuevoDocumento = usuario.getDocumentos().get(usuario.getDocumentos().size() - 1);
            documentos.add(nuevoDocumento);
            indiceDocumento.put(nuevoDocumento.nombre, documentos.size() - 1);
            heapifyUp(documentos.size() - 1);
            System.out.println("Se agregó el documento '" + nombreDocumento + "' a la cola de impresión");
        } else {
            System.out.println("Usuario no encontrado: " + nombreUsuario);
        }
    }

    // Método para liberar la impresora (eliminar el documento de mayor prioridad)
    public Documento liberarImpresora() {
        if (documentos.isEmpty()) {
            System.out.println("No hay documentos en la cola de impresión.");
            return null;
        }

        Documento documentoImpreso = documentos.get(0);
        documentos.set(0, documentos.get(documentos.size() - 1));
        documentos.remove(documentos.size() - 1);
        indiceDocumento.remove(documentoImpreso.nombre); // Eliminar del mapa
        heapifyDown(0);

        System.out.println("Se imprimió el documento: " + documentoImpreso.nombre);
        return documentoImpreso;
    }

    // Método para eliminar un documento de la cola de impresión
    public void eliminarDocumento(String nombreDocumento) {
        Integer indice = indiceDocumento.get(nombreDocumento);

        if (indice != null) {
            documentos.set(indice, documentos.get(documentos.size() - 1));
            documentos.remove(documentos.size() - 1);
            indiceDocumento.remove(nombreDocumento); // Eliminar del mapa
            heapifyDown(indice);
            System.out.println("Se eliminó el documento: " + nombreDocumento + " de la cola de impresión");
        } else {
            System.out.println("No se encontró el documento: " + nombreDocumento + " en la cola de impresión");
        }
    }

    // Método para mantener la propiedad de montículo binario después de agregar un documento
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (compare(documentos.get(index), documentos.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    // Método para mantener la propiedad de montículo binario después de liberar la impresora
    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        if (leftChild < documentos.size() && compare(documentos.get(leftChild), documentos.get(smallest)) < 0) {
            smallest = leftChild;
        }

        if (rightChild < documentos.size() && compare(documentos.get(rightChild), documentos.get(smallest)) < 0) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    // Método para intercambiar dos documentos en la cola de impresión
    private void swap(int i, int j) {
        Documento temp = documentos.get(i);
        documentos.set(i, documentos.get(j));
        documentos.set(j, temp);
    }

    // Método para comparar dos documentos según su prioridad
    private int compare(Documento doc1, Documento doc2) {
        int prio1 = prioridades.get(doc1.tipo);
        int prio2 = prioridades.get(doc2.tipo);
        return Integer.compare(prio1, prio2);
    }

    // Método para mostrar la cola de impresión
    public void mostrarColaImpresion() {
        System.out.println("Cola de Impresión:");
        for (Documento documento : documentos) {
            System.out.println("Nombre: " + documento.nombre + ", Tamaño: " + documento.tamaño + ", Tipo: " + documento.tipo);
        }
    }
}

// Clase principal que ejecuta la simulación de impresora
public class SimulacionImpresora {
    
    public static void main(String[] args) {
        ColaPrioridad colaPrioridad = new ColaPrioridad();

        // Cargar usuarios desde un archivo CSV
        colaPrioridad.cargarUsuariosDesdeCSV("usuarios.csv");

        // Agregar documentos a la cola de impresión
        colaPrioridad.agregarDocumento("Jperez", "Documento1", 10, "prioridad_alta");
        colaPrioridad.agregarDocumento("m_himiot_alfaro", "Documento2", 5, "prioridad_media");
        colaPrioridad.agregarDocumento("yurdaneta_1", "Documento3", 15, "prioridad_baja");

        // Mostrar cola de impresión
        colaPrioridad.mostrarColaImpresion();

        // Liberar impresora
        colaPrioridad.liberarImpresora();

        // Mostrar cola de impresión después de imprimir
        colaPrioridad.mostrarColaImpresion();

        // Eliminar un documento de la cola
        colaPrioridad.eliminarDocumento("Documento2");

        // Mostrar cola de impresión después de eliminar
        colaPrioridad.mostrarColaImpresion();
    }
}

