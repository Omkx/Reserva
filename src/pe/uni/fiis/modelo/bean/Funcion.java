package pe.uni.fiis.modelo.bean;



public class Funcion {
    private Integer idFuncion;
    private String sala;
    private Integer fkHorario;
    private String fecha;
    private Integer nroAsientos;
    private Integer fkPelicula;

    public Integer getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(Integer idFuncion) {
        this.idFuncion = idFuncion;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getNroAsientos() {
        return nroAsientos;
    }

    public void setNroAsientos(Integer nroAsientos) {
        this.nroAsientos = nroAsientos;
    }

    public Integer getFkHorario() {
        return fkHorario;
    }

    public void setFkHorario(Integer fkHorario) {
        this.fkHorario = fkHorario;
    }

    public Integer getFkPelicula() {
        return fkPelicula;
    }

    public void setFkPelicula(Integer fkPelicula) {
        this.fkPelicula = fkPelicula;
    }
}
