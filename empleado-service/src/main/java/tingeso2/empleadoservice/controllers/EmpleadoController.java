package tingeso2.empleadoservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<EmpleadoEntity>> obtenerEmpleados(){
        List<EmpleadoEntity> empleados = empleadoService.obtenerEmpleados();
        if(empleados.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/{rut}")
    public ResponseEntity<EmpleadoEntity> obtenerPorRut(@PathVariable("rut") String rut){
        EmpleadoEntity empleado = empleadoService.obtenerPorRut(rut);
        if(empleado == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(empleado);
    }
    @PostMapping
    public void guardarEmpleado(@RequestBody EmpleadoEntity empleado){
        empleadoService.guardarEmpleado(empleado);
    }
}
