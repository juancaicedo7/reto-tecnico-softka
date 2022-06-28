package com.example.estacionespacial.repositories;

import com.example.estacionespacial.models.NaveModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NaveRepository extends JpaRepository<NaveModel, Integer> {
    Iterable<NaveModel> findByTipoNaveId(Integer tipoNaveId);
}
