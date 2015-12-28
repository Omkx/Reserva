package pe.uni.fiis.controlador;

import pe.uni.fiis.modelo.bean.Funcion;
import pe.uni.fiis.modelo.bean.Horario;
import pe.uni.fiis.modelo.factory.TransaccionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CrearFuncionServlet")
public class CrearFuncionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer idPelicula = Integer.valueOf(request.getParameter("inPelicula"));
        String hora = (String)request.getParameter("inHorario");
        Integer idSala = Integer.valueOf(request.getParameter("inSala"));

        Horario horario = new Horario();
        horario = TransaccionFactory.getInstance().agregarHorario(hora);

        Integer idHorario = horario.getIdHorario();

        Funcion funcion = new Funcion();
        funcion.setFkHorario(idHorario);
        funcion.setFkSala(idSala);
        funcion.setFkPelicula(idPelicula);
        TransaccionFactory.getInstance().agregarFuncion(funcion);
        request.getRequestDispatcher("/Administrador.jsp").forward(request,response);

    }
}
