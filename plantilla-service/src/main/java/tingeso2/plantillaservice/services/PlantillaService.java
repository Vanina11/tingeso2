package tingeso2.plantillaservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingeso2.plantillaservice.entities.PlantillaEntity;
import tingeso2.plantillaservice.models.SueldosModel;
import tingeso2.plantillaservice.repositories.PlantillaRepository;

import java.util.List;

@Service
public class PlantillaService {
    @Autowired
    SueldosService sueldosService;
    @Autowired
    PlantillaRepository plantillaRepository;

    public List<PlantillaEntity> obtenerPlantillas(){
        SueldosModel[] sueldos = sueldosService.obtenerSueldos();
        for(SueldosModel sueldo : sueldos){
            PlantillaEntity plantilla = new PlantillaEntity();
            plantilla.setRut(sueldo.getRut());
            plantilla.setNombres(sueldo.getNombres());
            plantilla.setApellidos(sueldo.getApellidos());
            plantilla.setCategoria(sueldo.getCategoria());
            plantilla.setAniosServicio(sueldo.getAniosServicio());
            plantilla.setSueldoFijo(sueldo.getSueldoFijo());
            plantilla.setMontoBonificacion(sueldo.getMontoBonificacion());
            plantilla.setMontoBonificacion(sueldo.getMontoBonificacion());
            plantilla.setMontoDescuentos(sueldo.getMontoDescuentos());
            plantilla.setSueldoBruto(sueldo.getSueldoBruto());
            plantilla.setCotizacionPrevisional(sueldo.getCotizacionPrevisional());
            plantilla.setCotizacionSalud(sueldo.getCotizacionSalud());
            plantilla.setSueldoFinal(sueldo.getSueldoFinal());
            plantillaRepository.save(plantilla);
        }
        return plantillaRepository.findAll();
    }
}
