 codex/verificar-persistencia-y-guardado-en-archivo-txt
package Clases;

=======
package Clases;

 codex/convert-.java-files-to-lf-endings
 main
public class Cliente {

    private String nombre;
    private String dni;
    private String telefono;
    private Vehiculo vehiculo;
 codex/verificar-persistencia-y-guardado-en-archivo-txt
    private int numeroPlaza;

=======

main
    public Cliente(String nombre, String dni, String telefono, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.vehiculo = vehiculo;
 codex/verificar-persistencia-y-guardado-en-archivo-txt
        this.numeroPlaza = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

=======
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

main
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

codex/verificar-persistencia-y-guardado-en-archivo-txt
    public int getNumeroPlaza() {
        return numeroPlaza;
    }

    public void setNumeroPlaza(int numeroPlaza) {
        this.numeroPlaza = numeroPlaza;
    }
    
}
=======
}
=======
import java.io.Serializable;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String dni;
    private String telefono;
    private Vehiculo vehiculo;

    public Cliente(String nombre, String dni, String telefono, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.vehiculo = vehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
}
main
 main
