import java.time.format.DateTimeFormatter;

public class Main {
        public static void main(String[] args) {
        FabricaNotificaciones fabrica = new FabricaNotificaciones();
        ServicioNotificaciones servicio = new ServicioNotificaciones();

        Notificacion n1 = fabrica.crearNotificacion(
                CanalNotificacion.CORREO_ELECTRONICO,
                TipoSituacion.PUBLICACION_CALIFICACIONES,
                "N-001",
                "Ana Perez",
                "ana@universidad.edu");

        Notificacion n2 = fabrica.crearNotificacion(
                CanalNotificacion.MENSAJE_TEXTO,
                TipoSituacion.RECORDATORIO_PAGO_MATRICULA,
                "N-002",
                "Luis Gomez",
                "3001234567");

        Notificacion n3 = fabrica.crearNotificacion(
                CanalNotificacion.APP_MOVIL,
                TipoSituacion.CANCELACION_CLASE,
                "N-003",
                "Carla Ruiz",
                "device-7788");

        Notificacion n4 = fabrica.crearNotificacion(
                CanalNotificacion.CORREO_ELECTRONICO,
                TipoSituacion.CONFIRMACION_INSCRIPCION_EVENTO,
                "N-004",
                "Miguel Torres",
                "");

        servicio.enviarNotificacion(n1);
        servicio.enviarNotificacion(n2);
        servicio.enviarNotificacion(n3);
        servicio.enviarNotificacion(n4);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (Notificacion n : servicio.getHistorial()) {
                String fecha = n.getFechaEnvio().format(formato);
                System.out.println(n.getCodigo() + " | " + n.getDestinatario() + " | " + n.getEstado() + " | " + fecha);
        }
        }
}
