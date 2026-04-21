import java.util.ArrayList;
import java.util.List;

public class ServicioNotificaciones {
    private final List<Notificacion> historial = new ArrayList<>();

    public void enviarNotificacion(Notificacion notificacion) {
        notificacion.enviar();
        historial.add(notificacion);
    }

    public List<Notificacion> getHistorial() {
        return historial;
    }
}
