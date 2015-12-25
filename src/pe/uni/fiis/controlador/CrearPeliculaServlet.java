package pe.uni.fiis.controlador;

import pe.uni.fiis.modelo.bean.Pelicula;
import pe.uni.fiis.modelo.factory.TransaccionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "CrearPeliculaServlet")
public class CrearPeliculaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombrePelicula = (String)request.getParameter("inPelicula");
        String calificacion = (String)request.getParameter("inCalificacion");
        String duracion = (String)request.getParameter("inDuracion");
        String sypnosis = (String)request.getParameter("inSynopsis");

        byte[] ptext = sypnosis.getBytes("ISO_8859_1");
        String value = new String(ptext, "UTF-8");

        String url = (String)request.getParameter("inUrl");
        String precio = (String)request.getParameter("inPrecio");
        String genero = (String)request.getParameter("inGenero");

        Pelicula pelicula = new Pelicula();
        pelicula.setNombre(nombrePelicula);
        pelicula.setCalificacion(calificacion);
        pelicula.setDuracion(duracion);
        pelicula.setSynopsis(value);
        pelicula.setUrl(url);
        pelicula.setGenero(genero);

        TransaccionFactory.getInstance().agregarPelicula(pelicula);
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
}
