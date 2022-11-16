package tingeso2.empleadoservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tingeso2.empleadoservice.entities.EmpleadoEntity;
import tingeso2.empleadoservice.services.EmpleadoService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping
    //@RolesAllowed("admin")
    public ResponseEntity<List<EmpleadoEntity>> obtenerEmpleados(){
        List<EmpleadoEntity> empleados = empleadoService.obtenerEmpleados();
        if(empleados.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/{rut}")
    //@RolesAllowed("admin")
    public ResponseEntity<EmpleadoEntity> obtenerPorRut(@PathVariable("rut") String rut){
        EmpleadoEntity empleado = empleadoService.obtenerPorRut(rut);
        if(empleado == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(empleado);
    }

    @PutMapping("/incrementa-atrasos/{rut}")
    //@RolesAllowed("admin")
    public ResponseEntity<EmpleadoEntity> incrementaDescuentoAtraso(@PathVariable("rut") String rut, @RequestBody EmpleadoEntity empleadoActualizado){
        EmpleadoEntity empleado = empleadoService.obtenerPorRut(rut);
        empleado.setDescuentoAtraso(empleadoActualizado.getDescuentoAtraso());
        empleadoService.guardarEmpleado(empleado);
        return ResponseEntity.ok(empleado);
    }

    @PutMapping("/incrementa-inasistencias/{rut}")
    //@RolesAllowed("admin")
    public ResponseEntity<EmpleadoEntity> incrementaInasistencias(@PathVariable("rut") String rut, @RequestBody EmpleadoEntity empleadoActualizado){
        EmpleadoEntity empleado = empleadoService.obtenerPorRut(rut);
        empleado.setInasistencias(empleadoActualizado.getInasistencias());
        empleadoService.guardarEmpleado(empleado);
        return ResponseEntity.ok(empleado);
    }
    @PostMapping
    @RolesAllowed("user")
    public void guardarEmpleado(@RequestBody EmpleadoEntity empleado){
        empleadoService.guardarEmpleado(empleado);
    }

    @GetMapping("/eliminar")
    public void eliminarEmpleados(){
        empleadoService.eliminarEmpleados();
    }
}
