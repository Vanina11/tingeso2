package tingeso2.justificativoservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tingeso2.justificativoservice.entities.JustificativoEntity;
import tingeso2.justificativoservice.services.JustificativoService;

import java.util.List;


@RestController
@RequestMapping("/justificativo")
public class JustificativoController {
    @Autowired
    JustificativoService justificativoService;

    @GetMapping
    public List<JustificativoEntity> getJustificativos(){
        return justificativoService.getJustificativos();
    }

    @PostMapping
    public void justificativo(@RequestParam("fecha") String fecha, @RequestParam("rut") String rut) {
        justificativoService.guardarJustificativo(fecha, rut);
    }
}
