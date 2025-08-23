package Clases;

import java.io.Serializable;

public record PlazaDeAparcamiento(int numero, boolean ocupada, Vehiculo vehiculoEstacionado) implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final int MAX_PLAZAS = 40;
    private static final PlazaDeAparcamiento[] plazas = new PlazaDeAparcamiento[MAX_PLAZAS];

    static {
        for (int i = 0; i < MAX_PLAZAS; i++) {
            plazas[i] = new PlazaDeAparcamiento(i + 1, false, null);
        }
    }

    public PlazaDeAparcamiento ocuparPlaza(Vehiculo vehiculo) {
        PlazaDeAparcamiento plaza = new PlazaDeAparcamiento(numero, true, vehiculo);
        plazas[numero - 1] = plaza;
        return plaza;
    }

    public static Vehiculo desocuparPlaza(int numeroPlaza) {
        if (numeroPlaza < 1 || numeroPlaza > MAX_PLAZAS) {
            System.out.println("Número de plaza inválido.");
            return null;
        }
        PlazaDeAparcamiento plaza = plazas[numeroPlaza - 1];
        if (plaza.ocupada) {
            Vehiculo vehiculo = plaza.vehiculoEstacionado;
            plazas[numeroPlaza - 1] = new PlazaDeAparcamiento(numeroPlaza, false, null);
            System.out.println("Plaza " + numeroPlaza + " desocupada. Salió: " + (vehiculo != null ? vehiculo.patente() : "Sin datos"));
            return vehiculo;
        } else {
            System.out.println("Error: Plaza " + numeroPlaza + " ya está libre.");
            return null;
        }
    }

    public static void mostrarEstadoPlazas() {
        System.out.println("=== Estado de todas las plazas de aparcamiento ===");
        for (PlazaDeAparcamiento plaza : plazas) {
            if (plaza == null) {
                System.out.println("Plaza inválida");
            } else if (!plaza.ocupada) {
                System.out.println("Plaza " + plaza.numero + ": libre");
            } else {
                System.out.println("Plaza " + plaza.numero + ": ocupada por " +
                        (plaza.vehiculoEstacionado != null ? plaza.vehiculoEstacionado.patente() : "desconocido"));
            }
        }
    }

    public static PlazaDeAparcamiento obtenerPlazaPorNumero(int numero) {
        if (numero < 1 || numero > MAX_PLAZAS) return null;
        return plazas[numero - 1];
    }

    public static PlazaDeAparcamiento obtenerPrimeraPlazaLibre() {
        for (PlazaDeAparcamiento plaza : plazas) {
            if (!plaza.ocupada) {
                return plaza;
            }
        }
        return null; // No hay plazas libres
    }

    public static PlazaDeAparcamiento[] getPlazas() {
        return plazas;
    }

    public static void setPlazas(PlazaDeAparcamiento[] nuevasPlazas) {
        if (nuevasPlazas != null && nuevasPlazas.length == MAX_PLAZAS) {
            System.arraycopy(nuevasPlazas, 0, plazas, 0, MAX_PLAZAS);
        }
    }
}
