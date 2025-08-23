package Clases;

import java.io.Serializable;

public record Vehiculo(String marca, String patente, String tipo) implements Serializable {
    private static final long serialVersionUID = 1L;
}
