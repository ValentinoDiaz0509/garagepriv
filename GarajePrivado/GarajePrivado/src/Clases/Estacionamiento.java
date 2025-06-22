package Clases;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

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
            System.out.println("Cliente agregado correctamente. Se le asignó la plaza número " + plazaLibre.getNumero());
        } else {
            System.out.println("No hay plazas de aparcamiento disponibles para asignar al cliente.");
        }
        listaClientes.add(cliente);
    }

    // Guarda la lista de clientes en un archivo de texto
    public void guardarClientesEnArchivo(String nombreArchivo) {
        try (PrintWriter out = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (Cliente c : listaClientes) {
                Vehiculo v = c.getVehiculo();
                out.println(c.getNombre() + "," + c.getDni() + "," + c.getTelefono() + "," +
                        v.getMarca() + "," + v.getPatente() + "," + v.getTipo());
            }
        } catch (IOException e) {
            System.out.println("Error guardando clientes: " + e.getMessage());
        }
    }

    // Carga la lista de clientes desde un archivo de texto
    public void cargarClientesDesdeArchivo(String nombreArchivo) {
        listaClientes = new ArrayList<>();
        File file = new File(nombreArchivo);
        if (!file.exists()) {
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    String nombre = parts[0];
                    String dni = parts[1];
                    String telefono = parts[2];
                    String marca = parts[3];
                    String patente = parts[4];
                    String tipo = parts[5];
                    Vehiculo vehiculo = new Vehiculo(marca, patente, tipo);
                    Cliente cliente = new Cliente(nombre, dni, telefono, vehiculo);
                    listaClientes.add(cliente);
                }
            }
        } catch (IOException e) {
            System.out.println("Error cargando clientes: " + e.getMessage());
        }
    }
}