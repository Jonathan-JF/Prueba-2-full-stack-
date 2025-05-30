package com.ethicaia.ethicaia.repository;

import com.ethicaia.ethicaia.model.OriginalidadResultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OriginalidadResultadoRepository extends JpaRepository<OriginalidadResultado, Long> {

       // Buscar por coincidencia de texto
    List<OriginalidadResultado> findByTextoContainingIgnoreCase(String texto);

    // Buscar los resultados con mayor nivel de plagio
    List<OriginalidadResultado> findByPorcentajePlagioGreaterThan(double porcentaje);

    // Consulta personalizada con @Query (JPQL)
    @Query("SELECT o FROM OriginalidadResultado o WHERE o.porcentajePlagio >= :limite AND o.texto LIKE %:palabra%")
    List<OriginalidadResultado> buscarPorPlagioYTexto(@Param("limite") double limite, @Param("palabra") String palabra);
}


