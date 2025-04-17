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
@Table(name = "reporte_calidad")
public class ReporteCalidad implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReporteCalidad;

    private String nombre;
    private String email;

    @Column(name = "reporte_calidad", columnDefinition = "TEXT")
    private String descripcionCalidad;

    private boolean atendido = false;

}
