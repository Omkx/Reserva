package pe.uni.fiis.controlador;

import pe.uni.fiis.modelo.bean.Funcion;
import pe.uni.fiis.modelo.bean.Horario;
import pe.uni.fiis.modelo.bean.Pelicula;
import pe.uni.fiis.modelo.bean.Sala;
import pe.uni.fiis.modelo.factory.TransaccionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "CrearPeliculaServlet")
public class CrearPeliculaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombrePelicula = request.getParameter("inPelicula");
        String calificacion = request.getParameter("inCalificacion");
        String duracion = request.getParameter("inDuracion");
        String sypnosis = request.getParameter("inSynopsis");

        byte[] ptext = sypnosis.getBytes("ISO_8859_1");
        String value = new String(ptext, "UTF-8");

        String url = request.getParameter("inUrl");
        String genero = request.getParameter("inGenero");

       // Sala sala = new Sala();
        //sala = TransaccionFactory.getInstance().datoSala(idSala);


        Pelicula pelicula = new Pelicula();
        pelicula.setNombre(nombrePelicula);
        pelicula.setCalificacion(calificacion);
        pelicula.setDuracion(duracion);
        pelicula.setSynopsis(value);
        pelicula.setUrl(url);
        pelicula.setGenero(genero);

        pelicula = TransaccionFactory.getInstance().agregarPelicula(pelicula);
        //Integer idPelicula = pelicula.getIdPelicula();


        List<Pelicula> peliculas = TransaccionFactory.getInstance().listarPelicula();
        request.setAttribute("peliculas", peliculas);
        request.getRequestDispatcher("/AdminFuncion.jsp").forward(request,response);
        //request.getRequestDispatcher("/login.jsp").forward(request,response);

    }
}
