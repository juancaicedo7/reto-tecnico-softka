package com.example.estacionespacial.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Origen")
public class OrigenModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 15)
    @NonNull
    private String nombrePais;

    @OneToMany(mappedBy = "origenModel", fetch = FetchType.LAZY)
    private List<NaveModel> naveModels;
}