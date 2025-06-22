codex/verificar-persistencia-y-guardado-en-archivo-txt
package Clases;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ticket {
    private static int contadorTickets = 0;
    private String idTicket;
    private Vehiculo vehiculo;
    private PlazaDeAparcamiento plazaDeAparcamiento;
    private LocalDateTime fechaHoraIngreso;
    private LocalDateTime fechaHoraSalida;
    private double monto;

    static {
        cargarContador();
    }
=======
package Clases;

 codex/convert-.java-files-to-lf-endings
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Ticket {
    private static int contadorTickets = 0;
    private String idTicket;
    private Vehiculo vehiculo;
    private PlazaDeAparcamiento plazaDeAparcamiento;
    private LocalDateTime fechaHoraIngreso;
    private LocalDateTime fechaHoraSalida;
    private double monto;
main

    // Constructor
    public Ticket(Vehiculo vehiculo, PlazaDeAparcamiento plazaDeAparcamiento, LocalDateTime fechaHoraIngreso) {
        this.idTicket = "TICKET-" + (++contadorTickets);
 codex/verificar-persistencia-y-guardado-en-archivo-txt
        guardarContador();
=======
 main
        this.vehiculo = vehiculo;
        this.plazaDeAparcamiento = plazaDeAparcamiento;
        this.fechaHoraIngreso = fechaHoraIngreso;
        this.fechaHoraSalida = null;
        this.monto = 0.0;
codex/verificar-persistencia-y-guardado-en-archivo-txt
        System.out.println("Ticket " + idTicket + " generado para vehículo " + vehiculo.getPatente() + " en la plaza " + plazaDeAparcamiento.getNumero());
    }

    // Getters
    public String getIdTicket() {
        return idTicket;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public PlazaDeAparcamiento getPlazaDeAparcamiento() {
        return plazaDeAparcamiento;
    }

    public LocalDateTime getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }

    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public double getMonto() {
        return monto;
    }

    // Setters
    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    // Método para calcular el costo de la estadía
    public double calcularMontoEstadia(double tarifaPorHora) {
        if (this.fechaHoraSalida == null) {
            System.out.println("El vehículo aún no ha registrado su salida.");
            return 0.0;
        }

        long horasCompletasEstacionado = ChronoUnit.HOURS.between(fechaHoraIngreso, fechaHoraSalida);

        // Cobrar al menos 1 hora si hay diferencia
        if (horasCompletasEstacionado <= 0) {
            horasCompletasEstacionado = 1;
        }

        this.monto = horasCompletasEstacionado * tarifaPorHora;

        System.out.println("Horas completas estacionado: " + horasCompletasEstacionado + ". Monto calculado: $" + this.monto);
        return this.monto;
    }

    private static void cargarContador() {
        try {
            if (Files.exists(Paths.get("ticket_counter.txt"))) {
                String s = new String(Files.readAllBytes(Paths.get("ticket_counter.txt"))).trim();
                contadorTickets = Integer.parseInt(s);
            }
        } catch (IOException | NumberFormatException e) {
            contadorTickets = 0;
        }
    }

    private static void guardarContador() {
        try {
            Files.write(Paths.get("ticket_counter.txt"), String.valueOf(contadorTickets).getBytes());
        } catch (IOException e) {
            System.out.println("Error al guardar contador de tickets: " + e.getMessage());
        }
    }
}
=======
        System.out.println("Ticket " + idTicket + " generado para vehículo " + vehiculo.getPatente() + " en la plaza " + plazaDeAparcamiento.getNumero());
    }

    // Getters
    public String getIdTicket() {
        return idTicket;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public PlazaDeAparcamiento getPlazaDeAparcamiento() {
        return plazaDeAparcamiento;
    }

    public LocalDateTime getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }

    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public double getMonto() {
        return monto;
    }

    // Setters
    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    // Método para calcular el costo de la estadía
    public double calcularMontoEstadia(double tarifaPorHora) {
        if (this.fechaHoraSalida == null) {
            System.out.println("El vehículo aún no ha registrado su salida.");
            return 0.0;
        }

        long horasCompletasEstacionado = ChronoUnit.HOURS.between(fechaHoraIngreso, fechaHoraSalida);

        // Cobrar al menos 1 hora si hay diferencia
        if (horasCompletasEstacionado <= 0) {
            horasCompletasEstacionado = 1;
        }

        this.monto = horasCompletasEstacionado * tarifaPorHora;

        System.out.println("Horas completas estacionado: " + horasCompletasEstacionado + ". Monto calculado: $" + this.monto);
        return this.monto;
    }
}
=======
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int contadorTickets = 0;
    private String idTicket;
    private Vehiculo vehiculo;
    private PlazaDeAparcamiento plazaDeAparcamiento;
    private LocalDateTime fechaHoraIngreso;
    private LocalDateTime fechaHoraSalida;
    private double monto;

    // Constructor
    public Ticket(Vehiculo vehiculo, PlazaDeAparcamiento plazaDeAparcamiento, LocalDateTime fechaHoraIngreso) {
        this.idTicket = "TICKET-" + (++contadorTickets);
        this.vehiculo = vehiculo;
        this.plazaDeAparcamiento = plazaDeAparcamiento;
        this.fechaHoraIngreso = fechaHoraIngreso;
        this.fechaHoraSalida = null;
        this.monto = 0.0;
        System.out.println("Ticket " + idTicket + " generado para vehículo " + vehiculo.getPatente() + " en la plaza " + plazaDeAparcamiento.getNumero());
    }

    // Getters
    public String getIdTicket() {
        return idTicket;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public PlazaDeAparcamiento getPlazaDeAparcamiento() {
        return plazaDeAparcamiento;
    }

    public LocalDateTime getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }

    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public double getMonto() {
        return monto;
    }

    // Setters
    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    // Método para calcular el costo de la estadía
    public double calcularMontoEstadia(double tarifaPorHora) {
        if (this.fechaHoraSalida == null) {
            System.out.println("El vehículo aún no ha registrado su salida.");
            return 0.0;
        }

        long horasCompletasEstacionado = ChronoUnit.HOURS.between(fechaHoraIngreso, fechaHoraSalida);

        // Cobrar al menos 1 hora si hay diferencia
        if (horasCompletasEstacionado <= 0) {
            horasCompletasEstacionado = 1;
        }

        this.monto = horasCompletasEstacionado * tarifaPorHora;

        System.out.println("Horas completas estacionado: " + horasCompletasEstacionado + ". Monto calculado: $" + this.monto);
        return this.monto;
    }
}
 main
main
