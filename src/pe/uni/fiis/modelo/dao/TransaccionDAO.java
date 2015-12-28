package pe.uni.fiis.modelo.dao;

import pe.uni.fiis.modelo.bean.*;

import java.util.List;


public interface TransaccionDAO {
    Funcion agregarFuncion(Funcion funcion);
    Pelicula agregarPelicula(Pelicula pelicula);
    Reserva agregarReserva(Reserva reserva);
    Usuario agregarUsuario(Usuario usuario);
    Pelicula datosPelicula(Integer idPelicula);
    Horario agregarHorario(String hora);
    Horario modificarHorario(Horario horario);
    void eliminarHorario(Horario horario);
    Usuario obtenerUsuario(Usuario usuario);
    List<Pelicula> listarPelicula();
    List<Pelicula> listarFuncionesDePelicula();
    Funcion InfoFuncion(Integer idPelicula);
    List<Horario> InfoHorarios(Integer idPelicula);
    Integer ElegirFuncion(Integer idPelicula, Integer idHorario);
    Usuario datoUsuario(Integer idUsuario);
    Horario datoHorario(Integer idHorario);
    Sala datoSala(Integer idSala);
    List<Sala> listarSala();
    Sala agregarSala(Sala sala);
}

