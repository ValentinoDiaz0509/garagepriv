package Clases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.garage.exception.PersistenceException;

/**
 * Utilidades para guardar y cargar el estado del estacionamiento.
 */
public class Persistencia {

    public static void guardarEstado(Estacionamiento est, String archivo) {
        EstadoEstacionamiento estado = new EstadoEstacionamiento(est.getListaClientes(), PlazaDeAparcamiento.getPlazas());
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(estado);
        } catch (IOException e) {
            throw new PersistenceException("Error al guardar el estado", e);
        }
    }

    public static void cargarEstado(Estacionamiento est, String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            EstadoEstacionamiento estado = (EstadoEstacionamiento) ois.readObject();
            est.setListaClientes(estado.getClientes());
            PlazaDeAparcamiento.setPlazas(estado.getPlazas());
        } catch (IOException | ClassNotFoundException e) {
            throw new PersistenceException("Error al cargar el estado", e);
        }
    }
}
