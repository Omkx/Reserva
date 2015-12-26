package pe.uni.fiis.controlador;


import pe.uni.fiis.modelo.bean.Funcion;
import pe.uni.fiis.modelo.bean.Reserva;
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
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print(request.getParameter("inUsu"));
        Integer idUsuario = Integer.valueOf(request.getParameter("inUsuario"));
        Integer idPelicula = Integer.valueOf(request.getParameter("inPelicula"));
        Integer idHorario = Integer.valueOf(request.getParameter("inHorario"));
        Double monto = Double.valueOf(request.getParameter("total"));

        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        String fechaActual = "Fecha Actual: "+ dia + "/" + (mes+1) + "/" + año;

        Funcion funcion = new Funcion();
        funcion.setFkPelicula(idPelicula);
        funcion.setFkHorario(idHorario);
        Integer fkFuncion = TransaccionFactory.getInstance().ElegirFuncion(idPelicula,idHorario);

        Reserva reserva = new Reserva();
        reserva.setFkFuncion(fkFuncion);
        reserva.setFkUsuario(idUsuario);
        reserva.setFechaReserva(fechaActual);
        reserva.setMonto(monto);
        TransaccionFactory.getInstance().agregarReserva(reserva);
        System.out.print("Hecha la reserva");

    }
}
