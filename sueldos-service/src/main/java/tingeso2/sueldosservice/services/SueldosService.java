package tingeso2.sueldosservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingeso2.sueldosservice.entities.SueldosEntity;
import tingeso2.sueldosservice.models.EmpleadoModel;
import tingeso2.sueldosservice.models.HorasExtraModel;
import tingeso2.sueldosservice.models.JustificativoModel;
import tingeso2.sueldosservice.models.MarcasRelojModel;
import tingeso2.sueldosservice.repositories.SueldosRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class SueldosService {
    private static final double DESCUENTO_PREVISIONAL = 0.1;
    private static final double DESCUENTO_SALUD = 0.08;
    private static final Integer HORAS_A = 25000;
    private static final Integer HORAS_B = 20000;
    private static final Integer HORAS_C = 10000;
    // Considera 20 días hábiles de trabajo por mes
    private static final Integer DIAS_MES = 20;
    private static final double DESCUENTO_INASISTENCIA = 0.15;
    private static final Integer ANIO_ACTUAL = 2022;
    private static final double BONIFICACION_1 = 0.05;
    private static final double BONIFICACION_2 = 0.08;
    private static final double BONIFICACION_3 = 0.11;
    private static final double BONIFICACION_4 = 0.14;
    private static final double BONIFICACION_5 = 0.17;
    private static final Integer SUELDO_A = 1700000;
    private static final Integer SUELDO_B = 1200000;
    private static final Integer SUELDO_C = 800000;

    @Autowired
    SueldosRepository sueldoRepository;
    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    HorasExtraService horasExtraService;
    @Autowired
    MarcasRelojService marcasRelojService;
    @Autowired
    JustificativoService justificativoService;

    public List<SueldosEntity> obtenerSueldos(){ return sueldoRepository.findAll(); }

    public boolean calcularSueldos(){
        EmpleadoModel[] empleados = empleadoService.obtenerEmpleados();
        for (int i = 0; i< empleados.length; i++) {
            EmpleadoModel empleado = empleados[i];
            SueldosEntity sueldo = crearSueldo(empleado);
            double descuentoAtrasos = calculaDescuentos(empleado);
            sueldo.setMontoDescuentos(redondear(descuentoAtrasos));
            double horasExtra = calculaMontoHorasExtras(empleado);
            sueldo.setMontoHorasExtra(redondear(horasExtra));
            double sueldoBruto = sueldo.getSueldoFijo() + sueldo.getMontoHorasExtra() + sueldo.getMontoBonificacion() - sueldo.getMontoDescuentos();
            sueldo.setSueldoBruto(redondear(sueldoBruto));
            sueldo.setCotizacionPrevisional(redondear(sueldoBruto * DESCUENTO_PREVISIONAL));
            sueldo.setCotizacionSalud(redondear(sueldoBruto * DESCUENTO_SALUD));
            sueldo.setSueldoFinal(redondear(sueldoBruto - sueldo.getCotizacionPrevisional() - sueldo.getCotizacionSalud()));
            sueldoRepository.save(sueldo);
        }
        return true;
    }

    public SueldosEntity crearSueldo(EmpleadoModel empleado) {
        SueldosEntity sueldo = new SueldosEntity();
        sueldo.setRut(empleado.getRut());
        sueldo.setNombres(empleado.getNombres());
        sueldo.setApellidos(empleado.getApellidos());
        sueldo.setCategoria(empleado.getCategoria());
        Integer aniosS = calcularAniosServicio(empleado.getFechaIngreso());
        sueldo.setAniosServicio(aniosS);
        sueldo.setSueldoFijo(asignarSueldoFijo(empleado.getCategoria()));
        sueldo.setMontoBonificacion(redondear(calcularBonoAniosServicio(aniosS) * sueldo.getSueldoFijo()));
        return sueldo;
    }

    public double calculaMontoHorasExtras(EmpleadoModel empleado){
        Integer horas = totalHorasExtras(empleado);
        double montoPorHora = montoHorasExtras(empleado);
        return horas * montoPorHora;
    }

    public Integer totalHorasExtras(EmpleadoModel empleado){
        HorasExtraModel horasExtras = horasExtraService.obtenerHorasExtraPorRut(empleado.getRut());
        return horasExtras.getHoras();
    }

    public double montoHorasExtras(EmpleadoModel empleado){
        String categoria = empleado.getCategoria();
        switch (categoria){
            case "A" -> { return HORAS_A; }
            case "B" -> { return HORAS_B; }
            case "C" -> { return HORAS_C; }
            default -> { return 0; }
        }
    }

    public double calculaDescuentos(EmpleadoModel empleado){
        Integer sueldoFijo = asignarSueldoFijo(empleado.getCategoria());
        MarcasRelojModel[] marcas = marcasRelojService.obtenerMarcasRelojPorEmpleado(empleado.getRut());
        JustificativoModel[] justificativos = justificativoService.obtenerJustificativosPorRut(empleado.getRut());
        Integer inasistencias = DIAS_MES - marcas.length - justificativos.length;
        double porcentajeDescuento = empleado.getDescuentoAtraso()/100.0;
        return porcentajeDescuento*sueldoFijo + (inasistencias*DESCUENTO_INASISTENCIA*sueldoFijo);
    }

    public Integer calcularAniosServicio(String fecha){
        String anioI = fecha.split("/")[0];
        return ANIO_ACTUAL - Integer.parseInt(anioI);
    }

    public double calcularBonoAniosServicio(Integer anios){
        if(anios < 5){
            return 0;
        } else if(anios < 10){
            return BONIFICACION_1;
        } else if(anios < 15){
            return BONIFICACION_2;
        } else if(anios < 20){
            return BONIFICACION_3;
        } else if(anios < 25){
            return BONIFICACION_4;
        } else {
            return BONIFICACION_5;
        }
    }

    public Integer asignarSueldoFijo(String categoria) {
        return switch (categoria) {
            case "A" -> SUELDO_A;
            case "B" -> SUELDO_B;
            case "C" -> SUELDO_C;
            default -> 0;
        };
    }

    public double redondear(double numero){
        BigDecimal bd = BigDecimal.valueOf(numero).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void eliminarSueldos(){
        sueldoRepository.deleteAll();
        marcasRelojService.eliminarMarcasReloj();
        horasExtraService.eliminarHorasExtra();
        justificativoService.eliminarJustificativos();
        empleadoService.eliminarEmpleados();
    }
}
