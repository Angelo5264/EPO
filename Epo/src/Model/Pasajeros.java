/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author maick
 */
public class Pasajeros {
    private int id;
    private String nombre;
    private String documentoIdentidad;

    public Pasajeros() {
    }

    public Pasajeros(String nombre, String documentoIdentidad) {
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
    }

    public Pasajeros(int id, String nombre, String documentoIdentidad) {
        this.id = id;
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
    }

    public Pasajeros(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }
    
}
