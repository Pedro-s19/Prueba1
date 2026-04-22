package com.example.Futbol.Repository;

import com.example.Futbol.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    // ── CONSULTA NATIVA 1 ─────────────────────────────────────────────────────
    // Obtener todos los jugadores de un equipo específico por su ID
    // nativeQuery=true → se ejecuta SQL puro, no JPQL
    // :idEquipo → parámetro nombrado, viene del @Param("idEquipo")
    @Query(
            value = "SELECT * FROM jugador WHERE id_equipo = :idEquipo",
            nativeQuery = true
    )
    List<Jugador> findJugadoresByEquipo(@Param("idEquipo") Long idEquipo);

    // ── CONSULTA NATIVA 2 ─────────────────────────────────────────────────────
    // Obtener jugadores que han marcado más de X goles (sumando todas sus estadísticas)
    // Se hace un JOIN con estadistica_jugador y se agrupa por jugador
    // HAVING SUM(goles) > :minGoles filtra los que superan el umbral
    @Query(
            value = """ 
                SELECT j.*
                FROM jugador j
                INNER JOIN estadistica_jugador ej ON j.id_jugador = ej.id_jugador
                GROUP BY j.id_jugador
                HAVING SUM(ej.goles) > :minGoles
                """,
            nativeQuery = true
    )
    List<Jugador>findJugadoresConMasDeXGoles(@Param("minGoles") int minGoles);
}
