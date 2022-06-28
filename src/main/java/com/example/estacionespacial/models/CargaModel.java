package com.example.estacionespacial.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Carga")
public class    CargaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 15)
    @NonNull
    private String nombreCarga;

    @ManyToMany(mappedBy = "cargaModels", fetch = FetchType.LAZY)
    private List<NaveModel> naveModel;
}
