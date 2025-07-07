/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImplement;
import DAO.Conexion;
import Interfaces.DAO;
import Model.Rutas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author maick
 */
public class RutasDAOImpl extends Conexion implements DAO<Rutas>{
    @Override
    public void insertar(Rutas dato) throws SQLException {
        try {
            this.conectar();
            String sql = "INSERT INTO Rutas(origen, destino, hora_salida, id_bus) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dato.getOrigen());
            ps.setString(2, dato.getDestino());
            ps.setTime(3, Time.valueOf(dato.getHoraSalida()));
            ps.setInt(4, dato.getIdBus());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                dato.setId(rs.getInt(1));
            }

        } catch (Exception e) {
            System.out.println("Error al insertar ruta: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void actualizar(Rutas dato) throws SQLException {
        try {
            this.conectar();
            String sql = "UPDATE Rutas SET origen=?, destino=?, hora_salida=?, id_bus=? WHERE id_ruta=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, dato.getOrigen());
            ps.setString(2, dato.getDestino());
            ps.setTime(3, Time.valueOf(dato.getHoraSalida()));
            ps.setInt(4, dato.getIdBus());
            ps.setInt(5, dato.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al actualizar ruta: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        try {
            this.conectar();
            String sql = "DELETE FROM Rutas WHERE id_ruta=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al eliminar ruta: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public Rutas buscar(Integer id) throws SQLException {
        Rutas ruta = null;
        try {
            this.conectar();
            String sql = "SELECT id_ruta, origen, destino, hora_salida, id_bus FROM Rutas WHERE id_ruta=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ruta = new Rutas(
                    rs.getInt("id_ruta"),
                    rs.getString("origen"),
                    rs.getString("destino"),
                    rs.getTime("hora_salida").toLocalTime(),
                    rs.getInt("id_bus")
                );
            }

        } catch (Exception e) {
            System.out.println("Error al buscar ruta: " + e.getMessage());
        } finally {
            this.cerrar();
        }
        return ruta;
    }

    @Override
    public List<Rutas> listar() throws SQLException {
        List<Rutas> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT id_ruta, origen, destino, hora_salida, id_bus FROM Rutas";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Rutas(
                    rs.getInt("id_ruta"),
                    rs.getString("origen"),
                    rs.getString("destino"),
                    rs.getTime("hora_salida").toLocalTime(),
                    rs.getInt("id_bus")
                ));
            }

        } catch (Exception e) {
            System.out.println("Error al listar rutas: " + e.getMessage());
        } finally {
            this.cerrar();
        }
        return lista;
    }
}
