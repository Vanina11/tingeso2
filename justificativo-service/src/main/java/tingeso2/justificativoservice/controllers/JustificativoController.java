package tingeso2.justificativoservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{rut}")
    public ResponseEntity<List<JustificativoEntity>> getJustificativoPorRut(@PathVariable String rut){
        List<JustificativoEntity> justificativo = justificativoService.obtenerJustificativoPorRut(rut);
        return ResponseEntity.ok(justificativo);
    }

    @PostMapping
    public ResponseEntity<JustificativoEntity> justificativo(@RequestBody JustificativoEntity justificativo) {
        String rut = justificativo.getRutEmpleado();
        String fecha = justificativo.getFecha();
        justificativoService.guardarJustificativo(fecha, rut);
        return ResponseEntity.ok(justificativo);
    }
}
