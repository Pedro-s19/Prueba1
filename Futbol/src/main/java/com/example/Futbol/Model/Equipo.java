package com.example.Futbol.Model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.LocalDate;

@Entity
@Table(name = "Equipo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo")
    private Long idEquipo;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "ciudad", length = 100)
    private String ciudad;

    @Column(name = "fundacion")
    private java.time.LocalDate fundacion;

}
