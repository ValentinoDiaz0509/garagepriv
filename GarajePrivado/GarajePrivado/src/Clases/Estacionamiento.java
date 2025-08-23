package Clases;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamiento {
    private List<Ticket> listaTickets;
    private List<Cliente> listaClientes;

    public Estacionamiento() {
        listaTickets = new ArrayList<>();
        listaClientes = new ArrayList<>();
    }

    public List<Ticket> getListaTickets() {
        return listaTickets;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void agregarCliente(Cliente cliente) {
        PlazaDeAparcamiento plazaLibre = PlazaDeAparcamiento.obtenerPrimeraPlazaLibre();
        if (plazaLibre != null) {
            plazaLibre = plazaLibre.ocuparPlaza(cliente.vehiculo());
            cliente = cliente.withNumeroPlaza(plazaLibre.numero());
            System.out.println("Cliente agregado correctamente. Se le asignó la plaza número " + plazaLibre.numero());
        } else {
            System.out.println("No hay plazas de aparcamiento disponibles para asignar al cliente.");
        }
        listaClientes.add(cliente);
    }

    public void agregarTicket(Ticket ticket) {
        listaTickets.add(ticket);
    }

    public void guardarClientes(String ruta) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            for (Cliente c : listaClientes) {
                Vehiculo v = c.vehiculo();
                pw.println(c.nombre() + "," + c.dni() + "," + c.telefono() + "," +
                        v.marca() + "," + v.patente() + "," + v.tipo());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar clientes: " + e.getMessage());
        }
    }

    public void cargarClientes(String ruta) {
        File archivo = new File(ruta);
        if (!archivo.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 6) {
                    Vehiculo v = new Vehiculo(partes[3], partes[4], partes[5]);
                    Cliente c = new Cliente(partes[0], partes[1], partes[2], v);
                    listaClientes.add(c);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar clientes: " + e.getMessage());
        }
    }

    public void guardarTickets(String ruta) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            for (Ticket t : listaTickets) {
                Vehiculo v = t.vehiculo();
                String salida = t.getFechaHoraSalida() == null ? "" : t.getFechaHoraSalida().toString();
                pw.println(t.getIdTicket() + "," + v.marca() + "," + v.patente() + "," + v.tipo() + "," +
                        t.getPlazaDeAparcamiento().numero() + "," + t.getFechaHoraIngreso().toString() + "," + salida + "," + t.getMonto());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar tickets: " + e.getMessage());
        }
    }

    public void cargarTickets(String ruta) {
        File archivo = new File(ruta);
        if (!archivo.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 7) {
                    Vehiculo v = new Vehiculo(partes[1], partes[2], partes[3]);
                    PlazaDeAparcamiento plaza = PlazaDeAparcamiento.obtenerPlazaPorNumero(Integer.parseInt(partes[4]));
                    LocalDateTime ingreso = LocalDateTime.parse(partes[5]);
                    Ticket t = new Ticket(v, plaza, ingreso);
                    if (!partes[6].isEmpty()) {
                        t.setFechaHoraSalida(LocalDateTime.parse(partes[6]));
                    }
                    if (partes.length >= 8) {
                        t.setMonto(Double.parseDouble(partes[7]));
                    }
                    listaTickets.add(t);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar tickets: " + e.getMessage());
        }
    }
}
