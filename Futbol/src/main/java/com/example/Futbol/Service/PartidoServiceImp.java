package com.example.Futbol.Service;

import com.example.Futbol.Dto.ResultadoPartidoDTO;
import com.example.Futbol.Model.Partido;
import com.example.Futbol.Repository.PartidoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<ResultadoPartidoDTO> resuladoConNombres() {
        List<Object[]> rows = partidoRepository.findResultadosConNombres();
        return rows.stream().map(row -> {
            LocalDate fecha = null;
            if (row[1] != null) {
                if (row[1] instanceof java.sql.Date) {
                    fecha = ((java.sql.Date) row[1]).toLocalDate();
                } else if (row[1] instanceof LocalDate) {
                    fecha = (LocalDate) row[1];
                }
            }
            return new ResultadoPartidoDTO(
                    ((Number) row[0]).longValue(),
                    fecha,
                    (String) row[2],
                    (String) row[3],
                    (String) row[4],
                    row[5] != null ? ((Number) row[5]).intValue() : null,
                    row[6] != null ? ((Number) row[6]).intValue() : null
            );
        }).collect(Collectors.toList());
    }
}
