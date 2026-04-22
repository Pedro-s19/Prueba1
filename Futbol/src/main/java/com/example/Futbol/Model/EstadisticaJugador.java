package com.example.Futbol.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estadistica_Jugador")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstadisticaJugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadistica")
    private Long idEstadistica;

    // FK al jugador
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jugador")
    private Jugador jugador;

    // FK al partido
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_partido")
    private Partido partido;

    @Column(name = "minutos_jugados")
    private Integer minutosJugados;

    @Column(name = "goles")
    private Integer goles;

    @Column(name = "asistencias")
    private Integer asistencias;

    @Column(name = "tarjetas_amarillas")
    private Integer tarjetasAmarillas;

    @Column(name = "tarjetas_rojas")
    private Integer tarjetasRojas;


}
