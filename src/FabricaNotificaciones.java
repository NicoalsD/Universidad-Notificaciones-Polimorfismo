public class FabricaNotificaciones {

    public Notificacion crearNotificacion(
            CanalNotificacion canal,
            TipoSituacion situacion,
            String codigo,
            String destinatario,
            String datoCanal) {

        String mensaje = construirMensaje(situacion, destinatario);

        switch (canal) {
            case CORREO_ELECTRONICO:
                return new NotificacionCorreo(codigo, destinatario, mensaje, datoCanal, "Notificacion Universidad");
            case MENSAJE_TEXTO:
                return new NotificacionSMS(codigo, destinatario, mensaje, datoCanal, "Operador-Default");
            case APP_MOVIL:
                return new NotificacionAppMovil(codigo, destinatario, mensaje, datoCanal, "Android");
            default:
                throw new IllegalArgumentException("Canal no soportado");
        }
    }

    private String construirMensaje(TipoSituacion situacion, String destinatario) {
        switch (situacion) {
            case PUBLICACION_CALIFICACIONES:
                return "Estimado " + destinatario + ", sus calificaciones han sido publicadas.";
            case RECORDATORIO_PAGO_MATRICULA:
                return "Estimado " + destinatario + ", recuerde realizar el pago de su matricula.";
            case CANCELACION_CLASE:
                return "Estimado " + destinatario + ", se informa la cancelacion de su clase programada.";
            case CONFIRMACION_INSCRIPCION_EVENTO:
                return "Estimado " + destinatario + ", su inscripcion al evento academico fue confirmada.";
            default:
                return "Situacion no soportada";
        }
    }
}
