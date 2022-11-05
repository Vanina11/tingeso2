package tingeso2.plantillaservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tingeso2.plantillaservice.models.SueldosModel;

@Service
public class SueldosService {
    @Autowired
    RestTemplate restTemplate;

    public SueldosModel[] obtenerSueldos(){
        return restTemplate.getForObject("http://sueldos-service/sueldos/obtener-sueldos", SueldosModel[].class);
    }
}
