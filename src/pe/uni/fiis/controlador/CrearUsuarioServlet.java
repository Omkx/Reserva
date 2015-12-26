package pe.uni.fiis.controlador;

import pe.uni.fiis.modelo.bean.Usuario;
import pe.uni.fiis.modelo.factory.TransaccionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CrearUsuarioServlet")
public class CrearUsuarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cuentaUsuario = (String)request.getParameter("inUsuario");
        String passUsuario = (String)request.getParameter("inPass");
        String nombreUsuario = (String)request.getParameter("inNom");
        String apPaterno = (String)request.getParameter("inApPa");
        String apMaterno = (String)request.getParameter("inApMa");
        String emailUsuario = (String)request.getParameter("inEmail");
        String dniUsuario = (String)request.getParameter("inDni");

        Usuario usuario = new Usuario();
        usuario.setCuenta(cuentaUsuario);
        usuario.setNombre(nombreUsuario);
        usuario.setApPaterno(apPaterno);
        usuario.setApMaterno(apMaterno);
        usuario.setClave(passUsuario);
        usuario.setCorreo(emailUsuario);
        usuario.setDni(dniUsuario);

        TransaccionFactory.getInstance().agregarUsuario(usuario);
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
}
