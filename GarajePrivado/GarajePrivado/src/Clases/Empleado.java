package Clases;

public class Empleado {
    private String nombre;
    private int dni; // Considera cambiar a String si es necesario

    public Empleado(int dni, String nombre) {
	this.dni = dni;
        this.nombre = nombre;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

}
