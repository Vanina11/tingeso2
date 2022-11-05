package tingeso2.plantillaservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SueldosModel {
    private String rut;
    private String nombres;
    private String apellidos;
    private String categoria;
    private Integer aniosServicio;
    private double sueldoFijo;
    private double montoBonificacion;
    private double montoHorasExtra;
    private double montoDescuentos;
    private double sueldoBruto;
    private double cotizacionPrevisional;
    private double cotizacionSalud;
    private double sueldoFinal;
}
