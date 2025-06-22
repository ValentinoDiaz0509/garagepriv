package Clases;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Gerente {

    private Scanner scanner = new Scanner(System.in);

    // Método para generar un ticket
    public Ticket generarTicket() {
        System.out.print("Ingrese la patente del vehículo: ");
        String patente = scanner.nextLine();

        System.out.print("Ingrese la marca del vehículo: ");
        String marca = scanner.nextLine();

        System.out.print("Ingrese el tipo de vehículo: ");
        String tipo = scanner.nextLine();

        Vehiculo vehiculo = new Vehiculo(marca, patente, tipo);

        System.out.print("Ingrese el número de plaza de aparcamiento: ");
        int numeroPlaza = Integer.parseInt(scanner.nextLine());

        // Suponiendo que tienes un método para obtener la plaza por número
        PlazaDeAparcamiento plaza = PlazaDeAparcamiento.obtenerPlazaPorNumero(numeroPlaza);

        if (plaza == null) {
            System.out.println("Plaza no encontrada.");
            return null;
        }

        LocalDateTime fechaHoraIngreso = LocalDateTime.now();

        Ticket ticket = new Ticket(vehiculo, plaza, fechaHoraIngreso);

        DataManager.guardarTicket(ticket);

        System.out.println("Ticket generado correctamente: " + ticket.getIdTicket());
        return ticket;
    }

    // Método para recibir el pago del cliente
    public void recibirPagoDelCliente(Ticket ticket) {
        double tarifaPorHora = 4.8;

        // Registrar la salida
        LocalDateTime fechaHoraSalida = LocalDateTime.now();
        ticket.setFechaHoraSalida(fechaHoraSalida);

        // Calcular el monto
        double monto = ticket.calcularMontoEstadia(tarifaPorHora);

        // Solicitar método de pago
        System.out.print("¿El pago se realiza por tarjeta o efectivo? ");
        String metodoDePago = scanner.nextLine();

        LocalDateTime fechaDePago = LocalDateTime.now();

        // Crear el pago
        Pago pago = new Pago(monto, metodoDePago, fechaDePago);

        System.out.println("El pago es de $" + monto);
        System.out.println("El método de pago es: " + metodoDePago);
        System.out.println("El horario en el que se realizó el pago es: " + fechaDePago);
        System.out.println("Pago registrado correctamente.");
    }
}