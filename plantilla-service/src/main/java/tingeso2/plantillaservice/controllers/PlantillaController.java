package tingeso2.plantillaservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tingeso2.plantillaservice.entities.PlantillaEntity;
import tingeso2.plantillaservice.services.PlantillaService;

import java.util.List;

@RestController
@RequestMapping("/plantilla")
public class PlantillaController {
    @Autowired
    PlantillaService plantillaService;

    @GetMapping
    public ResponseEntity<List<PlantillaEntity>> obtenerPlantillas(){
        List<PlantillaEntity> plantillas = plantillaService.obtenerPlantillas();
        return ResponseEntity.ok(plantillas);
    }
}
