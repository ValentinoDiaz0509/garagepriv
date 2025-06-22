package Clases;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.time.LocalDateTime;

public class Estacionamiento {
    private List<Ticket> listaTickets;
    private List<String> plazas;
    private List<String> empleados;
    private List<Cliente> listaClientes;
    private int cantidadDePlazasDeAparcamientos = 60;

    public Estacionamiento() {
        listaTickets = new ArrayList<>();
        plazas = new ArrayList<>();
        empleados = new ArrayList<>();
        listaClientes = new ArrayList<>();
    }

    // Getters y setters
    public List<Ticket> getListaTickets() {
        return listaTickets;
    }

    public void setListaTickets(List<Ticket> listaTickets) {
        this.listaTickets = listaTickets;
    }

    public List<String> getPlazas() {
        return plazas;
    }

    public void setPlazas(List<String> plazas) {
        this.plazas = plazas;
    }

    public List<String> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<String> empleados) {
        this.empleados = empleados;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    // Métodos
    public void agregarCliente(Cliente cliente) {
        PlazaDeAparcamiento plazaLibre = PlazaDeAparcamiento.obtenerPrimeraPlazaLibre();
        if (plazaLibre != null) {
            plazaLibre.ocuparPlaza(cliente.getVehiculo());
            System.out.println("Cliente agregado correctamente. Se le asignó la plaza número " + plazaLibre.getNumero());
        } else {
            System.out.println("No hay plazas de aparcamiento disponibles para asignar al cliente.");
        }
        listaClientes.add(cliente);
    }

    public void agregarTicket(Ticket ticket) {
        listaTickets.add(ticket);
    }

    // Persistencia de clientes en formato CSV
    public void guardarClientes(String ruta) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            for (Cliente c : listaClientes) {
                Vehiculo v = c.getVehiculo();
                pw.println(c.getNombre() + "," + c.getDni() + "," + c.getTelefono() + "," +
                        v.getMarca() + "," + v.getPatente() + "," + v.getTipo());
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

    // Persistencia de tickets en formato CSV
    public void guardarTickets(String ruta) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            for (Ticket t : listaTickets) {
                Vehiculo v = t.getVehiculo();
                String salida = t.getFechaHoraSalida() == null ? "" : t.getFechaHoraSalida().toString();
                pw.println(t.getIdTicket() + "," + v.getMarca() + "," + v.getPatente() + "," + v.getTipo() + "," +
                        t.getPlazaDeAparcamiento().getNumero() + "," + t.getFechaHoraIngreso().toString() + "," + salida + "," + t.getMonto());
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