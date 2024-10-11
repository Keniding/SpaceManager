/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Reserva;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
    DbConexion con;

    // Constructor que inicializa la conexión usando la clase DbConexion
    public ReservaDAO() {
        con = new DbConexion();
    }

    // Método para listar todas las reservas
    public List<Reserva> listarReservas() {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM reservas"; // Ajusta este nombre a tu tabla correspondiente
        try {
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setId(rs.getInt("id"));
                reserva.setFecha(rs.getDate("fecha"));
                reserva.setHoraInicio(rs.getTime("hora_inicio"));
                reserva.setHoraFin(rs.getTime("hora_fin"));
                reserva.setUsuarioId(rs.getInt("usuario_id"));
                reserva.setEspacioId(rs.getInt("espacio_id"));
                reserva.setEstado(rs.getString("estado"));
                // Añade más setters según los atributos de tu clase Reserva
                lista.add(reserva);
            }
            System.out.println("Reservas cargadas: " + lista.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Método para agregar una nueva reserva
    public boolean agregarReserva(Reserva reserva) {
        String sql = "INSERT INTO reservas (fecha, hora_inicio, hora_fin, usuario_id, espacio_id, estado) VALUES (?, ?, ?, ?, ?, ?)"; // Ajusta según los campos de tu tabla
        try {
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(reserva.getFecha().getTime()));
            ps.setTime(2, reserva.getHoraInicio());
            ps.setTime(3, reserva.getHoraFin());
            ps.setInt(4, reserva.getUsuarioId());
            ps.setInt(5, reserva.getEspacioId());
            ps.setString(6, reserva.getEstado());
            // Añade más setters según los atributos de tu clase Reserva
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para actualizar una reserva existente
    public boolean actualizarReserva(Reserva reserva) {
        String sql = "UPDATE reservas SET fecha=?, hora_inicio=?, hora_fin=?, usuario_id=?, espacio_id=?, estado=? WHERE id=?"; // Ajusta según los campos de tu tabla
        try {
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(reserva.getFecha().getTime()));
            ps.setTime(2, reserva.getHoraInicio());
            ps.setTime(3, reserva.getHoraFin());
            ps.setInt(4, reserva.getUsuarioId());
            ps.setInt(5, reserva.getEspacioId());
            ps.setString(6, reserva.getEstado());
            ps.setInt(7, reserva.getId());
            // Añade más setters según los atributos de tu clase Reserva
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para eliminar una reserva
    public boolean eliminarReserva(int id) {
        String sql = "DELETE FROM reservas WHERE id=?"; // Ajusta según los campos de tu tabla
        try {
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
