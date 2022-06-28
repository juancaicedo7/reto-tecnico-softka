package com.example.estacionespacial.enums;

import java.util.Arrays;
import java.util.Optional;

public enum TipoNaveEnum {
    VehiculoLanzadera(1),
    VehiculoNoTripulado(2),
    VehiculoTripulado(3);

    private int value;
    private TipoNaveEnum(int value) {
        this.value = value;
    }


    public static TipoNaveEnum valueOf(int value) {
        return Arrays.stream(values())
                .filter(t -> t.value == value)
                .findFirst().get();
    }
    public int getValue() {
        return value;
    }
}
