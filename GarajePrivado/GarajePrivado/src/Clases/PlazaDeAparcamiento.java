package Clases;

 codex/convert-.java-files-to-lf-endings
public class PlazaDeAparcamiento {
    private int numero;
    private boolean ocupada;
    private Vehiculo vehiculoEstacionado;

    // Cantidad máxima de plazas
    private static final int MAX_PLAZAS = 40;
    private static PlazaDeAparcamiento[] plazas = new PlazaDeAparcamiento[MAX_PLAZAS];

    // Inicialización estática de las plazas
    static {
        for (int i = 0; i < MAX_PLAZAS; i++) {
            plazas[i] = new PlazaDeAparcamiento(i + 1);
        }
    }

    // Constructor privado para evitar creación externa
    private PlazaDeAparcamiento(int numero) {
        this.numero = numero;
        this.ocupada = false;
        this.vehiculoEstacionado = null;
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public boolean estaOcupada() {
        return ocupada;
    }

    public Vehiculo getVehiculoEstacionado() {
        return vehiculoEstacionado;
    }

    // Métodos de gestión

    public void ocuparPlaza(Vehiculo vehiculo) {
        this.vehiculoEstacionado = vehiculo;
        this.ocupada = true;
    }

    public static Vehiculo desocuparPlaza(int numeroPlaza) {
        if (numeroPlaza < 1 || numeroPlaza > MAX_PLAZAS) {
            System.out.println("Número de plaza inválido.");
            return null;
        }

        PlazaDeAparcamiento plaza = plazas[numeroPlaza - 1];
        if (plaza.estaOcupada()) {
            Vehiculo vehiculo = plaza.vehiculoEstacionado;
            plaza.vehiculoEstacionado = null;
            plaza.ocupada = false;
            System.out.println("Plaza " + numeroPlaza + " desocupada. Salió: " + (vehiculo != null ? vehiculo.getPatente() : "Sin datos"));
            return vehiculo;
        } else {
            System.out.println("Error: Plaza " + numeroPlaza + " ya está libre.");
            return null;
        }
    }

 // Método para ver todas las plazas
    public static void mostrarEstadoPlazas() {
        System.out.println("=== Estado de todas las plazas de aparcamiento ===");
        for (PlazaDeAparcamiento plaza : plazas) {
            if (plaza == null) {
                System.out.println("Plaza inválida");
            } else if (!plaza.estaOcupada()) {
                System.out.println("Plaza " + plaza.getNumero() + ": libre");
            } else {
                System.out.println("Plaza " + plaza.getNumero() + ": ocupada por " +
                    (plaza.getVehiculoEstacionado() != null ? plaza.getVehiculoEstacionado().getPatente() : "desconocido"));
            }
        }
    }


    public static PlazaDeAparcamiento obtenerPlazaPorNumero(int numero) {
        if (numero < 1 || numero > MAX_PLAZAS) return null;
        return plazas[numero - 1];

    }

    public static PlazaDeAparcamiento obtenerPrimeraPlazaLibre() {
        for (PlazaDeAparcamiento plaza : plazas) {
            if (!plaza.estaOcupada()) {
                return plaza;
            }
        }
        return null; // No hay plazas libres
    }

}
=======
import java.io.Serializable;

public class PlazaDeAparcamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    private int numero;
    private boolean ocupada;
    private Vehiculo vehiculoEstacionado;

    // Cantidad máxima de plazas
    private static final int MAX_PLAZAS = 40;
    private static PlazaDeAparcamiento[] plazas = new PlazaDeAparcamiento[MAX_PLAZAS];

    // Inicialización estática de las plazas
    static {
        for (int i = 0; i < MAX_PLAZAS; i++) {
            plazas[i] = new PlazaDeAparcamiento(i + 1);
        }
    }

    // Constructor privado para evitar creación externa
    private PlazaDeAparcamiento(int numero) {
        this.numero = numero;
        this.ocupada = false;
        this.vehiculoEstacionado = null;
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public boolean estaOcupada() {
        return ocupada;
    }

    public Vehiculo getVehiculoEstacionado() {
        return vehiculoEstacionado;
    }

    // Métodos de gestión
    
    public void ocuparPlaza(Vehiculo vehiculo) {
        this.vehiculoEstacionado = vehiculo;
        this.ocupada = true;
    }

    public static Vehiculo desocuparPlaza(int numeroPlaza) {
        if (numeroPlaza < 1 || numeroPlaza > MAX_PLAZAS) {
            System.out.println("Número de plaza inválido.");
            return null;
        }

        PlazaDeAparcamiento plaza = plazas[numeroPlaza - 1];
        if (plaza.estaOcupada()) {
            Vehiculo vehiculo = plaza.vehiculoEstacionado;
            plaza.vehiculoEstacionado = null;
            plaza.ocupada = false;
            System.out.println("Plaza " + numeroPlaza + " desocupada. Salió: " + (vehiculo != null ? vehiculo.getPatente() : "Sin datos"));
            return vehiculo;
        } else {
            System.out.println("Error: Plaza " + numeroPlaza + " ya está libre.");
            return null;
        }
    }

 // Método para ver todas las plazas
    public static void mostrarEstadoPlazas() {
        System.out.println("=== Estado de todas las plazas de aparcamiento ===");
        for (PlazaDeAparcamiento plaza : plazas) {
            if (plaza == null) {
                System.out.println("Plaza inválida");
            } else if (!plaza.estaOcupada()) {
                System.out.println("Plaza " + plaza.getNumero() + ": libre");
            } else {
                System.out.println("Plaza " + plaza.getNumero() + ": ocupada por " +
                    (plaza.getVehiculoEstacionado() != null ? plaza.getVehiculoEstacionado().getPatente() : "desconocido"));
            }
        }
    }
    
    
    public static PlazaDeAparcamiento obtenerPlazaPorNumero(int numero) {
        if (numero < 1 || numero > MAX_PLAZAS) return null;
        return plazas[numero - 1];
        
    }
    
    public static PlazaDeAparcamiento obtenerPrimeraPlazaLibre() {
        for (PlazaDeAparcamiento plaza : plazas) {
            if (!plaza.estaOcupada()) {
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
            plazas = nuevasPlazas;
        }
    }

}
 main
