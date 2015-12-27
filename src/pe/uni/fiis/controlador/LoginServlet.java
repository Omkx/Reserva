package pe.uni.fiis.controlador;

import pe.uni.fiis.modelo.bean.*;
import pe.uni.fiis.modelo.factory.TransaccionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cuenta = request.getParameter("inUsuario");
        String clave = request.getParameter("inClave");
        Usuario usuario = new Usuario();
        usuario.setClave(clave);
        usuario.setCuenta(cuenta);
        usuario = TransaccionFactory.getInstance().obtenerUsuario(usuario);

        if(usuario != null){
            if (usuario.getCuenta().equals("admin")){
                request.setAttribute("usu", usuario);
                request.getRequestDispatcher("/Administrador.jsp").forward(request,response);
            }else {
                request.setAttribute("usu", usuario);
                List<Pelicula> peliculas = TransaccionFactory.getInstance().listarPelicula();
                request.setAttribute("peliculas", peliculas);
                request.getRequestDispatcher("/LaUltima.jsp").forward(request, response);
            }
        }
        else{
            //String mensaje = "Usuario no existe";
            //request.setAttribute("men",mensaje);
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }
    }
}
