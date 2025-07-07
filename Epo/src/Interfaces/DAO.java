/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import java.util.List;
import java.sql.SQLException;
/**
 *
 * @author maick
 * @param <T>
 */
public interface DAO <T>{
    void insertar(T objeto) throws SQLException;
    void actualizar(T objeto)throws SQLException;
    void eliminar(Integer id)throws SQLException;
    T buscar(Integer id)throws SQLException;
    List<T>listar()throws SQLException;
}
