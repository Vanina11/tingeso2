package tingeso2.sueldosservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tingeso2.sueldosservice.services.SueldosService;

@RestController
@RequestMapping("/sueldos")
public class SueldosController {
    @Autowired
    SueldosService sueldosService;

    @GetMapping
    public void calcularSueldos(){
        sueldosService.calcularSueldos();
    }

}
