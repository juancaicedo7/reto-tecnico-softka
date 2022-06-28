package com.example.estacionespacial.models;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Tipo_Nave")
public class TipoNaveModel {

    @Id
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 50)
    @NonNull
    private String nombre;

    @OneToMany(mappedBy = "tipoNave", fetch = FetchType.LAZY)
    private List<NaveModel> naveModels;
}
