package Clases;

public class Vehiculo {
    private String patente;
    private String marca;
    private String tipo;

    // Constructor
    public Vehiculo(String marca, String patente, String tipo) {
        this.marca = marca;
        this.patente = patente;
        this.tipo = tipo;
    }

    // Getters
    public String getPatente() {
        return patente;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    // Setters
    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
