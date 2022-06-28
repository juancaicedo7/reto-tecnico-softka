package com.example.estacionespacial.services;

import com.example.estacionespacial.models.TipoNaveModel;
import com.example.estacionespacial.repositories.TipoNaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoNaveService {

    @Autowired
    TipoNaveRepository tipoNaveRepository;


    public Iterable<TipoNaveModel> obtenerTiposDeNaves(){
        return  tipoNaveRepository.findAll();
    }
}
