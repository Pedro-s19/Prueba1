package com.example.Futbol.Service;

import com.example.Futbol.Model.Entrenador;
import com.example.Futbol.Repository.EntrenadorRepository;

import java.util.List;

public class EntrenadorServiceImp implements EntrenadorService {

    private final EntrenadorRepository entrenadorRepository;

    public EntrenadorServiceImp(EntrenadorRepository entrenadorRepository) {
        this.entrenadorRepository = entrenadorRepository;
    }

    @Override
    public List<Entrenador> obtenerEntrenadores(){
        return entrenadorRepository.findAll();
    }
    @Override
    public Entrenador obtenerEntrenadorPorId(Long id){
        return  entrenadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado" + id));

    }
    @Override
    public Entrenador guardarEntrenador(Entrenador e){
        return entrenadorRepository.save(e);
    }
    @Override
    public Entrenador actualizarEntrenador(Long id,Entrenador e){
        e.setIdEntrenador(id);
        return entrenadorRepository.save(e);
    }
    @Override
    public void borrarEntrenador(Long id){
        entrenadorRepository.deleteById(id);
    }
}
