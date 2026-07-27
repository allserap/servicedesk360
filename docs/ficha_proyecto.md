# Ficha Técnica Inicial del Proyecto

## 1. Datos Generales
* **Nombre del Proyecto:** ServiceDesk 360
* **Módulo:** Desarrollo de Aplicaciones Multiplataforma (COIDS3504)
* **Institución:** ITCA-FEPADE - Escuela de Ingeniería en Computación
* **Carrera:** Ingeniería de Desarrollo de Software
* **Ciclo:** VIII Ciclo 2026
* **Sector:** Servicios de Soporte Técnico y TI

---

## 2. Problema Empresarial
La empresa TecnoSoporte Centroamérica administra las solicitudes de soporte técnico de sus clientes mediante canales informales como mensajes de texto, llamadas telefónicas y hojas de cálculo dispersas. Esta falta de centralización provoca que la información se traspapele, los estados de atención no se mantengan actualizados y la gerencia no disponga de indicadores confiables sobre los tiempos de respuesta o la productividad del personal técnico.

Para resolver este problema, la organización requiere la implementación de una aplicación web centralizada denominada ServiceDesk 360, que permita estructurar el registro de clientes, equipos, solicitudes de soporte y asignación de técnicos, garantizando un seguimiento transparente y eficiente de cada ticket hasta su resolución.

---

## 3. Usuarios Beneficiados
* **Clientes:** Registran sus incidentes técnicos, consultan el estado de sus tickets y revisan el historial de atenciones.
* **Técnicos de Soporte:** Visualizan solicitudes asignadas, actualizan diagnósticos, cambian estados de avance y registran soluciones.
* **Administradores / Gerencia:** Gestionan usuarios, equipos, asignan prioridades y visualizan reportes de rendimiento del servicio.

---

## 4. Módulos Propuestos
1. **Módulo de Gestión de Clientes y Equipos:** Registro y control de inventario de equipos tecnológicos asociados a clientes.
2. **Módulo de Tickets de Soporte:** Creación, priorización y asignación de solicitudes de servicio técnico.
3. **Módulo de Control de Estados:** Trazabilidad del flujo de atención (Pendiente, En Proceso, Resuelto, Cerrado).
4. **Módulo de Reportes e Indicadores:** Generación de métricas de desempeño y tiempos de respuesta.

---

## 5. Alcance Inicial (Semana 1)
* Configuración del entorno Java Web con Apache Tomcat 9 y Maven.
* Creación de la estructura base del proyecto web (`/servicedesk360`).
* Página de bienvenida institucional (`index.jsp`) para la presentación del sistema.
* Implementación de `DiagnosticoServlet` para verificar la comunicación navegador-servidor y parámetros del entorno.
* Inicialización y organización del repositorio en Git con su respectivo README.md y documentación inicial.

---

## 6. Exclusiones del Alcance Inicial
* Conexión y operaciones CRUD sobre base de datos (se incorporará en guías posteriores con JDBC).
* Autenticación, inicio de sesión y gestión de roles de usuario.
* Notificaciones automáticas por correo electrónico.

---

## 7. Integrantes y Responsabilidades
* **Integrante 1 (Líder / Backend):** Configuración del proyecto Maven (`pom.xml`), control de versiones Git y Servlet de diagnóstico.
* **Integrante 2 (Frontend JSP):** Desarrollo de `index.jsp` y estructuración de la plantilla base.
* **Integrante 3 (Diseño CSS / UI):** Implementación de la hoja de estilos `estilos.css` e identidad visual.
* **Integrante 4 (Documentación y QA):** Redacción de la ficha del proyecto, README, matriz de entorno y bitácora técnica.