package tingeso2.autorizacionservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tingeso2.autorizacionservice.models.MarcasRelojModel;

@Service
public class MarcasRelojService {
    @Autowired
    RestTemplate restTemplate;

    public MarcasRelojModel obtenerMarcaRelojPorFechaYEmpleado(String fecha, String rut){
        return restTemplate.getForObject("http://marcasreloj-service/marcasreloj/" + fecha + "/" + rut, MarcasRelojModel.class);
    }
}
