package com.example.Futbol.Service;

import com.example.Futbol.Model.Partido;
import com.example.Futbol.Repository.PartidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoServiceImp implements  PartidoService {

    private final PartidoRepository partidoRepository;

    public PartidoServiceImp(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    @Override
    public List<Partido> obtenerPartido(){
        return partidoRepository.findAll();
    }
    @Override
    public Partido obtenerPartidoPorId(Long id){
        return partidoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No existe el partido por ID: "+ id));
    }
    @Override
    public Partido guardarPartido(Partido p){
        return partidoRepository.save(p);
    }
    @Override
    public Partido actualizarPartido(Long id,Partido p){
        p.setIdPartido(id);
        return partidoRepository.save(p);
    }
    @Override
    public void borrarPartido(Long id){
        partidoRepository.deleteById(id);
    }
    @Override
    public Integer totalGolesByEquipo(Long idEquipo){
        return partidoRepository.totalGolesByEquipo(idEquipo);
    }
    @Override
    public List<Object[]>resuladoConNombres(){
        return partidoRepository.findResultadosConNombres();
    }
}
