// Autor: [AYMANE EL KHILALY]

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

// Autor: [AYMANE EL KHILALY]

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArraydeReserva arrayEjemplo = new ArraydeReserva();

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar");
            System.out.println("3. Actualizar");
            System.out.println("4. Consultar");
            System.out.println("5. Imprimir");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1: // Insertar
                    System.out.print("Introduce la hora (HH:mm): ");
                    LocalTime hora = LocalTime.parse(scanner.nextLine());
                    System.out.print("Introduce el número de personas: ");
                    int numPer = scanner.nextInt();
                    System.out.print("Introduce el ID de la reserva: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Introduce la fecha (YYYY-MM-DD): ");
                    LocalDate fecha = LocalDate.parse(scanner.nextLine());
                    if (arrayEjemplo.addNewEjemplo(new Reserva(hora, numPer, id, fecha))) {
                        System.out.println("Reserva añadida correctamente.");
                    } else {
                        System.out.println("Error: ID ya existente.");
                    }
                    break;
                case 2: // Eliminar
                    System.out.print("Introduce el ID de la reserva a eliminar: ");
                    if (arrayEjemplo.removeEjemplo(scanner.nextInt())) {
                        System.out.println("Reserva eliminada.");
                    } else {
                        System.out.println("Error: ID no encontrado.");
                    }
                    break;
                case 3: // Actualizar
                    System.out.print("Introduce el ID de la reserva a actualizar: ");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nueva hora (HH:mm): ");
                    LocalTime newHora = LocalTime.parse(scanner.nextLine());
                    System.out.print("Nuevo número de personas: ");
                    int newNumPer = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nueva fecha (YYYY-MM-DD): ");
                    LocalDate newFecha = LocalDate.parse(scanner.nextLine());
                    if (arrayEjemplo.updateEjemplo(idUpdate, newHora, newNumPer, newFecha)) {
                        System.out.println("Reserva actualizada.");
                    } else {
                        System.out.println("Error: ID no encontrado.");
                    }
                    break;
                case 4: // Consultar
                case 5: // Imprimir
                    arrayEjemplo.queryEjemplo();
                    break;
                case 6: // Salir
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
