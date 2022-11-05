package tingeso2.sueldosservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HorasExtraModel {
    private Integer horas;
    private String mes;
    private String rutEmpleado;
}
