package com.example.estacionespacial.services;

import com.example.estacionespacial.models.OrigenModel;
import com.example.estacionespacial.repositories.OrigenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrigenService {

    @Autowired
    OrigenRepository origenRepository;

    public Iterable<OrigenModel> obtenerOrigenes(){
        return origenRepository.findAll();
    }
}
