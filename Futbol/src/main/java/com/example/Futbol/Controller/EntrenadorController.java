package com.example.Futbol.Controller;

import com.example.Futbol.Model.Entrenador;
import com.example.Futbol.Model.Equipo;
import com.example.Futbol.Service.EntrenadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @GetMapping
    public ResponseEntity<List<Entrenador>> obtenerEntrenadores() {
        return ResponseEntity.ok(entrenadorService.obtenerEntrenadores());

    }
    @GetMapping("/{id}")
    public ResponseEntity<Entrenador>obtenerEntrenadorPorId(@PathVariable Long id){
        return ResponseEntity.ok(entrenadorService.obtenerEntrenadorPorId(id));
    }
    @PostMapping
    public ResponseEntity<Entrenador> guardarEntrenador(@PathVariable Entrenador e){
        Entrenador nuevo = entrenadorService.guardarEntrenador(e);
        return ResponseEntity.status(201).body(nuevo);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> actualizarEntrenador(@PathVariable Long id, @RequestBody Entrenador e){
        return ResponseEntity.ok(entrenadorService.actualizarEntrenador(id, e));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEntrenador(@PathVariable Long id){
        entrenadorService.borrarEntrenador(id);
        return ResponseEntity.noContent().build();

    }
}
