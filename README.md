# Garaje Privado

Este proyecto es una aplicación de consola simple para gestionar un estacionamiento.

## Archivos de datos

Al iniciar la aplicación se cargan los datos de los clientes y tickets desde archivos CSV ubicados en `data/`:

- `data/clientes.csv`
- `data/tickets.csv`

Cada línea de `clientes.csv` sigue el formato:

```
Nombre,DNI,Telefono,MarcaVehiculo,PatenteVehiculo,TipoVehiculo
```

Para `tickets.csv` el formato es:

```
IdTicket,MarcaVehiculo,PatenteVehiculo,TipoVehiculo,NumeroPlaza,FechaIngreso,FechaSalida,Monto
```
`FechaSalida` puede estar vacío si el vehículo no registró salida.

Antes de cerrar la aplicación (opción "Salir"), la información actual se guarda nuevamente en estos archivos.

