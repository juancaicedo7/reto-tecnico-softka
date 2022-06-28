package com.example.estacionespacial.naves;

import com.example.estacionespacial.interfaces.IAterrizaje;
import com.example.estacionespacial.interfaces.IVehiculoLanzadera;
import com.example.estacionespacial.models.CargaModel;
import com.example.estacionespacial.models.EnergiaModel;
import com.example.estacionespacial.models.OrigenModel;
import com.example.estacionespacial.models.TipoNaveModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VehiculoLanzadera extends Nave implements IVehiculoLanzadera, IAterrizaje {

    public VehiculoLanzadera(){

    }
    public VehiculoLanzadera(Integer id, String nombre, Float pesoNave, Float potencia, Float alturaNave, Float velocidad, String actividad, Boolean volando, TipoNaveModel tipoNave, OrigenModel origen, List<CargaModel> cargas, List<EnergiaModel> tiposDeEnergia, Integer capacidad) {
        super(id, nombre, pesoNave, potencia, alturaNave, velocidad, actividad, volando, tipoNave, origen, cargas, tiposDeEnergia);
        this.capacidad = capacidad;
    }

    private Integer capacidad;



    @Override
    public void despegar() {
        if(!getVolando()){
            System.out.println("Despegando vehiculo de lanzadera en: 10, 9, 8, 7,...");
            setVolando(true);
            desplazarse();
        }else{
            System.out.println("Este vehiculo ya se está desplazando");
        }
    }

    @Override
    public void desplazarse() {
        if(getVolando()){
            System.out.println("Este vehiculo de lanzadera se está desplazando a una velocidad de: " + getVelocidad());
        }else{
            System.out.println("Este vehiculo no se puede desplazar porque no ha despegado");
        }
    }

    @Override
    public void soltarCargaUtil() {
        if(getVolando()){
            System.out.println("Soltando carga de vehiculo de lanzadera en: 10, 9, 8, 7,..." + " se ha soltado: " + getCargas());
        }else{
            System.out.println("Este vehiculo no puede soltar su carga porque no ha despegado");
        }
    }

    @Override
    public void aterrizar() {
        if(getVolando()){
            System.out.println("Aterrizando vehiculo de lanzadera en: 10, 9, 8, 7,...");
            setVolando(false);
        }else{
            System.out.println("Este vehiculo no ha despegado");
        }
    }
}
