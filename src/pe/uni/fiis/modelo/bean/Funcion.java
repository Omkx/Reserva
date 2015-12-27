package pe.uni.fiis.modelo.bean;



public class Funcion {
    private Integer idFuncion;
    private Integer fkSala;
    private Integer fkHorario;
    private Integer fkPelicula;

    public Integer getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(Integer idFuncion) {
        this.idFuncion = idFuncion;
    }

    public Integer getFkSala() {
        return fkSala;
    }

    public void setFkSala(Integer fkSala) {
        this.fkSala = fkSala;
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
