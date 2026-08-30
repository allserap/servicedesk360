<%-- 
    Document   : login
    Created on : 28 jul 2026, 6:50:50 p. m.
    Author     : serva
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Acceso | ServiceDesk 360</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css">
</head>
<body>

<main class="contenedor-formulario">
    <h1>Iniciar acceso</h1>
    <p>Ingrese con la cuenta temporal creada en esta práctica.</p>

    <%-- Mostrar alertas únicamente si existe un mensaje --%>
    <c:if test="${not empty mensajeExito}">
        <div class="alerta exito"><c:out value="${mensajeExito}" /></div>
    </c:if>
    <c:if test="${not empty mensajeError}">
        <div class="alerta error"><c:out value="${mensajeError}" /></div>
    </c:if>

    <form action="${pageContext.request.contextPath}/acceso" method="post">
        <div class="grupo-campo">
            <label for="correo">Correo electrónico</label>
            <input id="correo" 
                   name="correo" 
                   type="email" 
                   maxlength="100" 
                   value="<c:out value='${ultimoUsuario}' />" 
                   autocomplete="email" 
                   required>
        </div>

        <div class="grupo-campo">
            <label for="clave">Contraseña</label>
            <input id="clave" 
                   name="clave" 
                   type="password" 
                   maxlength="64" 
                   autocomplete="current-password" 
                   required>
        </div>

        <label class="fila-opciones">
            <input type="checkbox" name="recordar" value="si">
            Recordar únicamente mi correo en este navegador
        </label>

        <div class="acciones-formulario">
            <button type="submit">Ingresar</button>
            <a href="${pageContext.request.contextPath}/registro">Crear cuenta temporal</a>
        </div>
    </form>
</main>

</body>
</html>