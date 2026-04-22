package com.example.Futbol.Controller;


import com.example.Futbol.Model.EstadisticaJugador;
import com.example.Futbol.Service.EstadisticaJugadorService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticas jugadores")
public class EstadisticaJugadorController {

    private final EstadisticaJugadorService estadisticaJugadorService;

    public EstadisticaJugadorController(EstadisticaJugadorService estadisticaJugadorService) {
        this.estadisticaJugadorService = estadisticaJugadorService;
    }
    @GetMapping
    public ResponseEntity<List<EstadisticaJugador>> obtenerEstadisticasJugadores(){
        return ResponseEntity.ok(estadisticaJugadorService.obtenerEstadisticasJugadores());

    }
    @GetMapping("/{id}")
    public ResponseEntity<EstadisticaJugador> obtenerEstadisticaJugadorPorId(@PathVariable Long id){
        return ResponseEntity.ok(estadisticaJugadorService.obtenerEstadisticaJugadorPorId(id));

    }
    @PostMapping
    public ResponseEntity<EstadisticaJugador> guardarEstadisticaJugador(@RequestBody EstadisticaJugador e){
        return ResponseEntity.status(201).body(estadisticaJugadorService.guardarEstadisticaJugador(e));

    }
    @PostMapping("/{id}")
    public ResponseEntity<EstadisticaJugador> actualizarEstadisticaJugador(@PathVariable Long id,@RequestBody EstadisticaJugador e) {
        return ResponseEntity.ok(estadisticaJugadorService.actualizarEstadisticaJugador(id, e));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarEstadisticaJugador(@PathVariable Long id){
        estadisticaJugadorService.borrarEstadisticaJugador(id);
        return ResponseEntity.noContent().build();
    }
}
