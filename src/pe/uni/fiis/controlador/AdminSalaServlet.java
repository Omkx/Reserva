package pe.uni.fiis.controlador;

import pe.uni.fiis.modelo.bean.Sala;
import pe.uni.fiis.modelo.factory.TransaccionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminSalaServlet")
public class AdminSalaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer nroSala = Integer.valueOf(request.getParameter("inSala"));
        Integer nroAsientos = Integer.valueOf(request.getParameter("inNroAsientos"));

        Sala sala = new Sala();
        sala.setNroSala(nroSala);
        sala.setNroAsientos(nroAsientos);

        TransaccionFactory.getInstance().agregarSala(sala);
        List<Sala> salas = TransaccionFactory.getInstance().listarSala();
        request.setAttribute("salas", salas);
        request.getRequestDispatcher("/AdminFuncion.jsp").forward(request,response);
    }
}
