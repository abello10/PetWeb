package com.petweb.petweb.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bodega")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Bodega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50,   nullable = false)
    private String nombre_bodega;

    @Column(length = 50, nullable = false)
    private String direccion_bodega;

    @Column(length = 15, nullable = false)
    private Integer telefono_bodega;

    @Column(unique = true, length = 60, nullable = false)
    private String correo_bodega;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "comuna_id", nullable = false)
    private Comuna comuna;

    @JsonManagedReference
    @OneToMany
    @JoinColumn(name = "existencia_id", nullable = false)
    private List<Existencias> existencias;


}
