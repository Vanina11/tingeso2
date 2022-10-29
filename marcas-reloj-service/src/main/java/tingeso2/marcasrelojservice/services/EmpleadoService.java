package tingeso2.marcasrelojservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tingeso2.marcasrelojservice.models.EmpleadoModel;

import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    RestTemplate restTemplate;

    public List<EmpleadoModel> getEmpleados(){
        return restTemplate.getForObject("http://empleado", List.class);
    }

    public EmpleadoModel empleadoPorRut(String rut){
        return restTemplate.getForObject("http://empleado/" + rut, EmpleadoModel.class);
    }

}
