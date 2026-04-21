public class NotificacionCorreo extends Notificacion {
    private String correoDestino;
    private String asunto;

    public NotificacionCorreo(String codigo, String destinatario, String mensaje, String correoDestino, String asunto) {
        super(codigo, destinatario, mensaje);
        this.correoDestino = correoDestino;
        this.asunto = asunto;
    }

    @Override
    public void enviar() {
        if (correoDestino == null || correoDestino.isBlank()) {
            marcarFallida();
            return;
        }
        marcarEnviada();
    }

    public String getCorreoDestino() {
        return correoDestino;
    }

    public String getAsunto() {
        return asunto;
    }
}
