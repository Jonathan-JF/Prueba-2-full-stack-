package com.ethicaia.ethicaia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "coherencia_resultado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoherenciaResultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, length = 13,nullable = false)
    private String texto;

    @Column(nullable = false)
    private double puntuacionCoherencia;

    @Column(nullable = true)
    private String sugerencias;

    @Column(nullable = false)
    private LocalDateTime fechaAnalisis;

}
