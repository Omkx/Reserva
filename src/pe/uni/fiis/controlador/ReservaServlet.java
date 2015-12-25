package pe.uni.fiis.controlador;


import pe.uni.fiis.modelo.bean.Reserva;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReservaServlet")
public class ReservaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idUsuario = (String)request.getParameter("inUsuario");
        Integer idPelicula = Integer.valueOf(request.getParameter("inPelicula"));
        Integer idHorario = Integer.valueOf(request.getParameter("inHorario"));
        Integer cantidad = Integer.valueOf(request.getParameter("inCantidad"));
        String calificacionPelicula = (String)request.getParameter("calificacionPelicula");
        String total = (String)request.getParameter("total");
/*
        Reserva reserva = new Reserva();
        reserva.setFkUsuario(idUsuario);
        reserva.setFechaReserva();
        reserva.setFkFuncion();
        reserva.setCantidad(cantidad);
        reserva.setMonto(Double.valueOf(total));
*/
    }
}
