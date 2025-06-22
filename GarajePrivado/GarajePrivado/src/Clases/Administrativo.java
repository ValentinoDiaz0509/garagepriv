package Clases;

import java.util.List;

public class Administrativo extends Empleado {

    // Constructor
    public Administrativo(int id, String nombre) {
        super(id, nombre);
    }

    // ingresarEntradaDeVehiculos toma como parámetro plaza y vehiculo.
    public void ingresarEntradaDeVehiculos(PlazaDeAparcamiento plaza, Vehiculo vehiculo) {
        

        if (plaza == null) {
            System.out.println("Error: No hay una plaza de aparcamiento.");
            return;
        }

        if (vehiculo == null) {
            System.out.println("Error: No hay un vehículo.");
            return;
        }

        if (plaza.estaOcupada()) {
            System.out.println("Error: La plaza " + plaza.getNumero() + " ya está ocupada.");
            return;
        }

        plaza.ocuparPlaza(vehiculo);
        System.out.println("Vehículo " + vehiculo.getPatente() + " ingresado en la plaza " + plaza.getNumero() + ".");
    }

    
    
    public void registrarSalidaDeVehiculos(PlazaDeAparcamiento plaza) {
        

        if (plaza == null) {
            System.out.println("Error: No se indicó una plaza de aparcamiento.");
            return;
        }

        if (!plaza.estaOcupada()) {
            System.out.println("Información: La plaza " + plaza.getNumero() + " ya se encontraba libre.");
            return;
        }

        Vehiculo vehiculo = plaza.getVehiculoEstacionado();
        
        // Utilizar el método estático para desocupar la plaza
        PlazaDeAparcamiento.desocuparPlaza(plaza.getNumero());
        
        System.out.println("Vehículo salió de la plaza.");
    }

    
    
    // verDisponibilidadDePlazas revisa el estado de una plaza
    public void verDisponibilidadDePlazas() {
    	PlazaDeAparcamiento.mostrarEstadoPlazas();
    }
    
}
