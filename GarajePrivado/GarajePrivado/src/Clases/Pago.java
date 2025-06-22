package Clases;

 codex/convert-.java-files-to-lf-endings
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pago {
    private double monto;
    private String metodoDePago;
    private LocalDateTime fechaDePago;

    public Pago(double monto, String metodoDePago, LocalDateTime fechaDePago) {
        this.monto = monto;
        this.metodoDePago = metodoDePago;
        this.fechaDePago = fechaDePago;
    }

    // Getters
    public double getMonto() {
        return this.monto;
    }

    public String getMetodoDePago() {
        return this.metodoDePago;
    }

    public LocalDateTime getFechaDePago() {
        return fechaDePago;
    }
}
=======
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pago implements Serializable {
    private static final long serialVersionUID = 1L;
    private double monto;
    private String metodoDePago;
    private LocalDateTime fechaDePago;

    public Pago(double monto, String metodoDePago, LocalDateTime fechaDePago) {
        this.monto = monto;
        this.metodoDePago = metodoDePago;
        this.fechaDePago = fechaDePago;
    }

    // Getters
    public double getMonto() {
        return this.monto;
    }

    public String getMetodoDePago() {
        return this.metodoDePago;
    }

    public LocalDateTime getFechaDePago() {
        return fechaDePago;
    }
}
 main
