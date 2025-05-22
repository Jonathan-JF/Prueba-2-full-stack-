package com.ethicaia.ethicaia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Table(name = "originalidad_resultado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OriginalidadResultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, length = 13,nullable = false)
    private String texto;

    @Column(nullable = false)
    private double porcentajePlagio;

    @Column(nullable = true)
    private String fuentesDetectadas;

    @Column(nullable = false)
    private LocalDateTime fechaAnalisis;

}
