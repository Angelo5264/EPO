/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author maick
 */
public class Conexion {

    protected Connection conexion;
    private final String url = "jdbc:sqlserver://localhost:1433;database=EPO;user=sa;password=12345678;encrypt=true;trustServerCertificate=true;";

    public void conectar() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // Carga del driver
            conexion = DriverManager.getConnection(url); // Hace la conexión
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public void cerrar() throws SQLException{
        if(conexion != null){
            if(conexion.isClosed()){
                conexion.close();
            }
        }
    }
}
