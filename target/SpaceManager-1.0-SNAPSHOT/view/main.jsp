<%-- 
    Document   : main
    Created on : 13 sept 2024, 23:56:22
    Author     : Bruce Porras
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Espacios</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <!-- Header -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">SpaceManager</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="InicioServlet?action=inicio">Inicio</a></li>
                <li class="nav-item"><a class="nav-link" href="UbicacionServlet?action=listar">Gestión de Ubicaciones</a></li>               
                <li class="nav-item"><a class="nav-link" href="MainServlet?action=secciones">Gestión de Secciones</a></li>
                <li class="nav-item"><a class="nav-link" href="MainServlet?action=espacios">Gestión de Espacios</a></li>
                <li class="nav-item"><a class="nav-link" href="MainServlet?action=usuarios">Gestión de Usuarios</a></li>
                <li class="nav-item"><a class="nav-link" href="MainServlet?action=reservar">Reservar Espacio</a></li>
                <li class="nav-item"><a class="nav-link" href="MainServlet?action=misreservas">Mis Reservas</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Cerrar Sesión</a></li>
            </ul>
        </div>
    </nav>

    <!-- Main Content -->
    <div class="container mt-4">
        <%-- Cargar contenido dinámico basado en la acción --%>
        <jsp:include page="${pageContent}" />
    </div>

    <!-- Footer -->
    <footer class="bg-light text-center text-lg-start mt-4">
        <div class="text-center p-3">
            © 2024 SpaceManager - Todos los derechos reservados.
        </div>
    </footer>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
