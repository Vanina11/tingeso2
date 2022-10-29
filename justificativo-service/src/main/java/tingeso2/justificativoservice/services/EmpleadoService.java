package tingeso2.justificativoservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tingeso2.justificativoservice.models.EmpleadoModel;

@Service
public class EmpleadoService {
    @Autowired
    RestTemplate restTemplate;

    public EmpleadoModel empleadoPorRut(String rut){
        return restTemplate.getForObject("http://empleado-service/empleado/" + rut, EmpleadoModel.class);
    }
}
