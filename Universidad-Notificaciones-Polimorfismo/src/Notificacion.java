import java.time.LocalDateTime;

public abstract class Notificacion {
    private String codigo;
    private String destinatario;
    private String mensaje;
    private LocalDateTime fechaEnvio;
    private EstadoNotificacion estado;

    public Notificacion(String codigo, String destinatario, String mensaje) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        this.estado = EstadoNotificacion.PENDIENTE;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public EstadoNotificacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoNotificacion estado) {
        this.estado = estado;
    }

    protected void marcarEnviada() {
        this.fechaEnvio = LocalDateTime.now();
        this.estado = EstadoNotificacion.ENVIADA;
    }

    protected void marcarFallida() {
        this.fechaEnvio = LocalDateTime.now();
        this.estado = EstadoNotificacion.FALLIDA;
    }

    public abstract void enviar();
}
