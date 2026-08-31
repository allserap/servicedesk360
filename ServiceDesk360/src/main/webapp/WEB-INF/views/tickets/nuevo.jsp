<%-- 
    Document   : nuevo
    Created on : 30 ago 2026, 7:46:05 p. m.
    Author     : serva
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nuevo ticket</title>
</head>
<body>
    <h1>Registrar ticket de soporte</h1>

    <c:if test="${not empty errores}">
        <div class="errores">
            <ul>
                <c:forEach var="error" items="${errores}">
                    <li><c:out value="${error}" /></li>
                </c:forEach>
            </ul>
        </div>
    </c:if>

    <form method="post" action="${pageContext.request.contextPath}/tickets/nuevo">
        <label>Título</label>
        <input type="text" name="titulo" maxlength="100" value="${tituloAnterior}" required>
        <br><br>

        <label>Descripción</label>
        <textarea name="descripcion" rows="6" required><c:out value="${descripcionAnterior}" /></textarea>
        <br><br>

        <label>Prioridad</label>
        <select name="prioridad" required>
            <option value="">Seleccione</option>
            <option value="BAJA">Baja</option>
            <option value="MEDIA">Media</option>
            <option value="ALTA">Alta</option>
            <option value="CRITICA">Crítica</option>
        </select>
        <br><br>

        <button type="submit">Registrar ticket</button>
    </form>

    <p><a href="${pageContext.request.contextPath}/tickets">Volver al listado</a></p>
</body>
</html>
