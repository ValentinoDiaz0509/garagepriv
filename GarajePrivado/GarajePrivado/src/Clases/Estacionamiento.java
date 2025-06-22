package Clases;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Estacionamiento {
    private List<String> tickets;
    private List<String> plazas;
    private List<String> empleados;
    private List<Cliente> listaClientes; // Debe ser List<Cliente>
    private int cantidadDePlazasDeAparcamientos = 60;

    public Estacionamiento() {
        tickets = new ArrayList<>();
        plazas = new ArrayList<>();
        empleados = new ArrayList<>();
        listaClientes = new ArrayList<>();
        cargarClientesDesdeArchivo();
    }

    // Getters y setters
    public List<String> getTickets() {
        return tickets;
    }

    public void setTickets(List<String> tickets) {
        this.tickets = tickets;
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
            cliente.setNumeroPlaza(plazaLibre.getNumero());
            System.out.println("Cliente agregado correctamente. Se le asignó la plaza número " + plazaLibre.getNumero());
        } else {
            System.out.println("No hay plazas de aparcamiento disponibles para asignar al cliente.");
        }
        listaClientes.add(cliente);
    }

    public void guardarClientesEnArchivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("clientes.txt"))) {
            for (Cliente c : listaClientes) {
                Vehiculo v = c.getVehiculo();
                writer.println(c.getNombre() + ";" + c.getDni() + ";" + c.getTelefono() + ";" +
                        v.getMarca() + ";" + v.getPatente() + ";" + v.getTipo() + ";" + c.getNumeroPlaza());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar clientes: " + e.getMessage());
        }
    }

    private void cargarClientesDesdeArchivo() {
        if (!Files.exists(Paths.get("clientes.txt"))) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader("clientes.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 7) {
                    String nombre = parts[0];
                    String dni = parts[1];
                    String telefono = parts[2];
                    String marca = parts[3];
                    String patente = parts[4];
                    String tipo = parts[5];
                    int numeroPlaza = Integer.parseInt(parts[6]);

                    Vehiculo vehiculo = new Vehiculo(marca, patente, tipo);
                    Cliente cliente = new Cliente(nombre, dni, telefono, vehiculo);
                    cliente.setNumeroPlaza(numeroPlaza);
                    listaClientes.add(cliente);

                    PlazaDeAparcamiento plaza = PlazaDeAparcamiento.obtenerPlazaPorNumero(numeroPlaza);
                    if (plaza != null && !plaza.estaOcupada()) {
                        plaza.ocuparPlaza(vehiculo);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar clientes: " + e.getMessage());
        }
    }
}