package tingeso2.sueldosservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tingeso2.sueldosservice.models.HorasExtraModel;

import java.util.List;

@Service
public class HorasExtraService {
    @Autowired
    RestTemplate restTemplate;

    public HorasExtraModel obtenerHorasExtraPorRut(String rut){
        return restTemplate.getForObject("http://autorizacion-service/autorizacion/" + rut, HorasExtraModel.class);
    }
}
