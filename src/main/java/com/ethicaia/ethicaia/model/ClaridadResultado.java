package com.ethicaia.ethicaia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "claridad_resultado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClaridadResultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, length = 13,nullable = false)
    private String texto;

    @Column(nullable = false)
    private double nivelLegibilidad;

    @Column(nullable = true)
    private String problemasDetectados;

    @Column(nullable = false)
    private LocalDateTime fechaAnalisis;

}
