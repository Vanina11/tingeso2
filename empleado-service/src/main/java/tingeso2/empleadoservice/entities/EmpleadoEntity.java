package tingeso2.empleadoservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "empleados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    // Datos desde el archivo excel
    private String rut;
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private String categoria;
    private String fechaIngreso;
    private Integer inasistencias = 0;
    private Integer descuentoAtraso = 0;
}
