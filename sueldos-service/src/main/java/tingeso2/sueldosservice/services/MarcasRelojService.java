package tingeso2.sueldosservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tingeso2.sueldosservice.models.MarcasRelojModel;

import java.util.List;

@Service
public class MarcasRelojService {
    @Autowired
    RestTemplate restTemplate;

    public MarcasRelojModel[] obtenerMarcasRelojPorEmpleado(String rut){
        return restTemplate.getForObject("http://marcas-reloj-service/marcas-reloj/" + rut, MarcasRelojModel[].class);
    }
}
