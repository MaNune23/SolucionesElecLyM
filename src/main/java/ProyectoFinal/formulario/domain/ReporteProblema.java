/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package formulario.domain;

/**
 *
 * @author gaelg
 */
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "reporte_problema")
public class ReporteProblema implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReporte;

    private String nombre;
    private String email;

    @Column(name = "descripcion_problema", columnDefinition = "TEXT")
    private String descripcionProblema;

    private boolean atendido = false;
}
