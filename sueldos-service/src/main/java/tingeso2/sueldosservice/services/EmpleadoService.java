package tingeso2.sueldosservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tingeso2.sueldosservice.models.EmpleadoModel;

import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    RestTemplate restTemplate;

    public EmpleadoModel empleadoPorRut(String rut){
        return restTemplate.getForObject("http://empleado-service/empleado/" + rut, EmpleadoModel.class);
    }

    public EmpleadoModel[] obtenerEmpleados(){
        return restTemplate.getForObject("http://empleado-service/empleado", EmpleadoModel[].class);
    }
}
