import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Reserva {
    private LocalTime hora;
    private int numPer;
    private int idReserva;
    private LocalDate fecha;

    // Constructor
    public Reserva(LocalTime hora, int numPer, int idReserva, LocalDate fecha) {
        setHora(hora);
        setNumPer(numPer);
        setIdReserva(idReserva);
        setFecha(fecha);
    }

    // Getters y Setters con validaciones
    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        if (hora == null) {
            throw new IllegalArgumentException("La hora no puede ser nula.");
        }
        this.hora = hora;
    }

    public int getNumPer() {
        return numPer;
    }

    public void setNumPer(int numPer) {
        if (numPer <= 0) {
            throw new IllegalArgumentException("El número de personas debe ser mayor a 0.");
        }
        this.numPer = numPer;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        if (idReserva <= 0) {
            throw new IllegalArgumentException("El ID de la reserva debe ser mayor a 0.");
        }
        this.idReserva = idReserva;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        if (fecha == null || fecha.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha debe ser válida y no puede ser anterior a hoy.");
        }
        this.fecha = fecha;
    }

    // Método toString para mostrar los datos
    @Override
    public String toString() {
        return "Reserva{" +
                "hora=" + hora +
                ", numPer=" + numPer +
                ", idReserva=" + idReserva +
                ", fecha=" + fecha +
                '}';
    }
}
