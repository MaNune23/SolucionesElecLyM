package ProyectoFinal.formulario.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ReporteProblema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String descripcion;
    private String urgencia;
}
