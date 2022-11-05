package tingeso2.justificativoservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingeso2.justificativoservice.entities.JustificativoEntity;
import tingeso2.justificativoservice.models.EmpleadoModel;
import tingeso2.justificativoservice.repositories.JustificativoRepository;

import java.util.List;

@Service
public class JustificativoService {
    @Autowired
    EmpleadoService empleadoService;

    @Autowired
    JustificativoRepository justificativoRepository;

    public void guardarJustificativo(String fecha, String rut) {
        EmpleadoModel empleado = empleadoService.empleadoPorRut(rut);
        if (empleado != null && validarFecha(fecha)) {
            JustificativoEntity justificativo = new JustificativoEntity();
            justificativo.setFecha(fecha);
            justificativo.setRutEmpleado(rut);
            justificativoRepository.save(justificativo);
        }
    }

    public boolean validarFecha(String fecha) {
        String[] fechaS = fecha.split("/");
        if(fechaS.length == 3){
            int dia = Integer.parseInt(fechaS[2]);
            int mes = Integer.parseInt(fechaS[1]);
            int anio = Integer.parseInt(fechaS[0]);
            return dia > 0 && dia < 32 && mes > 0 && mes < 13 && anio > 0;
        } else {
            return false;
        }
    }

    public List<JustificativoEntity> getJustificativos(){
        return justificativoRepository.findAll();
    }

    public List<JustificativoEntity> obtenerJustificativoPorRut(String rut){
        return justificativoRepository.findByRutEmpleado(rut);
    }

}
