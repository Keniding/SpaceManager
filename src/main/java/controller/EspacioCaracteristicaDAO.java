/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.EspacioCaracteristica;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspacioCaracteristicaDAO {
    DbConexion con;

    // Constructor que inicializa la conexión usando la clase DbConexion
    public EspacioCaracteristicaDAO() {
        con = new DbConexion();
    }

    // Método para listar todas las relaciones entre espacio y característica
    public List<EspacioCaracteristica> listarEspacioCaracteristicas() {
        List<EspacioCaracteristica> lista = new ArrayList<>();
        String sql = "SELECT * FROM espacio_caracteristicas"; // Ajusta este nombre a tu tabla correspondiente
        try {
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EspacioCaracteristica ec = new EspacioCaracteristica();
                ec.setId(rs.getInt("id"));
                ec.setEspacioId(rs.getInt("espacio_id"));
                ec.setCaracteristicaId(rs.getInt("caracteristica_id"));
                // Añade más setters según los atributos de tu clase EspacioCaracteristica
                lista.add(ec);
            }
            System.out.println("EspacioCaracteristicas cargadas: " + lista.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Método para agregar una nueva relación entre espacio y característica
    public boolean agregarEspacioCaracteristica(EspacioCaracteristica ec) {
        String sql = "INSERT INTO espacio_caracteristicas (espacio_id, caracteristicas_id) VALUES (?, ?)"; // Ajusta según los campos de tu tabla
        try {
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, ec.getEspacioId());
            ps.setInt(2, ec.getCaracteristicaId());
            // Añade más setters según los atributos de tu clase EspacioCaracteristica
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para actualizar una relación existente entre espacio y característica
    public boolean actualizarEspacioCaracteristica(EspacioCaracteristica ec) {
        String sql = "UPDATE espacio_caracteristicas SET espacio_id=?, caracteristicas_id=? WHERE id=?"; // Ajusta según los campos de tu tabla
        try {
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, ec.getEspacioId());
            ps.setInt(2, ec.getCaracteristicaId());
            ps.setInt(3, ec.getId());
            // Añade más setters según los atributos de tu clase EspacioCaracteristica
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para eliminar una relación entre espacio y característica
    public boolean eliminarEspacioCaracteristica(int id) {
        String sql = "DELETE FROM espacio_caracteristicas WHERE id=?"; // Ajusta según los campos de tu tabla
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
