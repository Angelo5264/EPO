/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Acceso;

import DAO.Conexion;
import Model.Usuarios;
import java.sql.*;
/**
 *
 * @author maick
 */
public class Acceso extends Conexion {
    public Usuarios verificarAcceso(String correo, String contraseña) throws SQLException {
        Usuarios usuario = null;

        try {
            this.conectar();
            String sql = "SELECT id_usuario, nombre, correo FROM Usuarios WHERE correo=? AND contraseña=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuarios(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                // Por seguridad, no se devuelve la contraseña
            }

        } catch (Exception e) {
            System.out.println("Error al verificar acceso: " + e.getMessage());
        } finally {
            this.cerrar();
        }

        return usuario;
    }
}
