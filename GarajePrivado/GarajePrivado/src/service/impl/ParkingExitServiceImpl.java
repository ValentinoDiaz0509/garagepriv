package service.impl;

import Clases.PlazaDeAparcamiento;
import Clases.Vehiculo;
import service.ParkingExitService;

public class ParkingExitServiceImpl implements ParkingExitService {
    @Override
    public void registrarSalida(PlazaDeAparcamiento plaza) {
        if (plaza == null) {
            System.out.println("Error: No se indicó una plaza de aparcamiento.");
            return;
        }
        if (!plaza.estaOcupada()) {
            System.out.println("Información: La plaza " + plaza.getNumero() + " ya se encontraba libre.");
            return;
        }
        Vehiculo vehiculo = PlazaDeAparcamiento.desocuparPlaza(plaza.getNumero());
        if (vehiculo != null) {
            System.out.println("Vehículo " + vehiculo.getPatente() + " salió de la plaza " + plaza.getNumero() + ".");
        }
    }
}
