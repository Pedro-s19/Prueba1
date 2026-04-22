package com.example.Futbol.Service;

import com.example.Futbol.Model.Jugador;
import com.example.Futbol.Repository.JugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorServiceImp implements JugadorService {

    private final JugadorRepository jugadorRepository;


    public JugadorServiceImp(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }
    @Override
    public List<Jugador> obtenerJugadores(){
        return jugadorRepository.findAll();
    }
    @Override
    public Jugador obtenerJugadorPorId(Long id){
        return jugadorRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Jugador no encontrado" + id));
    }
    @Override
    public Jugador guardarJugador(Jugador j){
        return jugadorRepository.save(j);
    }
    @Override
    public Jugador actualizarJugador(Long id, Jugador j){
        j.setIdJugador(id);
        return jugadorRepository.save(j);
    }
    @Override
    public void eliminarJugador(Long id){
        jugadorRepository.deleteById(id);
    }
    @Override
    public List<Jugador> jugadoresPorEquipo(Long idEquipo){
        return jugadorRepository.findJugadoresByEquipo(idEquipo);
    }
    @Override
    public List<Jugador> jugadoresConMasDeXGoles(int minGoles){
        return jugadorRepository.findJugadoresConMasDeXGoles(minGoles);
    }
}
