package service;

import Clases.PlazaDeAparcamiento;
import Clases.Vehiculo;

public interface ParkingEntryService {
    void ingresarVehiculo(PlazaDeAparcamiento plaza, Vehiculo vehiculo);
}
