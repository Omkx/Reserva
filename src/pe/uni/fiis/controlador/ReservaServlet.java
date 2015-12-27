package pe.uni.fiis.controlador;


import pe.uni.fiis.modelo.bean.*;
import pe.uni.fiis.modelo.factory.TransaccionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

@WebServlet(name = "ReservaServlet")
public class ReservaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idPel = request.getParameter("inPelicula");
        Integer idPelEnt = Integer.valueOf(idPel);
        Integer idHorario = Integer.valueOf(request.getParameter("inHorario"));
        Integer idUsuario = Integer.valueOf(request.getParameter("inUsu"));
        Double monto = Double.valueOf(request.getParameter("total"));

        Integer fkFuncion = TransaccionFactory.getInstance().ElegirFuncion(idPelEnt, idHorario);
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        String fechaActual = dia + "/" + (mes + 1) + "/" + año + " "+ hora + ":" + minuto;

        Reserva reserva = new Reserva();
        reserva.setFkFuncion(fkFuncion);
        reserva.setFkUsuario(idUsuario);
        reserva.setFechaReserva(fechaActual);
        reserva.setMonto(monto);
        TransaccionFactory.getInstance().agregarReserva(reserva);

        Usuario usuario;
        usuario = TransaccionFactory.getInstance().datoUsuario(idUsuario);
        Pelicula pelicula;
        pelicula = TransaccionFactory.getInstance().datosPelicula(idPelEnt);
        Horario horario;
        horario = TransaccionFactory.getInstance().datoHorario(idHorario);
        if(usuario != null && pelicula != null && horario != null) {
                request.setAttribute("usu", usuario);
                request.setAttribute("pelicula",pelicula);
                request.setAttribute("horario",horario);
                request.setAttribute("reserva", reserva);
                request.getRequestDispatcher("/reserva.jsp").forward(request, response);
        }


    }
}

