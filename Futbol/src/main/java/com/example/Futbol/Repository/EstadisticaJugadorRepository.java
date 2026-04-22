package com.example.Futbol.Repository;

import com.example.Futbol.Model.EstadisticaJugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticaJugadorRepository extends JpaRepository<EstadisticaJugador, Long> {
}
