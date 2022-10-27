package tingeso2.empleadoservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tingeso2.empleadoservice.entities.EmpleadoEntity;
import tingeso2.empleadoservice.services.EmpleadoService;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping
    public List<EmpleadoEntity> obtenerEmpleados(){
        return empleadoService.obtenerEmpleados();
    }
    @PostMapping
    public void guardarEmpleado(@RequestBody EmpleadoEntity empleado){
        empleadoService.guardarEmpleado(empleado);
    }
}
