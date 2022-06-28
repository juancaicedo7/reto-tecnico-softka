package com.example.estacionespacial.naves;

import com.example.estacionespacial.models.CargaModel;
import com.example.estacionespacial.models.EnergiaModel;
import com.example.estacionespacial.models.OrigenModel;
import com.example.estacionespacial.models.TipoNaveModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class Nave {

    public Nave(){

    }
    public Nave(Integer id, String nombre, Float pesoNave, Float potencia, Float alturaNave, Float velocidad, String actividad, Boolean volando, TipoNaveModel tipoNave, OrigenModel origen, List<CargaModel> cargas, List<EnergiaModel> tiposDeEnergia) {
        this.id = id;
        this.nombre = nombre;
        this.pesoNave = pesoNave;
        this.potencia = potencia;
        this.alturaNave = alturaNave;
        this.velocidad = velocidad;
        this.actividad = actividad;
        this.volando = volando;
        this.tipoNave = tipoNave;
        this.origen = origen;
        this.cargas = cargas;
        this.tiposDeEnergia = tiposDeEnergia;
    }

    private Integer id;

    private String nombre;

    private Float pesoNave;

    private Float potencia;

    private Float alturaNave;

    private Float velocidad;

    private String actividad;

    private Boolean volando;
    private TipoNaveModel tipoNave;

    private OrigenModel origen;

    private List<CargaModel> cargas;

    private List<EnergiaModel> tiposDeEnergia;
}
