package tingeso2.autorizacionservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tingeso2.autorizacionservice.entities.HorasExtraEntity;
import tingeso2.autorizacionservice.services.HorasExtraService;

import java.util.List;

@RestController
@RequestMapping("/autorizacion")
public class HorasExtraController {
    @Autowired
    HorasExtraService horasExtraService;

    @GetMapping("/{rut}")
    public ResponseEntity<HorasExtraEntity> getHorasExtraPorRut(@PathVariable String rut){
        HorasExtraEntity horasExtra = horasExtraService.obtenerHorasExtraPorRut(rut);
        return ResponseEntity.ok(horasExtra);
    }

    @PostMapping
    public ResponseEntity<HorasExtraEntity> horasExtra(@RequestBody HorasExtraEntity horasExtra) {
        String rut = horasExtra.getRutEmpleado();
        String fecha = horasExtra.getMes();
        int horas = horasExtra.getHoras();
        horasExtraService.guardarHorasExtra(horas, rut, fecha);

        return ResponseEntity.ok(horasExtra);
    }

}