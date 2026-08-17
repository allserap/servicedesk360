/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sv.edu.itca.servicedesk360.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sv.edu.itca.servicedesk360.service.ServicioRegistro;

/**
 *
 * @author serva
 */
@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {

    private static final Pattern CORREO_VALIDO = Pattern.compile(
            "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");

    @Override
    public void init() throws ServletException {
        obtenerUsuarios();
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/registro.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String rol = request.getParameter("rol");
        String clave = request.getParameter("clave");
        String confirmar = request.getParameter("confirmarClave");
        List<String> errores = obtenerServicioRegistro().registrar(
                nombre, correo, rol, clave, confirmar);
        if (!errores.isEmpty()) {
            request.setAttribute("errores", errores);
            request.setAttribute("nombreAnterior", nombre);
            request.setAttribute("correoAnterior", correo);
            request.setAttribute("rolAnterior", rol);
            request.getRequestDispatcher("/registro.jsp")
                    .forward(request, response);
            return;
        }
        HttpSession sesion = request.getSession();
        sesion.setAttribute("mensajeFlash",
                "Cuenta registrada correctamente. Inicie acceso.");
        response.sendRedirect(request.getContextPath() + "/acceso");
    }
    
    private ServicioRegistro obtenerServicioRegistro() {
        return (ServicioRegistro) getServletContext()
                .getAttribute("servicioRegistro");
    }

    private String normalizar(String valor) {
        return valor == null ? "" : valor.trim();
    }

    private String valorSeguro(String valor) {
        return valor == null ? "" : valor;
    }

    private boolean contieneNumero(String clave) {
        for (int i = 0; i < clave.length(); i++) {
            if (Character.isDigit(clave.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private String generarHash(String valor) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(
                    valor.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(bytes);
        } catch (NoSuchAlgorithmException ex) {
            throw new IllegalStateException(
                    "No fue posible procesar la contraseña.", ex);
        }
    }

    @SuppressWarnings("unchecked")
    private Map<String, Map<String, String>> obtenerUsuarios() {
        Object existente = getServletContext().getAttribute("usuarios");

        if (existente == null) {
            synchronized (getServletContext()) {
                existente = getServletContext().getAttribute("usuarios");
                if (existente == null) {
                    existente = new ConcurrentHashMap<String, Map<String, String>>();
                    getServletContext().setAttribute("usuarios", existente);
                }
            }
        }

        return (Map<String, Map<String, String>>) existente;
    }
}
