codex/implement-datamanager-methods-for-file-handling
package app;

import Clases.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
=======
codex/convert-.java-files-to-lf-endings
package app;

import Clases.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gerente gerente = new Gerente();
        Estacionamiento estacionamiento = new Estacionamiento();
        estacionamiento.cargarClientesDesdeArchivo("clientes.txt");
        Operador operador = new Operador();
        Administrativo administrativo = new Administrativo(1, "Juan Perez");

        while (true) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Generar ticket");
            System.out.println("3. Cobrar ticket");
            System.out.println("4. Atender llamadas (Operador)");
            System.out.println("5. Enviar mails (Operador)");
            System.out.println("6. Administrar Whatsapp (Operador)");
            System.out.println("7. Pedir información (Operador)");
            System.out.println("8. Ingresar entrada de vehículo (Administrativo)");
            System.out.println("9. Registrar salida de vehículo (Administrativo)");
            System.out.println("10. Ver disponibilidad de plazas (Administrativo)");
            System.out.println("11. Salir");
            System.out.print("\nSeleccione una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());
            System.out.println();

            switch (opcion) {
                case 1:
                    operador.registrarCliente(estacionamiento);
                    break;
                case 2:
                    Ticket ticket = gerente.generarTicket();
                    if (ticket != null) {
                        System.out.println("\nTicket generado: " + ticket.getIdTicket() + "\n");
                    }
                    break;
                case 3:
                    // Para demo, generamos un ticket nuevo (en un sistema real, deberías buscar el ticket real)
                    Ticket ticketParaCobrar = gerente.generarTicket();
                    gerente.recibirPagoDelCliente(ticketParaCobrar);
                    break;
                case 4:
                    operador.atenderLlamadas();
                    break;
                case 5:
                    operador.enviarMails();
                    break;
                case 6:
                    operador.administrarWhatsapp();
                    break;
                case 7:
                    operador.pedirInformacion();
                    break;
                case 8:
                    System.out.print("Ingrese número de plaza: ");
                    int numPlazaEntrada = Integer.parseInt(scanner.nextLine());
                    PlazaDeAparcamiento plazaEntrada = PlazaDeAparcamiento.obtenerPlazaPorNumero(numPlazaEntrada);
                    System.out.print("Ingrese marca del vehículo: ");
                    String marcaEntrada = scanner.nextLine();
                    System.out.print("Ingrese patente del vehículo: ");
                    String patenteEntrada = scanner.nextLine();
                    System.out.print("Ingrese tipo de vehículo: ");
                    String tipoEntrada = scanner.nextLine();
                    Vehiculo vehiculoEntrada = new Vehiculo(marcaEntrada, patenteEntrada, tipoEntrada);
                    administrativo.ingresarEntradaDeVehiculos(plazaEntrada, vehiculoEntrada);
                    break;
                case 9:
                    System.out.print("Ingrese número de plaza: ");
                    int numPlazaSalida = Integer.parseInt(scanner.nextLine());
                    PlazaDeAparcamiento plazaSalida = PlazaDeAparcamiento.obtenerPlazaPorNumero(numPlazaSalida);
                    administrativo.registrarSalidaDeVehiculos(plazaSalida);
                    break;
                case 10:
                    administrativo.verDisponibilidadDePlazas();
                    break;
                case 11:
                    System.out.println("¡Hasta luego!");
                    estacionamiento.guardarClientesEnArchivo("clientes.txt");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
=======
package app;

import Clases.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
main
        Scanner scanner = new Scanner(System.in);
        Gerente gerente = new Gerente();
        Estacionamiento estacionamiento = new Estacionamiento();
        estacionamiento.cargarClientes("data/clientes.csv");
        estacionamiento.cargarTickets("data/tickets.csv");
        Operador operador = new Operador();
        Administrativo administrativo = new Administrativo(1, "Juan Perez");

codex/implement-datamanager-methods-for-file-handling
        DataManager.cargarClientes();
        DataManager.cargarTickets();

        while (true) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Generar ticket");
            System.out.println("3. Cobrar ticket");
            System.out.println("4. Atender llamadas (Operador)");
            System.out.println("5. Enviar mails (Operador)");
            System.out.println("6. Administrar Whatsapp (Operador)");
            System.out.println("7. Pedir información (Operador)");
            System.out.println("8. Ingresar entrada de vehículo (Administrativo)");
            System.out.println("9. Registrar salida de vehículo (Administrativo)");
            System.out.println("10. Ver disponibilidad de plazas (Administrativo)");
            System.out.println("11. Salir");
            System.out.print("\nSeleccione una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());
            System.out.println();

            switch (opcion) {
                case 1:
                    operador.registrarCliente(estacionamiento);
                    break;
                case 2:
                    Ticket ticket = gerente.generarTicket();
                    if (ticket != null) {
                        estacionamiento.agregarTicket(ticket);
                        System.out.println("\nTicket generado: " + ticket.getIdTicket() + "\n");
                    }
                    break;
                case 3:
                    // Para demo, generamos un ticket nuevo (en un sistema real, deberías buscar el ticket real)
                    Ticket ticketParaCobrar = gerente.generarTicket();
                    gerente.recibirPagoDelCliente(ticketParaCobrar);
                    break;
                case 4:
                    operador.atenderLlamadas();
                    break;
                case 5:
                    operador.enviarMails();
                    break;
                case 6:
                    operador.administrarWhatsapp();
                    break;
                case 7:
                    operador.pedirInformacion();
                    break;
                case 8:
                    System.out.print("Ingrese número de plaza: ");
                    int numPlazaEntrada = Integer.parseInt(scanner.nextLine());
                    PlazaDeAparcamiento plazaEntrada = PlazaDeAparcamiento.obtenerPlazaPorNumero(numPlazaEntrada);
                    System.out.print("Ingrese marca del vehículo: ");
                    String marcaEntrada = scanner.nextLine();
                    System.out.print("Ingrese patente del vehículo: ");
                    String patenteEntrada = scanner.nextLine();
                    System.out.print("Ingrese tipo de vehículo: ");
                    String tipoEntrada = scanner.nextLine();
                    Vehiculo vehiculoEntrada = new Vehiculo(marcaEntrada, patenteEntrada, tipoEntrada);
                    administrativo.ingresarEntradaDeVehiculos(plazaEntrada, vehiculoEntrada);
                    break;
                case 9:
                    System.out.print("Ingrese número de plaza: ");
                    int numPlazaSalida = Integer.parseInt(scanner.nextLine());
                    PlazaDeAparcamiento plazaSalida = PlazaDeAparcamiento.obtenerPlazaPorNumero(numPlazaSalida);
                    administrativo.registrarSalidaDeVehiculos(plazaSalida);
                    break;
                case 10:
                    administrativo.verDisponibilidadDePlazas();
                    break;
                case 11:
codex/implement-file-save/load-for-cliente-and-ticket
                    estacionamiento.guardarClientes("data/clientes.csv");
                    estacionamiento.guardarTickets("data/tickets.csv");
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;
=======
                    System.out.println("¡Hasta luego!");
                    estacionamiento.guardarClientesEnArchivo();
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
=======
        while (true) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Generar ticket");
            System.out.println("3. Cobrar ticket");
            System.out.println("4. Atender llamadas (Operador)");
            System.out.println("5. Enviar mails (Operador)");
            System.out.println("6. Administrar Whatsapp (Operador)");
            System.out.println("7. Pedir información (Operador)");
            System.out.println("8. Ingresar entrada de vehículo (Administrativo)");
            System.out.println("9. Registrar salida de vehículo (Administrativo)");
            System.out.println("10. Ver disponibilidad de plazas (Administrativo)");
            System.out.println("11. Guardar datos");
            System.out.println("12. Cargar datos");
            System.out.println("13. Salir");
            System.out.print("\nSeleccione una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());
            System.out.println();

            switch (opcion) {
                case 1:
                    operador.registrarCliente(estacionamiento);
                    break;
                case 2:
                    Ticket ticket = gerente.generarTicket();
                    if (ticket != null) {
                        System.out.println("\nTicket generado: " + ticket.getIdTicket() + "\n");
                    }
                    break;
                case 3:
                    // Para demo, generamos un ticket nuevo (en un sistema real, deberías buscar el ticket real)
                    Ticket ticketParaCobrar = gerente.generarTicket();
                    gerente.recibirPagoDelCliente(ticketParaCobrar);
                    break;
                case 4:
                    operador.atenderLlamadas();
                    break;
                case 5:
                    operador.enviarMails();
                    break;
                case 6:
                    operador.administrarWhatsapp();
                    break;
                case 7:
                    operador.pedirInformacion();
                    break;
                case 8:
                    System.out.print("Ingrese número de plaza: ");
                    int numPlazaEntrada = Integer.parseInt(scanner.nextLine());
                    PlazaDeAparcamiento plazaEntrada = PlazaDeAparcamiento.obtenerPlazaPorNumero(numPlazaEntrada);
                    System.out.print("Ingrese marca del vehículo: ");
                    String marcaEntrada = scanner.nextLine();
                    System.out.print("Ingrese patente del vehículo: ");
                    String patenteEntrada = scanner.nextLine();
                    System.out.print("Ingrese tipo de vehículo: ");
                    String tipoEntrada = scanner.nextLine();
                    Vehiculo vehiculoEntrada = new Vehiculo(marcaEntrada, patenteEntrada, tipoEntrada);
                    administrativo.ingresarEntradaDeVehiculos(plazaEntrada, vehiculoEntrada);
                    break;
                case 9:
                    System.out.print("Ingrese número de plaza: ");
                    int numPlazaSalida = Integer.parseInt(scanner.nextLine());
                    PlazaDeAparcamiento plazaSalida = PlazaDeAparcamiento.obtenerPlazaPorNumero(numPlazaSalida);
                    administrativo.registrarSalidaDeVehiculos(plazaSalida);
                    break;
                case 10:
                    administrativo.verDisponibilidadDePlazas();
                    break;
                case 11:
                    estacionamiento.guardar("estado.ser");
                    System.out.println("Datos guardados.");
                    break;
                case 12:
                    estacionamiento.cargar("estado.ser");
                    System.out.println("Datos cargados.");
                    break;
                case 13:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;
 main
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
main
main
