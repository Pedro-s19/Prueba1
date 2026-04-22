package com.example.Futbol.Service;

import com.example.Futbol.Model.Jugador;

import java.util.List;

public interface JugadorService {

    List<Jugador> obtenerJugadores();
    Jugador obtenerJugadorPorId(Long id);
    Jugador guardarJugador(Jugador jugador);
    Jugador actualizarJugador(Long id, Jugador jugador);
    void eliminarJugador(Long id);
    List<Jugador> jugadoresPorEquipo(Long idEquipo);
    List<Jugador> jugadoresConMasDeXGoles(int minGoles);
}
