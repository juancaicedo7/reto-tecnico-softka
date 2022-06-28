package com.example.estacionespacial.models;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Nave")
public class NaveModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 4328920387754129293L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(name = "Nombre", length = 15)
    @NonNull
    private String nombre;

    @NonNull
    private Float pesoNave;

    @NonNull
    private Float potencia;

    @NonNull
    private Float alturaNave;

    @NonNull
    private Float velocidad;


    private Integer capacidad;

    @Column(name = "Actividad")
    @NonNull
    private String actividad;

    @NonNull
    private Boolean volando;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_nave_id", nullable = false)
    private TipoNaveModel tipoNave;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "origen_id", nullable = false)
    private OrigenModel origenModel;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "nave_carga",
            joinColumns = @JoinColumn(name = "nave_id"),
            inverseJoinColumns = @JoinColumn(name = "carga_id"))
    private List<CargaModel> cargaModels;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "nave_energia",
            joinColumns = @JoinColumn(name = "nave_id"),
            inverseJoinColumns = @JoinColumn(name = "energia_id"))
    private List<EnergiaModel> energiaModels;
}
