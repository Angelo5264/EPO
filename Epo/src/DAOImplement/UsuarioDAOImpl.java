/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImplement;

import DAO.Conexion;
import Interfaces.DAO;
import Model.Usuarios;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author maick
 */
public class UsuarioDAOImpl extends Conexion implements DAO<Usuarios> {

    @Override
    public void insertar(Usuarios objeto) throws SQLException {
        try {
            this.conectar();
            String sql = "INSERT INTO Usuarios (nombre, correo) VALUES (?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, objeto.getNombre());
            ps.setString(2, objeto.getCorreo());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int idGenerado = rs.getInt(1); // El ID autogenerado
                objeto.setId(idGenerado); // Lo guardas en tu objeto Usuarios
            }

        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void actualizar(Usuarios objeto) throws SQLException {
        try {
            this.conectar();
            String sql = "UPDATE Usuarios SET nombre=?, correo=? WHERE id=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, objeto.getNombre());
            ps.setString(2, objeto.getCorreo());
            ps.setInt(3, objeto.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        try {
            this.conectar();
            String sql = "DELETE FROM Usuarios WHERE id=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public Usuarios buscar(Integer id) throws SQLException {
        Usuarios usuario = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM Usuarios WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuarios(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("contraseña")
                );
            }

        } catch (Exception e) {
            System.out.println("Error al buscar: " + e.getMessage());
        } finally {
            this.cerrar();
        }
        return usuario;
    }

    @Override
    public List<Usuarios> listar() throws SQLException {
        List<Usuarios> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM Usuarios";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuarios usuario = new Usuarios(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("contraseña")
                );
                lista.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
        } finally {
            this.cerrar();
        }
        return lista;
    }
}


