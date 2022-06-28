package com.example.estacionespacial.repositories;

import com.example.estacionespacial.models.TipoNaveModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoNaveRepository extends CrudRepository<TipoNaveModel, Integer> {


}
