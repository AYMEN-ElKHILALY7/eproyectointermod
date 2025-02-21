// Autor: [AYMANE EL KHILALY]

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Autor: [Tu Nombre y Apellidos]
        Scanner scanner = new Scanner(System.in);

        try {
            // Solicitar datos al usuario
            System.out.print("Introduce la hora de la reserva (HH:mm): ");
            String horaStr = scanner.nextLine();
            LocalTime hora = LocalTime.parse(horaStr, DateTimeFormatter.ofPattern("HH:mm"));

            System.out.print("Introduce el número de personas: ");
            int numPer = Integer.parseInt(scanner.nextLine());

            System.out.print("Introduce el ID de la reserva: ");
            int idReserva = Integer.parseInt(scanner.nextLine());

            System.out.print("Introduce la fecha de la reserva (YYYY-MM-DD): ");
            String fechaStr = scanner.nextLine();
            LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Crear instancia de Reserva
            Reserva reserva = new Reserva(hora, numPer, idReserva, fecha);

            // Mostrar el objeto creado
            System.out.println("\nReserva creada con éxito:");
            System.out.println(reserva);

        } catch (DateTimeParseException e) {
            System.out.println("Error: Formato de fecha u hora incorrecto. Usa HH:mm para la hora y YYYY-MM-DD para la fecha.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Debes ingresar un número válido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
