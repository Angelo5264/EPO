/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author maick
 */
public class Buses {
    private int id;
    private String placa;
    private int capacidad;

    public Buses() {
    }

    public Buses( String placa, int capacidad) {
        this.placa = placa;
        this.capacidad = capacidad;
    }

    public Buses(int id, String placa, int capacidad) {
        this.id = id;
        this.placa = placa;
        this.capacidad = capacidad;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }    
}
