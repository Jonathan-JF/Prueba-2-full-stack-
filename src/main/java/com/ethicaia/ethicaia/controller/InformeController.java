package com.ethicaia.ethicaia.controller;

import com.ethicaia.ethicaia.model.Informe;
import com.ethicaia.ethicaia.service.InformeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/informes")
public class InformeController {

    private final InformeService service;

    public InformeController(InformeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Informe>> listar() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Informe> obtenerPorId(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/texto/{textoId}")
    public ResponseEntity<List<Informe>> listarPorTexto(@PathVariable Long textoId) {
        return ResponseEntity.ok(service.findByTextoId(textoId));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Informe>> buscarPorResumen(@RequestParam String palabra) {
        return ResponseEntity.ok(service.buscarPorResumen(palabra));
    }

    @GetMapping("/recientes")
    public ResponseEntity<List<Informe>> recientes() {
        return ResponseEntity.ok(service.listarRecientes());
    }

    @PostMapping
    public ResponseEntity<Informe> crear(@RequestBody Informe informe) {
        return ResponseEntity.ok(service.save(informe));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Informe> actualizar(@PathVariable Long id, @RequestBody Informe actualizado) {
        return service.findById(id)
                .map(i -> {
                    actualizado.setId(id);
                    return ResponseEntity.ok(service.save(actualizado));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return service.deleteById(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}