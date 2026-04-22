package com.example.Futbol.Service;

import com.example.Futbol.Model.EstadisticaJugador;

import java.util.List;

public interface EstadisticaJugadorService {

    List<EstadisticaJugador> obtenerEstadisticasJugadores();
    EstadisticaJugador obtenerEstadisticaJugadorPorId(Long id);
    EstadisticaJugador guardarEstadisticaJugador(EstadisticaJugador estadisticaJugador);
    EstadisticaJugador actualizarEstadisticaJugador(Long id, EstadisticaJugador estadisticaJugador);
    void borrarEstadisticaJugador(Long id);
}
