package com.example.estacionespacial.naves;

import com.example.estacionespacial.interfaces.INave;
import com.example.estacionespacial.models.CargaModel;
import com.example.estacionespacial.models.EnergiaModel;
import com.example.estacionespacial.models.OrigenModel;
import com.example.estacionespacial.models.TipoNaveModel;

import java.util.List;

public class VehiculoNoTripulado extends Nave implements INave {

    public VehiculoNoTripulado(){

    }

    public VehiculoNoTripulado(Integer id, String nombre, Float pesoNave, Float potencia, Float alturaNave, Float velocidad, String actividad, Boolean volando, TipoNaveModel tipoNave, OrigenModel origen, List<CargaModel> cargas, List<EnergiaModel> tiposDeEnergia) {
        super(id, nombre, pesoNave, potencia, alturaNave, velocidad, actividad, volando, tipoNave, origen, cargas, tiposDeEnergia);
    }

    @Override
    public void despegar() {
        if(!getVolando()){
            System.out.println("Despegando vehiculo no tripulado en: 10, 9, 8, 7,...");
            setVolando(true);
            desplazarse();
        }else{
            System.out.println("Este vehiculo ya se está desplazando");
        }
    }

    @Override
    public void desplazarse() {
        if(getVolando()){
            System.out.println("Este vehiculo no tripulado se está desplazando a una velocidad de: " + getVelocidad());
        }else{
            System.out.println("Este vehiculo no se puede desplazar porque no ha despegado");
        }
    }
}
