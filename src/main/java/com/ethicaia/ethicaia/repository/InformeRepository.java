package com.ethicaia.ethicaia.repository;

import com.ethicaia.ethicaia.model.Informe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InformeRepository extends JpaRepository<Informe, Long> {

    // Buscar informes por ID de texto
    List<Informe> findByTextoId(Long textoId);

    // Buscar informes por palabra clave en resumen
    List<Informe> findByResumenContainingIgnoreCase(String palabraClave);

    // Informes más recientes primero
    @Query("SELECT i FROM Informe i ORDER BY i.fechaGeneracion DESC")
    List<Informe> listarInformesRecientes();
}
