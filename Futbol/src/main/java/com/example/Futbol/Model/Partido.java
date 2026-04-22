package com.example.Futbol.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Partido")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_partido")
    private Long idPartido;

    @Column(name = "fecha")
    private java.time.LocalDate fecha;

    @Column(name = "estadio", length = 100)
    private String estadio;

    // Dos FK al mismo equipo (local y visitante) → se diferencian con @JoinColumn distinto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_local")    // FK → equipo.id_equipo
    private Equipo equipoLocal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_visita")   // Segunda FK → equipo.id_equipo
    private Equipo equipoVisita;

    @Column(name = "goles_local")
    private Integer golesLocal;

    @Column(name = "goles_visita")
    private Integer golesVisita;


}
