package tingeso2.sueldosservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tingeso2.sueldosservice.entities.SueldosEntity;
import tingeso2.sueldosservice.services.EmpleadoService;
import tingeso2.sueldosservice.services.SueldosService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/sueldos")
public class SueldosController {
    @Autowired
    SueldosService sueldosService;

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping
    @RolesAllowed("admin")
    public void calcularSueldos(){
        sueldosService.calcularSueldos();
    }

    @GetMapping("/eliminar")
    @RolesAllowed("admin")
    public void eliminarSueldos(){
        sueldosService.eliminarSueldos();
    }
    
    @GetMapping("/mostrar-sueldos")
    @RolesAllowed("admin")
    public List<SueldosEntity> mostrarSueldos(){
        return sueldosService.obtenerSueldos();
    }

}
