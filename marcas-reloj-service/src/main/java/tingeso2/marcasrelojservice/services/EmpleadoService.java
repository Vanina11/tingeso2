package tingeso2.marcasrelojservice.services;

import org.keycloak.adapters.jetty.core.AbstractKeycloakJettyAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tingeso2.marcasrelojservice.models.EmpleadoModel;

@Service
public class EmpleadoService {
    @Autowired
    RestTemplate restTemplate;

    public EmpleadoModel empleadoPorRut(String rut){
        System.out.println("llega a empleado por rut");
        return restTemplate.getForObject("http://empleado-service/empleado/" + rut, EmpleadoModel.class);
    }

    public void incrementaDescuentoAtraso(EmpleadoModel empleado, Integer descuento){
        empleado.setDescuentoAtraso(empleado.getDescuentoAtraso() + descuento);
        restTemplate.put("http://empleado-service/empleado/incrementa-atrasos/" + empleado.getRut(), empleado, EmpleadoModel.class);
    }

    public void incrementaInasistencias(EmpleadoModel empleado){
        empleado.setInasistencias(empleado.getInasistencias() + 1);
        restTemplate.put("http://empleado-service/empleado/incrementa-inasistencias/", empleado.getRut(), empleado, EmpleadoModel.class);
    }

}
