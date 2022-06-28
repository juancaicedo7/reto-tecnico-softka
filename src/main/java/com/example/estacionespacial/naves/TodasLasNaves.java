package com.example.estacionespacial.naves;

import lombok.Getter;

@Getter
public class TodasLasNaves {

    public TodasLasNaves(Iterable<VehiculoLanzadera> vehiculosLanzadera, Iterable<VehiculoNoTripulado> vehiculosNoTripulados, Iterable<VehiculoTripulado> vehiculosTripulados) {
        this.vehiculosLanzadera = vehiculosLanzadera;
        this.vehiculosNoTripulados = vehiculosNoTripulados;
        this.vehiculosTripulados = vehiculosTripulados;
    }

    Iterable<VehiculoLanzadera> vehiculosLanzadera;
    Iterable<VehiculoNoTripulado> vehiculosNoTripulados;
    Iterable<VehiculoTripulado> vehiculosTripulados;
}
