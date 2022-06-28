package com.example.estacionespacial.models;


import com.example.estacionespacial.repositories.NaveRepository;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "Energia")
public class EnergiaModel {

    @Id
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 50)
    @NonNull
    private String nombreEnergia;

    @ManyToMany(mappedBy = "energiaModels", fetch = FetchType.LAZY)
    private List<NaveModel> naveModels;


}
