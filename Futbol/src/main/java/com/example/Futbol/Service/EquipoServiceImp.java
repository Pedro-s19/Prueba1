package com.example.Futbol.Service;

import com.example.Futbol.Model.Equipo;
import com.example.Futbol.Repository.EquipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoServiceImp implements EquipoService {

    private final EquipoRepository equipoRepository;

    public EquipoServiceImp(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @Override
    public List<Equipo> obtenerEquipos() {
        return equipoRepository.findAll();
    }

    @Override
    public Equipo obtenerEquipoById(Long id)
    {
        return equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado con id: "+ id));
    }
    @Override
    public Equipo guardarEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }
    @Override
    public  Equipo actualizarEquipo(Long id,Equipo equipo){
        equipo.setIdEquipo(id);
        return equipoRepository.save(equipo);
    }
    @Override
    public void   eliminarEquipo(Long id) {
        equipoRepository.deleteById(id);
    }


}
