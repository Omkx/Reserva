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
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idPel = request.getParameter("inPelicula");
        Integer idPelEnt = Integer.valueOf(idPel);
        Integer idHorario = Integer.valueOf(request.getParameter("inHorario"));
        Integer idUsuario = Integer.valueOf(request.getParameter("inUsu"));
        Double monto = Double.valueOf(request.getParameter("total"));

        Integer fkFuncion = TransaccionFactory.getInstance().ElegirFuncion(idPelEnt, idHorario);
        //String idUsu = request.getParameter("inUsu");
        //Integer idUsuEnt = Integer.valueOf(idUsu);
        //System.out.print(idUsuEnt);

        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        String fechaActual = "Fecha Actual: " + dia + "/" + (mes + 1) + "/" + año;
        //System.out.printf("Hora Actual: %02d:%02d:%02d %n",hora, minuto, segundo);

        //Funcion funcion = new Funcion();
        //funcion.setFkPelicula(idPelEnt);
        //funcion.setFkHorario(idHorario);

        Reserva reserva = new Reserva();
        reserva.setFkFuncion(fkFuncion);
        reserva.setFkUsuario(idUsuario);
        reserva.setFechaReserva(fechaActual);
        reserva.setMonto(monto);
        TransaccionFactory.getInstance().agregarReserva(reserva);
        request.getRequestDispatcher("/reserva.jsp").forward(request, response);

    }
}

