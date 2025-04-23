package ProyectoFinal.formulario.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "reporte_calidad")
public class ReporteCalidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reporte_calidad")
    private Long idReporteCalidad;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String email;

    @Column(name = "descripcion_calidad", columnDefinition = "TEXT")
    private String descripcionCalidad;

    @Column(nullable = false)
    private boolean atendido = false;
}
