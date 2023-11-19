/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cola.impresion;

/**
 *
 * @author José Ignacio
 */
public class ColaImpresion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Usuario {
    String nombre;
    String tipo;
    List<Documento> documentos;

    public Usuario(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.documentos = new ArrayList<>();
    }

    public void agregarDocumento(String nombre, int tamaño, String tipo) {
        Documento documento = new Documento(nombre, tamaño, tipo);
        documentos.add(documento);
        System.out.println("Se agregó el documento '" + nombre + "' al usuario '" + this.nombre + "'");
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }
}

class Documento {
    String nombre;
    int tamaño;
    String tipo;

    public Documento(String nombre, int tamaño, String tipo) {
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.tipo = tipo;
    }
}

class ColaPrioridad {
    List<Usuario> usuarios;
    List<Documento> documentos;
    Map<String, Integer> prioridades;

    public ColaPrioridad() {
        this.usuarios = new ArrayList<>();
        this.documentos = new ArrayList<>();
        this.prioridades = new HashMap<>();
        this.prioridades.put("prioridad_alta", 1);
        this.prioridades.put("prioridad_media", 2);
        this.prioridades.put("prioridad_baja", 3);
    }

    public void agregarUsuario(String nombre, String tipo) {
        Usuario usuario = new Usuario(nombre, tipo);
        usuarios.add(usuario);
        System.out.println("Se agregó el usuario: " + nombre);
    }

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

    public void agregarDocumento(String nombreUsuario, String nombreDocumento, int tamaño, String tipoDocumento) {
        Optional<Usuario> optionalUsuario = usuarios.stream().filter(u -> u.nombre.equals(nombreUsuario)).findFirst();

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.agregarDocumento(nombreDocumento, tamaño, tipoDocumento);
            documentos.add(usuario.getDocumentos().get(usuario.getDocumentos().size() - 1));
            heapifyUp(documentos.size() - 1);
            System.out.println("Se agregó el documento '" + nombreDocumento + "' a la cola de impresión");
        } else {
            System.out.println("Usuario no encontrado: " + nombreUsuario);
        }
    }

    public Documento liberarImpresora() {
        if (documentos.isEmpty()) {
            System.out.println("No hay documentos en la cola de impresión.");
            return null;
        }

        Documento documentoImpreso = documentos.get(0);
        documentos.set(0, documentos.get(documentos.size() - 1));
        documentos.remove(documentos.size() - 1);
        heapifyDown(0);

        System.out.println("Se imprimió el documento: " + documentoImpreso.nombre);
        return documentoImpreso;
    }

    public void eliminarDocumento(String nombreDocumento) {
        for (int i = 0; i < documentos.size(); i++) {
            if (documentos.get(i).nombre.equals(nombreDocumento)) {
                documentos.remove(i);
                heapifyDown(i);
                System.out.println("Se eliminó el documento: " + nombreDocumento + " de la cola de impresión");
                return;
            }
        }
        System.out.println("No se encontró el documento: " + nombreDocumento + " en la cola de impresión");
    }

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

    private void swap(int i, int j) {
        Documento temp = documentos.get(i);
        documentos.set(i, documentos.get(j));
        documentos.set(j, temp);
    }

    private int compare(Documento doc1, Documento doc2) {
        int prio1 = prioridades.get(doc1.tipo);
        int prio2 = prioridades.get(doc2.tipo);
        return Integer.compare(prio1, prio2);
    }

    public void mostrarColaImpresion() {
        System.out.println("Cola de Impresión:");
        for (Documento documento : documentos) {
            System.out.println("Nombre: " + documento.nombre + ", Tamaño: " + documento.tamaño + ", Tipo: " + documento.tipo);
        }
    }
}

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

}
