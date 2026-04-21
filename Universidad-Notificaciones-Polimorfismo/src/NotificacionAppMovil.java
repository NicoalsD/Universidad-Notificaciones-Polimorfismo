public class NotificacionAppMovil extends Notificacion {
    private String idDispositivo;
    private String plataforma;

    public NotificacionAppMovil(String codigo, String destinatario, String mensaje, String idDispositivo, String plataforma) {
        super(codigo, destinatario, mensaje);
        this.idDispositivo = idDispositivo;
        this.plataforma = plataforma;
    }

    @Override
    public void enviar() {
        if (idDispositivo == null || idDispositivo.isBlank()) {
            marcarFallida();
            return;
        }
        marcarEnviada();
    }

    public String getIdDispositivo() {
        return idDispositivo;
    }

    public String getPlataforma() {
        return plataforma;
    }
}
