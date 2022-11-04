package tingeso2.autorizacionservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tingeso2.autorizacionservice.entities.HorasExtraEntity;
import tingeso2.autorizacionservice.repositories.HorasExtraRepository;
import tingeso2.autorizacionservice.services.HorasExtraService;

import java.util.List;

@RestController
@RequestMapping("/autorizacion")
public class HorasExtraController {
    @Autowired
    HorasExtraService horasExtraService;

    @Autowired
    HorasExtraRepository horasExtraRepository;


    @GetMapping
    public List<HorasExtraEntity> getHorasExtra(){

        return horasExtraRepository.findAll();
    }

    @PostMapping
    public void ingresarHorasExtra(@RequestParam("fecha") String fecha, @RequestParam("rut") String rut, @RequestParam("horas") int horas){
        boolean r = horasExtraService.guardarHorasExtra(horas, rut, fecha);
    }
}