package tingeso2.autorizacionservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tingeso2.autorizacionservice.models.EmpleadoModel;

@Service
public class EmpleadoService {
    @Autowired
    RestTemplate restTemplate;

    public EmpleadoModel empleadoPorRut(String rut){
        return restTemplate.getForObject("http://empleado-service/empleado/" + rut, EmpleadoModel.class);
    }
}
