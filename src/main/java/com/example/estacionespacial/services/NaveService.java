package com.example.estacionespacial.services;

import com.example.estacionespacial.enums.TipoNaveEnum;
import com.example.estacionespacial.models.*;
import com.example.estacionespacial.naves.*;
import com.example.estacionespacial.repositories.NaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class NaveService {

    @Autowired
    NaveRepository naveRepository;

    public TipoNaveEnum obtenerTipoNaveEnum(int id){return  TipoNaveEnum.valueOf(id);
    }

    @Transactional
    public Nave obtenerNave(Integer id){
        Nave nave = null;
        Optional<NaveModel> optionalModel = naveRepository.findById(id);
        if(optionalModel.isPresent()){
            NaveModel model = optionalModel.get();
            TipoNaveEnum tipoNaveEnum = obtenerTipoNaveEnum(model.getTipoNave().getId());
            switch (tipoNaveEnum) {
                case  VehiculoLanzadera:
                    nave = new VehiculoLanzadera(model.getId(), model.getNombre(), model.getPesoNave(),
                            model.getPotencia(), model.getAlturaNave(), model.getVelocidad(), model.getActividad(), model.getVolando(), model.getTipoNave(),
                            model.getOrigenModel(), model.getCargaModels(), model.getEnergiaModels(), model.getCapacidad());
                    break;

                case  VehiculoNoTripulado:
                    nave = new VehiculoNoTripulado(model.getId(), model.getNombre(), model.getPesoNave(),
                            model.getPotencia(), model.getAlturaNave(), model.getVelocidad(), model.getActividad(), model.getVolando(), model.getTipoNave(),
                            model.getOrigenModel(), model.getCargaModels(), model.getEnergiaModels());
                    break;

                case  VehiculoTripulado:
                    nave = new VehiculoTripulado(model.getId(), model.getNombre(), model.getPesoNave(),
                            model.getPotencia(), model.getAlturaNave(), model.getVelocidad(), model.getActividad(), model.getVolando(), model.getTipoNave(),
                            model.getOrigenModel(), model.getCargaModels(), model.getEnergiaModels());
                    break;
            }
        }

        return  nave;
    }

    @Transactional()
    public void guardarNave(Nave nave) {

        NaveModel model = new NaveModel();

        model.setId(nave.getId());
        model.setNombre(nave.getNombre());
        model.setPesoNave(nave.getPesoNave());
        model.setPotencia(nave.getPotencia());
        model.setAlturaNave(nave.getAlturaNave());
        model.setVelocidad(nave.getVelocidad());
        model.setActividad(nave.getActividad());
        model.setVolando(nave.getVolando());
        model.setTipoNave(nave.getTipoNave());
        model.setOrigenModel(nave.getOrigen());
        model.setCargaModels(nave.getCargas());
        model.setEnergiaModels(nave.getTiposDeEnergia());
        if(nave instanceof VehiculoLanzadera){
            model.setCapacidad(((VehiculoLanzadera) nave).getCapacidad());
        }

        naveRepository.save(model);
    }


    @Transactional
    public List<VehiculoLanzadera> obtenerVehiculosLanzadera(){
        Iterable<NaveModel> naves = naveRepository.findByTipoNaveId(TipoNaveEnum.VehiculoLanzadera.getValue());

        List<VehiculoLanzadera> vehiculosLanzadera = ((ArrayList<NaveModel>)naves).stream().map(v -> new VehiculoLanzadera(v.getId(), v.getNombre(), v.getPesoNave(),
                v.getPotencia(), v.getAlturaNave(), v.getVelocidad(), v.getActividad(), v.getVolando(), v.getTipoNave(), v.getOrigenModel(), v.getCargaModels(), v.getEnergiaModels(), v.getCapacidad()))
                .collect(Collectors.toList());

        return  vehiculosLanzadera;
    }

    @Transactional
    public List<VehiculoNoTripulado> obtenerVehiculosNoTripulados(){
        Iterable<NaveModel> naves = naveRepository.findByTipoNaveId(TipoNaveEnum.VehiculoNoTripulado.getValue());

        List<VehiculoNoTripulado> vehiculosNoTripulados = ((ArrayList<NaveModel>)naves).stream().map(v -> new VehiculoNoTripulado(v.getId(), v.getNombre(), v.getPesoNave(),
                v.getPotencia(), v.getAlturaNave(), v.getVelocidad(), v.getActividad(), v.getVolando(), v.getTipoNave(), v.getOrigenModel(), v.getCargaModels(), v.getEnergiaModels()))
                .collect(Collectors.toList());

        return  vehiculosNoTripulados;
    }

    @Transactional
    public List<VehiculoTripulado> obtenerVehiculosTripulados(){
        Iterable<NaveModel> naves = naveRepository.findByTipoNaveId(TipoNaveEnum.VehiculoTripulado.getValue());

        List<VehiculoTripulado> vehiculoTripulados = ((ArrayList<NaveModel>)naves).stream().map(v -> new VehiculoTripulado(v.getId(), v.getNombre(), v.getPesoNave(),
                v.getPotencia(), v.getAlturaNave(), v.getVelocidad(), v.getActividad(), v.getVolando(), v.getTipoNave(), v.getOrigenModel(), v.getCargaModels(), v.getEnergiaModels()))
                .collect(Collectors.toList());

        return  vehiculoTripulados;
    }

    public TodasLasNaves obtenerTodasLasNaves(){
        List<VehiculoLanzadera> vehiculosLanzadera = obtenerVehiculosLanzadera();
        List<VehiculoNoTripulado> vehiculosNoTripulados = obtenerVehiculosNoTripulados();
        List<VehiculoTripulado> vehiculoTripulados = obtenerVehiculosTripulados();

        return new TodasLasNaves(vehiculosLanzadera, vehiculosNoTripulados, vehiculoTripulados);
    }
}
