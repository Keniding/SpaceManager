package controller.servlet;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Ubicacion;
import controller.UbicacionDAO;

public class UbicacionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        // Si no se especifica ninguna acción, mostrar la lista de ubicaciones por defecto
        if (action == null) {
            action = "listar";
        }

        switch (action) {
            case "listar":
                listarUbicaciones(request, response);
                break;
            case "nuevo":
                // lógica para agregar nueva ubicación
                break;
            case "editar":
                // lógica para editar ubicación existente
                break;
            case "eliminar":
                // lógica para eliminar ubicación
                break;
            default:
                listarUbicaciones(request, response);
                break;
        }
    }

    private void listarUbicaciones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UbicacionDAO ubicacionDAO = new UbicacionDAO();
        List<Ubicacion> ubicaciones = ubicacionDAO.listarUbicaciones(); // Obtener todas las ubicaciones desde el DAO
        request.setAttribute("ubicaciones", ubicaciones);

        // Establecer el valor de pageContent para cargar ubicaciones.jsp dentro de main.jsp
        request.setAttribute("pageContent", "/view/ubicaciones.jsp");

        // Reenviar la petición a main.jsp en lugar de ubicaciones.jsp directamente
        request.getRequestDispatcher("/view/main.jsp").forward(request, response);
    }

    // Otros métodos como agregar, editar y eliminar ubicaciones pueden ser agregados aquí.
}
