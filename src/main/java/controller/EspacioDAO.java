/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Espacio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspacioDAO {
    DbConexion con;

    // Constructor que inicializa la conexión usando la clase DbConexion
    public EspacioDAO() {
        con = new DbConexion();
    }

    // Método para listar todos los espacios
    public List<Espacio> listarEspacios() {
        List<Espacio> lista = new ArrayList<>();
        String sql = "SELECT * FROM espacios"; // Ajusta este nombre a tu tabla correspondiente
        try {
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Espacio espacio = new Espacio();
                espacio.setId(rs.getInt("id"));
                espacio.setNombre(rs.getString("nombre"));
                espacio.setCapacidad(rs.getInt("capacidad"));
                espacio.setEstado(rs.getString("estado"));
                espacio.setSeccionId(rs.getInt("seccion_id"));
                // Añade más setters según los atributos de tu clase Espacio
                lista.add(espacio);
            }
            System.out.println("Espacios cargados: " + lista.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Método para agregar un nuevo espacio
    public boolean agregarEspacio(Espacio espacio) {
        String sql = "INSERT INTO espacios (nombre, capacidad, estado, seccion_id) VALUES (?, ?, ?, ?)"; // Ajusta según los campos de tu tabla
        try {
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ps.setString(1, espacio.getNombre());
            ps.setInt(2, espacio.getCapacidad());
            ps.setString(3, espacio.getEstado());
            ps.setInt(4, espacio.getSeccionId());
            // Añade más setters según los atributos de tu clase Espacio
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para actualizar un espacio existente
    public boolean actualizarEspacio(Espacio espacio) {
        String sql = "UPDATE espacios SET nombre=?, capacidad=?, estado=?, seccion_id=? WHERE id=?"; // Ajusta según los campos de tu tabla
        try {
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ps.setString(1, espacio.getNombre());
            ps.setInt(2, espacio.getCapacidad());
            ps.setString(3, espacio.getEstado());
            ps.setInt(4, espacio.getSeccionId());
            ps.setInt(5, espacio.getId());
            // Añade más setters según los atributos de tu clase Espacio
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para eliminar un espacio
    public boolean eliminarEspacio(int id) {
        String sql = "DELETE FROM espacios WHERE id=?"; // Ajusta según los campos de tu tabla
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

