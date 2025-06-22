codex/verificar-persistencia-y-guardado-en-archivo-txt
package Clases;

codex/implement-file-save/load-for-cliente-and-ticket
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.time.LocalDateTime;
=======
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
=======
codex/confirm-program-functionality-and-file-handling
package Clases;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
 main
 main

public class Estacionamiento {
    private List<Ticket> listaTickets;
    private List<String> plazas;
    private List<String> empleados;
    private List<Cliente> listaClientes;
    private int cantidadDePlazasDeAparcamientos = 60;

    public Estacionamiento() {
 codex/implement-file-save/load-for-cliente-and-ticket
        listaTickets = new ArrayList<>();
        plazas = new ArrayList<>();
        empleados = new ArrayList<>();
        listaClientes = new ArrayList<>();
=======
        tickets = new ArrayList<>();
        plazas = new ArrayList<>();
        empleados = new ArrayList<>();
        listaClientes = new ArrayList<>();
        cargarClientesDesdeArchivo();
 main
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
codex/implement-file-save/load-for-cliente-and-ticket
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
=======
 codex/verificar-persistencia-y-guardado-en-archivo-txt
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
=======
=======
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
 codex/confirm-program-functionality-and-file-handling

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
=======
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
main
 main
 main
