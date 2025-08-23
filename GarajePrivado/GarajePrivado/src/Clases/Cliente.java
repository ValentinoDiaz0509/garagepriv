package Clases;

import java.io.Serializable;

public record Cliente(String nombre, String dni, String telefono, Vehiculo vehiculo, int numeroPlaza) implements Serializable {
    private static final long serialVersionUID = 1L;

    public Cliente(String nombre, String dni, String telefono, Vehiculo vehiculo) {
        this(nombre, dni, telefono, vehiculo, 0);
    }

    public Cliente withNumeroPlaza(int numeroPlaza) {
        return new Cliente(nombre, dni, telefono, vehiculo, numeroPlaza);
    }
}
