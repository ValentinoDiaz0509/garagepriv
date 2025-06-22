package Clases;

import java.util.Scanner;

public class Operador {

    private Scanner scanner = new Scanner(System.in);

    public void atenderLlamadas() {
        System.out.println("Se atiende la llamada");
    }

    public void enviarMails() {
        System.out.println("Se envia un mail");
    }

    public void administrarWhatsapp() {
        System.out.println("Se administra el Whatsapp");
    }

    public void pedirInformacion() {
        System.out.println("Se pide la informacion al cliente");
    }

    public void registrarCliente(Estacionamiento estacionamiento) {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese DNI: ");
        String dni = scanner.nextLine();

        System.out.print("Ingrese la marca del vehiculo: ");
        String marca = scanner.nextLine();

        System.out.print("Ingrese la patente del vehiculo: ");
        String patente = scanner.nextLine();

        System.out.print("Ingrese el tipo de vehiculo: ");
        String tipo = scanner.nextLine();

        // Crea el vehículo
        Vehiculo vehiculo = new Vehiculo(marca, patente, tipo);

        // Crea el cliente (ajusta el constructor según tu clase Cliente)
        Cliente cliente = new Cliente(nombre, dni, telefono, vehiculo);

        estacionamiento.agregarCliente(cliente);
    }
}
