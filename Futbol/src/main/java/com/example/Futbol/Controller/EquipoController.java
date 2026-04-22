package com.example.Futbol.Controller;

import com.example.Futbol.Model.Equipo;
import com.example.Futbol.Service.EquipoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    private final EquipoService equipoService;


    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping
    public ResponseEntity<List<Equipo>> obtenerEquipos(){
        return ResponseEntity.ok(equipoService.obtenerEquipos());

    }
    @GetMapping("/{id}")
    public ResponseEntity<Equipo> obtenerEquipoById(@PathVariable  Long id){
       return ResponseEntity.ok(equipoService.obtenerEquipoById(id));
    }
    @PostMapping
    public ResponseEntity<Equipo> guardarEquipo(@PathVariable Equipo equipo){
        Equipo nuevo = equipoService.guardarEquipo(equipo);
        return ResponseEntity.status(201).body(nuevo);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Equipo> actualizarEquipo(@PathVariable Long id, @RequestBody Equipo equipo){
        return ResponseEntity.ok(equipoService.actualizarEquipo(id, equipo));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEquipo(@PathVariable Long id){
        equipoService.eliminarEquipo(id);
        return ResponseEntity.noContent().build();

    }
}
