package com.example.Futbol.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Jugador")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador")
    private Long idJugador;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "posicion", length = 50)
    private String posicion;

    @Column(name = "dorsal")
    private Integer dorsal;    // número de camiseta

    @Column(name = "fecha_nac")
    private java.time.LocalDate fechaNac;

    @Column(name = "nacionalidad", length = 100)
    private String nacionalidad;

    // Relación: Muchos jugadores → Un equipo (FK id_equipo)
    @ManyToOne(fetch = FetchType.LAZY)  // LAZY: solo carga el equipo si se pide
    @JoinColumn(name = "id_equipo")     // columna FK en la tabla jugador
    private Equipo equipo;

}
