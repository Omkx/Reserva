package pe.uni.fiis.modelo.dao;

import pe.uni.fiis.modelo.bean.*;

import java.util.List;


public interface TransaccionDAO {
    public Funcion agregarFuncion(Funcion funcion);
    public Pelicula agregarPelicula(Pelicula pelicula);
    public Reserva agregarReserva(Reserva reserva);
    public Usuario agregarUsuario(Usuario usuario);
    public Pelicula datosPelicula(Integer idPelicula);
    public Horario agregarHorario(Horario horario);
    public Horario modificarHorario(Horario horario);
    public void eliminarHorario(Horario horario);
    public Usuario obtenerUsuario(Usuario usuario);
    public List<Horario> listarHorario();
    public List<Pelicula> listarPelicula();
    public List<Cantidad> listarCantidad();
    public Pelicula mostrarInfo();
    public Funcion InfoFuncion(Integer idPelicula);
    public List<Horario> InfoHorarios(Integer idPelicula);
    public Integer ElegirFuncion(Integer idPelicula, Integer idHorario);
}

