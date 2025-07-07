/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImplement;

import DAO.Conexion;
import Interfaces.DAO;
import Model.Buses;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maick
 */
public class BusesDAOImpl extends Conexion implements DAO<Buses> {

    @Override
    public void insertar(Buses dato) throws SQLException {
        try {
            this.conectar();
            String sql = "INSERT INTO Buses(placa, capacidad) VALUES (?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dato.getPlaca());
            ps.setInt(2, dato.getCapacidad());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                dato.setId(rs.getInt(1));
            }

        } catch (Exception e) {
            System.out.println("Error al insertar bus: " + e.toString());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void actualizar(Buses dato) throws SQLException {
        try {
            this.conectar();
            String sql = "UPDATE Buses SET placa=?, capacidad=? WHERE id_bus=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, dato.getPlaca());
            ps.setInt(2, dato.getCapacidad());
            ps.setInt(3, dato.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al actualizar bus: " + e.toString());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        try {
            this.conectar();
            String sql = "DELETE FROM Buses WHERE id_bus=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al eliminar bus: " + e.toString());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public Buses buscar(Integer id) throws SQLException {
        Buses bus = null;
        try {
            this.conectar();
            String sql = "SELECT id_bus, placa, capacidad FROM Buses WHERE id_bus=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bus = new Buses(
                        rs.getInt("id_bus"),
                        rs.getString("placa"),
                        rs.getInt("capacidad")
                );
            }

        } catch (Exception e) {
            System.out.println("Error al buscar bus: " + e.toString());
        } finally {
            this.cerrar();
        }
        return bus;
    }

    @Override
    public List<Buses> listar() throws SQLException {
        List<Buses> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT id_bus, placa, capacidad FROM Buses";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Buses(
                        rs.getInt("id_bus"),
                        rs.getString("placa"),
                        rs.getInt("capacidad")
                ));
            }

        } catch (Exception e) {
            System.out.println("Error al listar buses: " + e.toString());
        } finally {
            this.cerrar();
        }
        return lista;
    }

}
