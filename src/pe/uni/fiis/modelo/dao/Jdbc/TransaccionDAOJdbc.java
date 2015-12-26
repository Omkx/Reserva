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

    public List<Horario> listarHorario(){
        List<Horario> horarios = null;
        abrirConexion();
        try {
            consulta = conexion.createStatement();
            String sql="select * from Horario ";
            resultado = consulta.executeQuery(sql);
            if(resultado!=null){
                horarios = new ArrayList<Horario>();
                while(resultado.next()){
                    Horario horario= new Horario();
                    horario.setIdHorario(resultado.getInt("pkHorario"));
                    horario.setHora(resultado.getString("hora"));
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

    public List<Cantidad> listarCantidad(){
        List<Cantidad> cantidades = null;
        abrirConexion();
        try {
            consulta = conexion.createStatement();
            String sql="select * from Cantidad ";
            resultado = consulta.executeQuery(sql);
            if(resultado!=null){
                cantidades = new ArrayList<Cantidad>();
                while(resultado.next()){
                    Cantidad cantidad = new Cantidad();
                    cantidad.setIdCantidad(resultado.getInt("pkCantidad"));
                    cantidad.setCantidad(resultado.getString("cantidad"));
                    cantidades.add(cantidad);
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
        return cantidades;
    }


    public void insertarPelicula(Pelicula pelicula, Usuario administrador){
        boolean v = validarCuenta(administrador.getCuenta(),administrador.getClave());
        Statement sentencia = null;
        StringBuilder sql = new StringBuilder();
        if(v&&(administrador.getIdUsuario()==1)){
            sql.append(" insert into pelicula values (null,")
                    .append(pelicula.getIdPelicula()+ ",'")
                    .append(pelicula.getNombre()+ "','")
                    .append(pelicula.getCalificacion() + "','")
                    .append(pelicula.getDuracion()+  "','")
                    .append(pelicula.getSynopsis()+  "','")
                    .append(pelicula.getUrl()+  "',")
                    .append(pelicula.getGenero()+"')");
        }

        try{
            abrirConexion();
            sentencia = conexion.createStatement();
            sentencia.execute(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ResultSet resultado = sentencia.getGeneratedKeys();

            pelicula.setIdPelicula(resultado.getInt("1"));

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



    public Pelicula mostrarInfo(){

        Pelicula pelicula = null;

        abrirConexion();
        try {
            consulta = conexion.createStatement();
            String sql="select * from Pelicula";
            resultado = consulta.executeQuery(sql);
            if(resultado!=null){
                pelicula = new Pelicula();

                while(resultado.next()){

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
        sql.append(" insert into full values (null,")
                .append(" '" + funcion.getSala() + "')")
                .append(" '" + funcion.getFkHorario() + "')")
                .append(" '" + funcion.getFecha() + "')")
                .append(" '" + funcion.getNroAsientos() + "')");

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

    public Horario agregarHorario(Horario horario) {
        Statement sentencia = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" insert into full values (null,")
                .append(" '" + horario.getHora() + "')");

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
                    funcion.setSala(resultado.getString("sala"));
                    funcion.setFecha(resultado.getString("fecha"));
                    funcion.setNroAsientos(resultado.getInt("nroAsientos"));
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
}
