package com.example.Futbol.Service;

import com.example.Futbol.Model.EstadisticaJugador;
import com.example.Futbol.Repository.EstadisticaJugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstadisticaJugadorServiceImp implements  EstadisticaJugadorService {

    private final EstadisticaJugadorRepository estadisticaJugadorRepository;

    public EstadisticaJugadorServiceImp(EstadisticaJugadorRepository estadisticaJugadorRepository) {
        this.estadisticaJugadorRepository = estadisticaJugadorRepository;
    }
    @Override
    public List<EstadisticaJugador> obtenerEstadisticasJugadores(){
        return estadisticaJugadorRepository.findAll();
    }
    @Override
    public EstadisticaJugador obtenerEstadisticaJugadorPorId(Long id){
        return estadisticaJugadorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("EstadisticaJugador no encontrado"+ id));
    }
    @Override
    public EstadisticaJugador guardarEstadisticaJugador(EstadisticaJugador e){
        return estadisticaJugadorRepository.save(e);
    }
    @Override
    public EstadisticaJugador actualizarEstadisticaJugador(Long id, EstadisticaJugador e){
        e.setIdEstadistica(id);
        return estadisticaJugadorRepository.save(e);
    }
    @Override
    public void borrarEstadisticaJugador(Long id){
        estadisticaJugadorRepository.deleteById(id);
    }
}
