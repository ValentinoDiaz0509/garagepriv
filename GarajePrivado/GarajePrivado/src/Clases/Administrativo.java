package Clases;

public class Administrativo extends Empleado {

    public Administrativo(int id, String nombre) {
        super(id, nombre);
    }

    public void ingresarEntradaDeVehiculos(PlazaDeAparcamiento plaza, Vehiculo vehiculo) {
        if (plaza == null) {
            System.out.println("Error: No hay una plaza de aparcamiento.");
            return;
        }
        if (vehiculo == null) {
            System.out.println("Error: No hay un vehículo.");
            return;
        }
        if (plaza.ocupada()) {
            System.out.println("Error: La plaza " + plaza.numero() + " ya está ocupada.");
            return;
        }
        plaza.ocuparPlaza(vehiculo);
        System.out.println("Vehículo " + vehiculo.patente() + " ingresado en la plaza " + plaza.numero() + ".");
    }

    public void registrarSalidaDeVehiculos(PlazaDeAparcamiento plaza) {
        if (plaza == null) {
            System.out.println("Error: No se indicó una plaza de aparcamiento.");
            return;
        }
        if (!plaza.ocupada()) {
            System.out.println("Información: La plaza " + plaza.numero() + " ya se encontraba libre.");
            return;
        }
        Vehiculo vehiculo = PlazaDeAparcamiento.desocuparPlaza(plaza.numero());
        if (vehiculo != null) {
            System.out.println("Vehículo " + vehiculo.patente() + " salió de la plaza " + plaza.numero() + ".");
        }
    }

    public void verDisponibilidadDePlazas() {
        PlazaDeAparcamiento.mostrarEstadoPlazas();
    }
}
