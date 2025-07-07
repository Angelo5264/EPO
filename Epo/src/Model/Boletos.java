/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author maick
 */
public class Boletos {

    private int id;
    private Usuarios usuario;
    private Pasajeros pasajero;
    private Rutas Ruta;

    public Boletos() {
    }

    public Boletos(Usuarios usuario, Pasajeros pasajero, Rutas Ruta) {
        this.usuario = usuario;
        this.pasajero = pasajero;
        this.Ruta = Ruta;
    }

    public Boletos(int id, Usuarios usuario, Pasajeros pasajero, Rutas Ruta) {
        this.id = id;
        this.usuario = usuario;
        this.pasajero = pasajero;
        this.Ruta = Ruta;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Pasajeros getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajeros pasajero) {
        this.pasajero = pasajero;
    }

    public Rutas getRuta() {
        return Ruta;
    }

    public void setRuta(Rutas Ruta) {
        this.Ruta = Ruta;
    }

}
