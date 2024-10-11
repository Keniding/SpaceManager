/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Ubicacion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UbicacionDAO {
    DbConexion con;

    // Constructor que inicializa la conexión usando la clase DbConexion
    public UbicacionDAO() {
        con = new DbConexion();
    }

    // Método para listar todas las ubicaciones
    public List<Ubicacion> listarUbicaciones() {
        List<Ubicacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM ubicaciones"; // Ajusta este nombre a tu tabla correspondiente
        try {
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ubicacion ubicacion = new Ubicacion();
                ubicacion.setId(rs.getInt("id"));
                ubicacion.setNombre(rs.getString("nombre"));
                ubicacion.setDireccion(rs.getString("direccion"));
                // Añade más setters según los atributos de tu clase Ubicacion
                lista.add(ubicacion);
            }
            System.out.println("Ubicaciones cargadas: " + lista.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Método para agregar una nueva ubicación
    public boolean agregarUbicacion(Ubicacion ubicacion) {
        String sql = "INSERT INTO ubicaciones (nombre) VALUES (?)"; // Ajusta según los campos de tu tabla
        try {
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ps.setString(1, ubicacion.getNombre());
            // Añade más setters según los atributos de tu clase Ubicacion
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para actualizar una ubicación existente
    public boolean actualizarUbicacion(Ubicacion ubicacion) {
        String sql = "UPDATE ubicaciones SET nombre=? WHERE id=?"; // Ajusta según los campos de tu tabla
        try {
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ps.setString(1, ubicacion.getNombre());
            ps.setInt(2, ubicacion.getId());
            // Añade más setters según los atributos de tu clase Ubicacion
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para eliminar una ubicación
    public boolean eliminarUbicacion(int id) {
        String sql = "DELETE FROM ubicaciones WHERE id=?"; // Ajusta según los campos de tu tabla
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
