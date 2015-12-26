package pe.uni.fiis.modelo.bean;



public class Reserva {
    private Integer idReserva;
    private Integer fkFuncion;
    private Integer fkUsuario;
    private String fechaReserva;
    private Double monto;

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Integer getFkFuncion() {
        return fkFuncion;
    }

    public void setFkFuncion(Integer fkFuncion) {
        this.fkFuncion = fkFuncion;
    }

    public Integer getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
    }
}
