package tingeso2.autorizacionservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingeso2.autorizacionservice.entities.HorasExtraEntity;
import tingeso2.autorizacionservice.models.EmpleadoModel;
import tingeso2.autorizacionservice.models.MarcasRelojModel;
import tingeso2.autorizacionservice.repositories.HorasExtraRepository;

import java.util.List;

@Service
public class HorasExtraService {
    private static final Integer HORA_SALIDA = 18;
    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    MarcasRelojService marcasRelojService;
    @Autowired
    HorasExtraRepository horasExtraRepository;

    public boolean guardarHorasExtra(Integer horas, String rut, String fecha) {
        EmpleadoModel empleado = empleadoService.empleadoPorRut(rut);
        if(empleado != null && validarHoras(horas) && validarFecha(fecha)) {
            String mes = fecha.split("/")[1];
            // Las horas extra ingresadas coinciden con las realizadas
            if(verificaHorasExtra(horas, rut, fecha)){
                HorasExtraEntity horaExistente = horasExtraRepository.findByRutEmpleadoAndMes(rut, mes);
                // Si ya se ingresó las horas extra para el empleado, se actualiza el registro y se suman las horas de ese mes
                if(horaExistente != null) {
                    horaExistente.setHoras(horaExistente.getHoras() + horas);
                }else{
                    crearHora(horas, rut, mes);
                }
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }

    }

    public boolean verificaHorasExtra(Integer horas, String rut, String fecha){
        MarcasRelojModel marcaReloj = marcasRelojService.obtenerMarcaRelojPorFechaYEmpleado(fecha, rut);
        String[] horaSalida = marcaReloj.getHoraSalida().split(":");
        Integer horasReal = Integer.parseInt(horaSalida[0]) - HORA_SALIDA;
        return horasReal > 0 && horasReal.equals(horas);
    }

    public void crearHora(Integer horas, String rut, String mes) {
        HorasExtraEntity horasExtra = new HorasExtraEntity();
        horasExtra.setMes(mes);
        horasExtra.setHoras(horas);
        horasExtra.setRutEmpleado(rut);
        horasExtraRepository.save(horasExtra);
    }

    public boolean validarHoras(Integer hora){
        return hora > 0;
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

    public HorasExtraEntity obtenerHorasExtraPorRut(String rut){
        return horasExtraRepository.findByRutEmpleado(rut);
    }
}
