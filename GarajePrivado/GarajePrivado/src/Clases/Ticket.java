package Clases;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int contadorTickets = 0;

    private final String idTicket;
    private final Vehiculo vehiculo;
    private final PlazaDeAparcamiento plazaDeAparcamiento;
    private final LocalDateTime fechaHoraIngreso;
    private LocalDateTime fechaHoraSalida;
    private double monto;

    public Ticket(Vehiculo vehiculo, PlazaDeAparcamiento plazaDeAparcamiento, LocalDateTime fechaHoraIngreso) {
        this.idTicket = "TICKET-" + (++contadorTickets);
        this.vehiculo = vehiculo;
        this.plazaDeAparcamiento = plazaDeAparcamiento;
        this.fechaHoraIngreso = fechaHoraIngreso;
        System.out.println("Ticket " + idTicket + " generado para vehículo " + vehiculo.patente() +
                " en la plaza " + plazaDeAparcamiento.numero());
    }

    public String getIdTicket() {
        return idTicket;
    }

    public Vehiculo vehiculo() {
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

    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double calcularMontoEstadia(double tarifaPorHora) {
        if (this.fechaHoraSalida == null) {
            System.out.println("El vehículo aún no ha registrado su salida.");
            return 0.0;
        }
        long horasCompletas = ChronoUnit.HOURS.between(fechaHoraIngreso, fechaHoraSalida);
        if (horasCompletas <= 0) {
            horasCompletas = 1;
        }
        this.monto = horasCompletas * tarifaPorHora;
        System.out.println("Horas completas estacionado: " + horasCompletas + ". Monto calculado: $" + this.monto);
        return this.monto;
    }
}
