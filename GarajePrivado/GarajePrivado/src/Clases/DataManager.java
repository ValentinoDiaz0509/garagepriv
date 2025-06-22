package Clases;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static final String CLIENTES_FILE = "clientes.txt";
    private static final String TICKETS_FILE = "tickets.txt";

    public static void guardarCliente(Cliente cliente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CLIENTES_FILE, true))) {
            Vehiculo v = cliente.getVehiculo();
            writer.write(cliente.getNombre() + "," + cliente.getDni() + "," + cliente.getTelefono()
                    + "," + v.getMarca() + "," + v.getPatente() + "," + v.getTipo());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarTicket(Ticket ticket) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TICKETS_FILE, true))) {
            Vehiculo v = ticket.getVehiculo();
            writer.write(ticket.getIdTicket() + "," + v.getMarca() + "," + v.getPatente() + "," + v.getTipo()
                    + "," + ticket.getPlazaDeAparcamiento().getNumero() + "," + ticket.getFechaHoraIngreso().toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Cliente> cargarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        Path path = Paths.get(CLIENTES_FILE);
        if (Files.exists(path)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(CLIENTES_FILE))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] p = line.split(",");
                    if (p.length >= 6) {
                        Vehiculo v = new Vehiculo(p[3], p[4], p[5]);
                        Cliente c = new Cliente(p[0], p[1], p[2], v);
                        clientes.add(c);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return clientes;
    }

    public static List<Ticket> cargarTickets() {
        List<Ticket> tickets = new ArrayList<>();
        Path path = Paths.get(TICKETS_FILE);
        if (Files.exists(path)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(TICKETS_FILE))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] p = line.split(",");
                    if (p.length >= 6) {
                        Vehiculo v = new Vehiculo(p[1], p[2], p[3]);
                        int numPlaza = Integer.parseInt(p[4]);
                        PlazaDeAparcamiento plaza = PlazaDeAparcamiento.obtenerPlazaPorNumero(numPlaza);
                        LocalDateTime fecha = LocalDateTime.parse(p[5]);
                        Ticket t = new Ticket(v, plaza, fecha);
                        tickets.add(t);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tickets;
    }
}
