package tingeso2.sueldosservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tingeso2.sueldosservice.models.JustificativoModel;

import java.util.List;

@Service
public class JustificativoService {
    @Autowired
    RestTemplate restTemplate;

    public JustificativoModel[] obtenerJustificativosPorRut(String rut){
        return restTemplate.getForObject("http://justificativo-service/justificativo/" + rut, JustificativoModel[].class);
    }

    public void eliminarJustificativos(){
        restTemplate.getForObject("http://justificativo-service/justificativo/eliminar", void.class);
    }
}
