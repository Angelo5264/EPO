/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalTime;


/**
 *
 * @author maick
 */
public class Rutas {
    private int id;
    private String origen;
    private String destino;
    private LocalTime horaSalida;
    private int idBus;

    public Rutas() {
    }

    public Rutas( String origen, String destino, LocalTime horaSalida, int idBus) {
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.idBus = idBus;
    }

    public Rutas(int id, String origen, String destino, LocalTime horaSalida, int idBus) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.idBus = idBus;
    }

    public Rutas(int id) {
        this.id = id;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getIdBus() {
        return idBus;
    }

    public void setIdBus(int idBus) {
        this.idBus = idBus;
    }
    
}
