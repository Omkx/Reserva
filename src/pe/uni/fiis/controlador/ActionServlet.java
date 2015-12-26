package pe.uni.fiis.controlador;

import pe.uni.fiis.modelo.bean.Funcion;
import pe.uni.fiis.modelo.bean.Horario;
import pe.uni.fiis.modelo.bean.Pelicula;
import pe.uni.fiis.modelo.factory.TransaccionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ActionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public ActionServlet() {
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Integer buscaPelicula = Integer.valueOf(request.getParameter("pelicula"));
       if(buscaPelicula != 0) {

           Funcion funcion = new Funcion();

           funcion = TransaccionFactory.getInstance().InfoFuncion(buscaPelicula);
           Integer idPelicula = funcion.getFkPelicula();

           Pelicula pelicula = new Pelicula();
           pelicula = TransaccionFactory.getInstance().datosPelicula(idPelicula);

           List<Horario> horarios = TransaccionFactory.getInstance().InfoHorarios(idPelicula);

           String[] array = new String[horarios.size()];
           for (int i = 0; i < horarios.size(); i++) {
               array[i] = horarios.get(i).getHora();
           }
           response.getWriter().write(pelicula.getSynopsis() + "|" + pelicula.getDuracion() + "|" + pelicula.getUrl() + "|" + pelicula.getCalificacion() + "|"+Arrays.toString(array));
           response.setContentType("text/html");
           response.setCharacterEncoding("UTF-8");
       }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

}