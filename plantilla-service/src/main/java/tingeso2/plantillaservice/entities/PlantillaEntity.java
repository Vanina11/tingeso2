package tingeso2.plantillaservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "plantillas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlantillaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
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
