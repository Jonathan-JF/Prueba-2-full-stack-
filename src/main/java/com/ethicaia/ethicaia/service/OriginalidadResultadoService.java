package com.ethicaia.ethicaia.service;

import com.ethicaia.ethicaia.model.OriginalidadResultado;
import com.ethicaia.ethicaia.repository.OriginalidadResultadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OriginalidadResultadoService {

    private final OriginalidadResultadoRepository repository;

    @Autowired
    public OriginalidadResultadoService(OriginalidadResultadoRepository repository) {
        this.repository = repository;
    }

    public List<OriginalidadResultado> findAll() {
        return repository.findAll();
    }

    public Optional<OriginalidadResultado> findById(Long id) {
        return repository.findById(id);
    }

    public List<OriginalidadResultado> findByTexto(String texto) {
        return repository.findByTextoContainingIgnoreCase(texto);
    }

    public List<OriginalidadResultado> findByPlagioMayorA(double porcentaje) {
        return repository.findByPorcentajePlagioGreaterThan(porcentaje);
    }

    public List<OriginalidadResultado> buscarPorPlagioYTexto(double limite, String palabra) {
        return repository.buscarPorPlagioYTexto(limite, palabra);
    }

    public OriginalidadResultado save(OriginalidadResultado resultado) {
        return repository.save(resultado);
    }

    public boolean deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}