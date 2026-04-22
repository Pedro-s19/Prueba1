package com.example.Futbol.Service;

import com.example.Futbol.Model.Partido;

import java.util.List;

public interface PartidoService {

    List<Partido> obtenerPartido();
    Partido obtenerPartidoPorId(Long id);
    Partido guardarPartido(Partido partido);
    Partido actualizarPartido(Long id,Partido partido);
    void borrarPartido(Long id);
    Integer totalGolesByEquipo(Long idEquipo);
    List<Object[]>resuladoConNombres();
}
