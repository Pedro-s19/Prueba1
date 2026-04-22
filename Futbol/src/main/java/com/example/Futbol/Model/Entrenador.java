package com.example.Futbol.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Entrenador")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Entrenador {

    @Id
    @GeneratedValue
    @Column(name = "id_entrenador")
    private Long idEntrenador;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "especialidad", length = 100)
    private String especialidad;

    // FK al equipo
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;



}
