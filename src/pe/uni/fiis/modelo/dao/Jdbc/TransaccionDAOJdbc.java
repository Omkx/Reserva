package pe.uni.fiis.modelo.dao.Jdbc;

import pe.uni.fiis.modelo.bean.*;
import pe.uni.fiis.modelo.dao.TransaccionDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TransaccionDAOJdbc implements TransaccionDAO {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/cine";
    private static final String USUARIO = "root";
    private static final String CLAVE = "";
    private Connection conexion;
    private Statement consulta;
    private ResultSet resultado;

    private void abrirConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(DB_URL, USUARIO, CLAVE);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void cerrarConexion() {
        try {
            if(conexion != null) {
                conexion.close();
                conexion = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pelicula> listarPelicula(){
        List<Pelicula> peliculas = null;
        abrirConexion();
        try {
            consulta = conexion.createStatement();
            String sql="select pkPelicula,nombre,duracion,calificacion from Pelicula ";
            resultado = consulta.executeQuery(sql);
            if(resultado!=null){
                peliculas = new ArrayList<Pelicula>();
                while(resultado.next()){
                    Pelicula pelicula= new Pelicula();
                    pelicula.setIdPelicula(resultado.getInt("pkPelicula"));
                    pelicula.setNombre(resultado.getString("nombre"));
                    pelicula.setDuracion(resultado.getString("duracion"));
                    pelicula.setCalificacion(resultado.getString("calificacion"));
                    peliculas.add(pelicula);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
            try {
                resultado.close();
                consulta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return peliculas;
    }

    public List<Pelicula> listarFuncionesDePelicula(){
        List<Pelicula> peliculas = null;
        abrirConexion();
        try {
            consulta = conexion.createStatement();
            String sql="select b.pkPelicula , b.nombre ,b.calificacion" +
                    "  from Funcion a , Pelicula b where a.fkPelicula = b.pkPelicula;";

            resultado = consulta.executeQuery(sql);
            if(resultado!=null){
                peliculas = new ArrayList<Pelicula>();
                while(resultado.next()){
                    Pelicula pelicula= new Pelicula();
                    pelicula.setIdPelicula(resultado.getInt("pkPelicula"));
                    pelicula.setNombre(resultado.getString("nombre"));
                    pelicula.setDuracion(resultado.getString("duracion"));
                    pelicula.setCalificacion(resultado.getString("calificacion"));
                    peliculas.add(pelicula);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
            try {
                resultado.close();
                consulta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return peliculas;
    }


    public List<Sala> listarSala(){
        List<Sala> salas = null;
        abrirConexion();
        try {
            consulta = conexion.createStatement();
            String sql="select * from Sala ";
            resultado = consulta.executeQuery(sql);
            if(resultado!=null){
                salas = new ArrayList<Sala>();
                while(resultado.next()){
                    Sala sala = new Sala();
                    sala.setIdSala(resultado.getInt("pkSala"));
                    sala.setNroSala(resultado.getInt("nroSala"));
                    sala.setNroAsientos(resultado.getInt("nroAsientos"));
                    salas.add(sala);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
            try {
                resultado.close();
                consulta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return salas;
    }


    public Pelicula datosPelicula(Integer idPelicula){
        Pelicula pelicula = new Pelicula();
        abrirConexion();
        try {
            consulta = conexion.createStatement();
            String sql="select * from Pelicula where pkPelicula = "+idPelicula;
            resultado = consulta.executeQuery(sql);
            if(resultado!=null){
                while(resultado.next()) {
                    pelicula.setIdPelicula(resultado.getInt("pkPelicula"));
                    pelicula.setNombre(resultado.getString("nombre"));
                    pelicula.setDuracion(resultado.getString("duracion"));
                    pelicula.setCalificacion(resultado.getString("calificacion"));
                    pelicula.setSynopsis(resultado.getString("synopsis"));
                    pelicula.setUrl(resultado.getString("url"));
                    pelicula.setGenero(resultado.getString("genero"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
            try {
                resultado.close();
                consulta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return pelicula;
    }


    public Usuario agregarUsuario(Usuario usuario) {
        Statement sentencia = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" insert into Usuario values (null,")
                .append(" '" + usuario.getClave() + "',")
                .append(" '" + usuario.getCuenta() + "',")
                .append(" '" + usuario.getNombre() + "',")
                .append(" '" + usuario.getApPaterno() + "',")
                .append(" '" + usuario.getApMaterno() + "',")
                .append(" '" + usuario.getDni() + "',")
                .append(" '" + usuario.getCorreo() + "');");
        try{
            abrirConexion();
            sentencia = conexion.createStatement();
            sentencia.execute(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ResultSet autogenerados = sentencia.getGeneratedKeys();
            if (autogenerados.next()) {
                usuario.setIdUsuario(autogenerados.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                sentencia.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sentencia = null;
            cerrarConexion();
        }

        return usuario;
    }

    public boolean validarCuenta(String cuenta, String clave){
        boolean valor=false;
        abrirConexion();
        try {
            consulta = conexion.createStatement();
            String sql="select * from Usuario where cuenta = '"+cuenta+"' and clave ='"+clave+"'";
            resultado = consulta.executeQuery(sql);
            if(resultado!=null){
                while(resultado.next()){
                    valor = true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
            try {
                resultado.close();
                consulta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return valor;
    }

    public Reserva agregarReserva(Reserva reserva) {
        Statement sentencia = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" insert into Reserva values ( null,")
                .append(" '" + reserva.getFkUsuario() + "',")
                .append(" '" + reserva.getFkFuncion() + "',")
                .append(" '" + reserva.getFechaReserva() + "',")
                .append(" '" + reserva.getMonto() + "');");
        try{
            abrirConexion();
            sentencia = conexion.createStatement();
            sentencia.execute(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ResultSet autogenerados = sentencia.getGeneratedKeys();
            if (autogenerados.next()) {
                reserva.setIdReserva(autogenerados.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                sentencia.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sentencia = null;
            cerrarConexion();
        }
        return reserva;
    }

    public Pelicula agregarPelicula(Pelicula pelicula) {
        Statement sentencia = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" insert into Pelicula values (null,")
                .append(" '" + pelicula.getNombre() + "',")
                .append(" '" + pelicula.getCalificacion() + "',")
                .append(" '" + pelicula.getDuracion() + "',")
                .append(" '" + pelicula.getSynopsis() + "',")
                .append(" '" + pelicula.getUrl() + "',")
                .append(" '" + pelicula.getGenero() + "');");

        try{
            abrirConexion();
            sentencia = conexion.createStatement();
            sentencia.execute(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ResultSet autogenerados = sentencia.getGeneratedKeys();
            if (autogenerados.next()) {
                pelicula.setIdPelicula(autogenerados.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                sentencia.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sentencia = null;
            cerrarConexion();
        }
        return pelicula;
    }

    public void eliminarPelicula(Pelicula pelicula) {
        Statement sentencia = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" delete from pelicula ")
                .append(" where id_pelicula = " + pelicula.getIdPelicula());
        try{
            abrirConexion();
            sentencia = conexion.createStatement();
            sentencia.execute(sql.toString());
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                sentencia.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sentencia = null;
            cerrarConexion();
        }
    }

    public Funcion agregarFuncion(Funcion funcion) {
        Statement sentencia = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" insert into Funcion values (null,")
                .append(" '" + funcion.getFkPelicula() + "',")
                .append(" '" + funcion.getFkSala() + "',")
                .append(" '" + funcion.getFkHorario() + "');");
        try{
            abrirConexion();
            sentencia = conexion.createStatement();
            sentencia.execute(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ResultSet autogenerados = sentencia.getGeneratedKeys();
            if (autogenerados.next()) {
                funcion.setIdFuncion(autogenerados.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                sentencia.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sentencia = null;
            cerrarConexion();
        }
        return funcion;
    }

    public Horario agregarHorario(String hora) {
        Horario horario = new Horario();
        Statement sentencia = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" insert into Horario values (null,")
                .append(" '" + hora + "')");

        try{
            abrirConexion();
            sentencia = conexion.createStatement();
            sentencia.execute(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ResultSet autogenerados = sentencia.getGeneratedKeys();
            if (autogenerados.next()) {
                horario.setIdHorario(autogenerados.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                sentencia.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sentencia = null;
            cerrarConexion();
        }
        return horario;
    }

    public Sala agregarSala(Sala sala) {
        Statement sentencia = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" insert into Sala values (null,")
                .append(" '" + sala.getNroSala() + "',")
                .append(" '" + sala.getNroAsientos()+ "');");

        try{
            abrirConexion();
            sentencia = conexion.createStatement();
            sentencia.execute(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ResultSet autogenerados = sentencia.getGeneratedKeys();
            if (autogenerados.next()) {
                sala.setIdSala(autogenerados.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                sentencia.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sentencia = null;
            cerrarConexion();
        }
        return sala;
    }

    public Horario modificarHorario(Horario horario) {
        Statement sentencia = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" update horario set ")

                .append(" Hora ='" + horario.getHora() + "'");

        try{
            abrirConexion();
            sentencia = conexion.createStatement();
            sentencia.execute(sql.toString());
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                sentencia.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sentencia = null;
            cerrarConexion();
        }
        return horario;
    }

    public void eliminarHorario(Horario horario) {
        Statement sentencia = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" delete from horario ")
                .append(" where id_horario = " + horario.getIdHorario());
        try{
            abrirConexion();
            sentencia = conexion.createStatement();
            sentencia.execute(sql.toString());
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                sentencia.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sentencia = null;
            cerrarConexion();
        }
    }
    public Usuario obtenerUsuario(Usuario usuario){
        Usuario retorno = null;
        Statement sentencia = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" select * from Usuario ")
                .append(" where clave = '" + usuario.getClave()+"' ")
                .append(" and cuenta = '"+ usuario.getCuenta() +"'");
        try{
            abrirConexion();
            sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql.toString());
            while(resultado.next()){
                retorno = new Usuario();
                retorno.setIdUsuario(resultado.getInt("pkUsuario"));
                retorno.setClave(resultado.getString("clave"));
                retorno.setCuenta(resultado.getString("cuenta"));
            }
            cerrarConexion();
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                sentencia.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sentencia = null;
        }

        return retorno;
    }

    public Funcion InfoFuncion(Integer idPelicula){
        Funcion funcion = new Funcion();
        abrirConexion();
        try {
            consulta = conexion.createStatement();
            String sql="select * from Funcion where fkPelicula = "+idPelicula;
            resultado = consulta.executeQuery(sql);
            if(resultado!=null){
                while(resultado.next()) {
                    funcion.setIdFuncion(resultado.getInt("pkFuncion"));
                    funcion.setFkPelicula(resultado.getInt("fkPelicula"));
                    funcion.setFkSala(resultado.getInt("fkSala"));
                    funcion.setFkHorario(resultado.getInt("fkHorario"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
            try {
                resultado.close();
                consulta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return funcion;
    }

    public Integer ElegirFuncion(Integer idPelicula, Integer idHorario){
        Integer fkFuncion = null;
        abrirConexion();
        try {
            consulta = conexion.createStatement();
            String sql="select * from Funcion where fkPelicula = "+idPelicula+ " and " +idHorario;
            resultado = consulta.executeQuery(sql);
            if(resultado!=null){
                while(resultado.next()) {
                    fkFuncion = resultado.getInt("pkFuncion");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
            try {
                resultado.close();
                consulta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return fkFuncion;
    }

    public List<Horario> InfoHorarios(Integer idPelicula){
        List<Horario> horarios = null;
        abrirConexion();
        try {
            consulta = conexion.createStatement();
            String sql="select b.pkHorario , b.hora  from Funcion a , Horario b " +
                    "where a.fkHorario = b.pkHorario " +
                    "and a.fkPelicula = " + idPelicula;
            resultado = consulta.executeQuery(sql);
            if(resultado!=null){
                horarios = new ArrayList<Horario>();
                while(resultado.next()) {
                    Horario horario = new Horario();
                    horario.setIdHorario(resultado.getInt("pkHorario"));
                    horario.setHora(resultado.getString("Hora"));
                    horarios.add(horario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
            try {
                resultado.close();
                consulta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return horarios;
    }

    public Usuario datoUsuario(Integer idUsuario){
        Usuario retorno = null;
        Statement sentencia = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" select * from Usuario ")
                .append(" where pkUsuario = '" + idUsuario +"';");
        try{
            abrirConexion();
            sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql.toString());
            while(resultado.next()){
                retorno = new Usuario();
                retorno.setIdUsuario(resultado.getInt("pkUsuario"));
                retorno.setNombre(resultado.getString("nombre"));
                retorno.setApPaterno(resultado.getString("apPaterno"));
                retorno.setApMaterno(resultado.getString("apMaterno"));
                retorno.setDni(resultado.getString("dni"));
                retorno.setCorreo(resultado.getString("correo"));
            }
            cerrarConexion();
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                sentencia.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sentencia = null;
        }

        return retorno;
    }

    public Horario datoHorario(Integer idHorario){
        Horario horario = new Horario();
        abrirConexion();
        try {
            consulta = conexion.createStatement();
            String sql="select * from Horario where pkHorario = "+idHorario;
            resultado = consulta.executeQuery(sql);
            if(resultado!=null){
                while(resultado.next()) {
                    horario.setIdHorario(resultado.getInt("pkHorario"));
                    horario.setHora(resultado.getString("hora"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
            try {
                resultado.close();
                consulta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return horario;
    }

    public Sala datoSala (Integer idSala){
        Sala sala = new Sala();
        abrirConexion();
        try {
            consulta = conexion.createStatement();
            String sql="select * from Sala where pkSala = "+idSala;
            resultado = consulta.executeQuery(sql);
            if(resultado!=null){
                while(resultado.next()) {
                    sala.setIdSala(resultado.getInt("pkSala"));
                    sala.setNroSala(resultado.getInt("nroSala"));
                    sala.setNroAsientos(resultado.getInt("nroAsientos"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
            try {
                resultado.close();
                consulta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sala;
    }
}
