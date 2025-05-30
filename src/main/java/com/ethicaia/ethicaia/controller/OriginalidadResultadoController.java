package com.ethicaia.ethicaia.controller;

import com.ethicaia.ethicaia.model.OriginalidadResultado;
import com.ethicaia.ethicaia.service.OriginalidadResultadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/originalidad")
public class OriginalidadResultadoController {

    private final OriginalidadResultadoService service;

    public OriginalidadResultadoController(OriginalidadResultadoService service) {
        this.service = service;
    }

    // 📄 Listar todos
    @GetMapping
    public ResponseEntity<List<OriginalidadResultado>> listar() {
        return ResponseEntity.ok(service.findAll());
    }

    // 🔍 Buscar por texto
    @GetMapping("/buscar")
    public ResponseEntity<List<OriginalidadResultado>> buscarPorTexto(@RequestParam String texto) {
        return ResponseEntity.ok(service.findByTexto(texto));
    }

    // ⚠️ Buscar por porcentaje de plagio mayor a
    @GetMapping("/plagio")
    public ResponseEntity<List<OriginalidadResultado>> buscarPorPlagio(@RequestParam double min) {
        return ResponseEntity.ok(service.findByPlagioMayorA(min));
    }

    // 🧠 Buscar por plagio y palabra
    @GetMapping("/filtrado")
    public ResponseEntity<List<OriginalidadResultado>> buscarAvanzado(
            @RequestParam double limite,
            @RequestParam String palabra) {
        return ResponseEntity.ok(service.buscarPorPlagioYTexto(limite, palabra));
    }

    // ➕ Crear nuevo
    @PostMapping
    public ResponseEntity<OriginalidadResultado> crear(@RequestBody OriginalidadResultado resultado) {
        return ResponseEntity.ok(service.save(resultado));
    }

    // 📝 Actualizar por ID
    @PutMapping("/{id}")
    public ResponseEntity<OriginalidadResultado> actualizar(
            @PathVariable Long id,
            @RequestBody OriginalidadResultado actualizado) {
        return service.findById(id)
                .map(r -> {
                    actualizado.setId(id);
                    return ResponseEntity.ok(service.save(actualizado));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // ❌ Eliminar por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (service.deleteById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
