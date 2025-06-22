package Clases;

codex/convert-.java-files-to-lf-endings
import java.util.ArrayList;
import java.util.List;

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
=======
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Estacionamiento implements Serializable {
    private static final long serialVersionUID = 1L;
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
 main
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
 codex/convert-.java-files-to-lf-endings
}
=======

    public void guardar(String archivo) {
        Persistencia.guardarEstado(this, archivo);
    }

    public void cargar(String archivo) {
        Persistencia.cargarEstado(this, archivo);
    }
}
 main
