package com.ethicaia.ethicaia.service;

import com.ethicaia.ethicaia.model.Informe;
import com.ethicaia.ethicaia.repository.InformeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InformeService {

    private final InformeRepository repository;

    public InformeService(InformeRepository repository) {
        this.repository = repository;
    }

    public List<Informe> findAll() {
        return repository.findAll();
    }

    public Optional<Informe> findById(Long id) {
        return repository.findById(id);
    }

    public List<Informe> findByTextoId(Long textoId) {
        return repository.findByTextoId(textoId);
    }

    public List<Informe> buscarPorResumen(String palabra) {
        return repository.findByResumenContainingIgnoreCase(palabra);
    }

    public List<Informe> listarRecientes() {
        return repository.listarInformesRecientes();
    }

    public Informe save(Informe informe) {
        return repository.save(informe);
    }

    public boolean deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
