/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImplement;

import DAO.Conexion;
import Interfaces.DAO;
import Model.Boletos;
import Model.Pasajeros;
import Model.Rutas;
import Model.Usuarios;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maick
 */
public class BoletasDAOImpl extends Conexion implements DAO<Boletos> {

    @Override
    public void insertar(Boletos dato) throws SQLException {
        try {
            this.conectar();
            String sql = "INSERT INTO Boletos (id_usuario, id_pasajero, id_ruta) VALUES (?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dato.getUsuario().getId());
            ps.setInt(2, dato.getPasajero().getId());
            ps.setInt(3, dato.getRuta().getId());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                dato.setId(rs.getInt(1));
            }

        } catch (Exception e) {
            System.out.println("Error al insertar boleto: " + e.toString());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void actualizar(Boletos dato) throws SQLException {
        try {
            this.conectar();
            String sql = "UPDATE Boletos SET id_usuario=?, id_pasajero=?, id_ruta=? WHERE id_boleto=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, dato.getUsuario().getId());
            ps.setInt(2, dato.getPasajero().getId());
            ps.setInt(3, dato.getRuta().getId());
            ps.setInt(4, dato.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al actualizar boleto: " + e.toString());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        try {
            this.conectar();
            String sql = "DELETE FROM Boletos WHERE id_boleto=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al eliminar boleto: " + e.toString());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public Boletos buscar(Integer id) throws SQLException {
        Boletos boleto = null;
        try {
            this.conectar();
            String sql = "SELECT id_boleto, id_usuario, id_pasajero, id_ruta FROM Boletos WHERE id_boleto=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                boleto = new Boletos(
                        new Usuarios(rs.getInt("id_usuario")),
                        new Pasajeros(rs.getInt("id_pasajero")),
                        new Rutas(rs.getInt("id_ruta"))
                );
                boleto.setId(rs.getInt("id_boleto"));
            }

        } catch (Exception e) {
            System.out.println("Error al buscar boleto: " + e.toString());
        } finally {
            this.cerrar();
        }
        return boleto;
    }

    @Override
    public List<Boletos> listar() throws SQLException {
        List<Boletos> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT id_boleto, id_usuario, id_pasajero, id_ruta FROM Boletos";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Boletos boleto = new Boletos(
                        new Usuarios(rs.getInt("id_usuario")),
                        new Pasajeros(rs.getInt("id_pasajero")),
                        new Rutas(rs.getInt("id_ruta"))
                );
                boleto.setId(rs.getInt("id_boleto"));
                lista.add(boleto);
            }

        } catch (Exception e) {
            System.out.println("Error al listar boletos: " + e.toString());
        } finally {
            this.cerrar();
        }
        return lista;
    }
}
