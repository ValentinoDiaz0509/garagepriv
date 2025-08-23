package service.impl;

import Clases.PlazaDeAparcamiento;
import Clases.Vehiculo;
import service.ParkingEntryService;

public class ParkingEntryServiceImpl implements ParkingEntryService {
    @Override
    public void ingresarVehiculo(PlazaDeAparcamiento plaza, Vehiculo vehiculo) {
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
}
