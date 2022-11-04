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
        String fecha2 = fecha.replace("/", "-");
        return restTemplate.getForObject("http://marcas-reloj-service/marcas-reloj/" + fecha2 + "/" + rut, MarcasRelojModel.class);
    }
}
