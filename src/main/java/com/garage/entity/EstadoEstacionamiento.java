package com.garage.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Contiene la información necesaria para persistir el estado del estacionamiento.
 */
public class EstadoEstacionamiento implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Cliente> clientes;
    private PlazaDeAparcamiento[] plazas;

    public EstadoEstacionamiento(List<Cliente> clientes, PlazaDeAparcamiento[] plazas) {
        this.clientes = clientes;
        this.plazas = plazas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public PlazaDeAparcamiento[] getPlazas() {
        return plazas;
    }
}
