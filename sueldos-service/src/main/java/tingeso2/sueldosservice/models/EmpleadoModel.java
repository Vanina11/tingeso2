package tingeso2.sueldosservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoModel {
    private String rut;
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private String categoria;
    private String fechaIngreso;
    private Integer inasistencias = 0;
    private Integer descuentoAtraso = 0;
}
