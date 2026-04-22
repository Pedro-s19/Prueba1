package com.example.Futbol.Controller;

import com.example.Futbol.Model.Partido;
import com.example.Futbol.Service.PartidoService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidos")
public class PartidoController {

    private final PartidoService partidoService;
    public PartidoController(PartidoService partidoService) {
        this.partidoService = partidoService;
    }
    @GetMapping
    public ResponseEntity<List<Partido>> obtenerPartido(){
        return ResponseEntity.ok(partidoService.obtenerPartido());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Partido> obtenerPartidoPorId(@PathVariable Long id){
        return ResponseEntity.ok(partidoService.obtenerPartidoPorId(id));
    }
    @PostMapping
    public ResponseEntity<Partido> guardarPartido(@RequestBody Partido p){
        return ResponseEntity.status(201).body(partidoService.guardarPartido(p));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Partido> actualizarPartido(@PathVariable Long id,@RequestBody Partido p){
        return ResponseEntity.ok(partidoService.actualizarPartido(id,p));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarPartido(@PathVariable Long id){
        partidoService.borrarPartido(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/goles-equipo/{idEquipo}")
    public ResponseEntity<Integer> totalGolesByEquipo(@PathVariable Long idEquipo){
        return ResponseEntity.ok(partidoService.totalGolesByEquipo(idEquipo));
    }
    @GetMapping("/resultados")
    public ResponseEntity<List<Object[]>>resuladoConNombres(){
        return ResponseEntity.ok(partidoService.resuladoConNombres());
    }
}
