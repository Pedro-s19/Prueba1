package com.example.Futbol.Repository;

import com.example.Futbol.Model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido,Long> {
    // ── CONSULTA NATIVA 3 ─────────────────────────────────────────────────────
    // Obtener el total de goles de un equipo en todos sus partidos
    // (sumando goles_local cuando fue local + goles_visita cuando fue visitante)
    // COALESCE evita nulls → si no hay partidos regresa 0

    @Query(
            value = """
               SELECT COALESCE(
                    (SELECT SUM(goles_local) FROM partido WHERE equipo_local = :idEquipo)
                    + (SELECT SUM(goles_visita)FROM partido WHERE equipo_visita = :idEquipo),
                    0),
                    """,
            nativeQuery = true
    )
    Integer totalGolesByEquipo(@Param("idEquipo") Long idEquipo);
    // ── CONSULTA NATIVA 4 ─────────────────────────────────────────────────────
    // Obtener resultados de todos los partidos con los NOMBRES de los equipos
    // Se hace doble JOIN a la tabla equipo con alias distintos (el=local, ev=visitante)
    // Retorna List<Object[]> → cada Object[] es una fila con las columnas del SELECT

    @Query(
            value = """
                  SELECT
                      p.id_partido,
                      p.fecha,
                      p.estadio,
                      el.nombre AS equipo_local,
                      ev.nombre AS equipo_visita,
                      p.goles_local,
                      p.goles_visita
                  FROM partido p
                  INNER JOIN equipo el ON p.equipo_local = el.id_equipo
                  INNER JOIN equipo ev ON p.equipo_visita = ev.id_equipo
                  ORDER BY p.fecha DESC
                  """,
            nativeQuery = true
    )
    List<Object[]>findResultadosConNombres();
}
