package com.example.Futbol.Service;

import com.example.Futbol.Model.Entrenador;

import java.util.List;

public interface EntrenadorService {

    List<Entrenador> obtenerEntrenadores();
    Entrenador obtenerEntrenadorPorId(Long id);
    Entrenador guardarEntrenador(Entrenador entrenador);
    Entrenador actualizarEntrenador(Long id,Entrenador entrenador);
    void borrarEntrenador(Long id);
}
