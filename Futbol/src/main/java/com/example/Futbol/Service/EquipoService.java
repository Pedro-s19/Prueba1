package com.example.Futbol.Service;

import com.example.Futbol.Model.Equipo;
import org.springframework.stereotype.Service;

import java.util.List;
public interface EquipoService {

    List<Equipo> obtenerEquipos();
    Equipo obtenerEquipoById(Long id);
    Equipo guardarEquipo(Equipo equipo);
    Equipo actualizarEquipo(Long id,Equipo equipo);
    void eliminarEquipo(Long id);


}
