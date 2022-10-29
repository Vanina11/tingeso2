package tingeso2.justificativoservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarcasRelojModel {
    private String fecha;
    private String hora;
    private String horaSalida;
    private String rutEmpleado;
}
