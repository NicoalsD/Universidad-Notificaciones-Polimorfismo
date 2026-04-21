public class NotificacionSMS extends Notificacion {
    private String numeroTelefono;
    private String operador;

    public NotificacionSMS(String codigo, String destinatario, String mensaje, String numeroTelefono, String operador) {
        super(codigo, destinatario, mensaje);
        this.numeroTelefono = numeroTelefono;
        this.operador = operador;
    }

    @Override
    public void enviar() {
        if (numeroTelefono == null || numeroTelefono.isBlank()) {
            marcarFallida();
            return;
        }
        marcarEnviada();
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getOperador() {
        return operador;
    }
}
