/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImplement;

import DAO.Conexion;
import Interfaces.DAO;
import Model.Pasajeros;
import java.sql.SQLException;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author maick
 */
public class PasajeroDAOImpl extends Conexion implements DAO<Pasajeros>{
     @Override
    public void insertar(Pasajeros dato) throws SQLException {
        try {
            this.conectar();
            String sql = "INSERT INTO Pasajeros(nombre, dni) VALUES (?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dato.getNombre());
            ps.setString(2, dato.getDocumentoIdentidad());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                dato.setId(rs.getInt(1));
            }

        } catch (Exception e) {
            System.out.println("Error al insertar pasajero: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void actualizar(Pasajeros dato) throws SQLException {
        try {
            this.conectar();
            String sql = "UPDATE Pasajeros SET nombre=?, dni=? WHERE id_pasajero=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, dato.getNombre());
            ps.setString(2, dato.getDocumentoIdentidad());
            ps.setInt(3, dato.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al actualizar pasajero: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        try {
            this.conectar();
            String sql = "DELETE FROM Pasajeros WHERE id_pasajero=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al eliminar pasajero: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public Pasajeros buscar(Integer id) throws SQLException {
        Pasajeros pasajero = null;
        try {
            this.conectar();
            String sql = "SELECT id_pasajero, nombre, dni FROM Pasajeros WHERE id_pasajero=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pasajero = new Pasajeros(
                    rs.getInt("id_pasajero"),
                    rs.getString("nombre"),
                    rs.getString("dni")
                );
            }

        } catch (Exception e) {
            System.out.println("Error al buscar pasajero: " + e.getMessage());
        } finally {
            this.cerrar();
        }
        return pasajero;
    }

    @Override
    public List<Pasajeros> listar() throws SQLException {
        List<Pasajeros> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT id_pasajero, nombre, dni FROM Pasajeros";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Pasajeros(
                    rs.getInt("id_pasajero"),
                    rs.getString("nombre"),
                    rs.getString("dni")
                ));
            }

        } catch (Exception e) {
            System.out.println("Error al listar pasajeros: " + e.getMessage());
        } finally {
            this.cerrar();
        }
        return lista;
    }
}
