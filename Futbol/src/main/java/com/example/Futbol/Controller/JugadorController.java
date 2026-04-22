package com.example.Futbol.Controller;

import com.example.Futbol.Model.Jugador;
import com.example.Futbol.Service.JugadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    private final  JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @GetMapping
    public ResponseEntity<List<Jugador>> obtenerJugadores() {
        return ResponseEntity.ok(jugadorService.obtenerJugadores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> obtenerJugadorPorId(@PathVariable Long id) {
        return ResponseEntity.ok(jugadorService.obtenerJugadorPorId(id));
    }

    @PostMapping
    public ResponseEntity<Jugador> guardarJugador(@RequestBody Jugador j) {
        return ResponseEntity.status(201).body(jugadorService.guardarJugador(j));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> actualizarJugador(@PathVariable Long id, @RequestBody Jugador j) {
        return ResponseEntity.ok(jugadorService.actualizarJugador(id, j));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarJugador(@PathVariable Long id) {
        jugadorService.eliminarJugador(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/equipo/{idEquipo}")
    public ResponseEntity<List<Jugador>> jugadoresPorEquipo(@PathVariable Long idEquipo) {
        return ResponseEntity.ok(jugadorService.jugadoresPorEquipo(idEquipo));
    }
    @GetMapping("/goleadores")
    public ResponseEntity<List<Jugador>> goleadores(
            @RequestParam(defaultValue = "0") int minGoles) { // @RequestParam → parámetro de query (?minGoles=...)
        return ResponseEntity.ok(jugadorService.jugadoresConMasDeXGoles(minGoles));
    }
}
