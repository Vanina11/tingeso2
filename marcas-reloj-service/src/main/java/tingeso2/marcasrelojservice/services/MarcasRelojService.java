package tingeso2.marcasrelojservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tingeso2.marcasrelojservice.entities.MarcasRelojEntity;
import tingeso2.marcasrelojservice.models.EmpleadoModel;
import tingeso2.marcasrelojservice.repositories.MarcasRelojRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class MarcasRelojService {
    private static final Integer HORA_LLEGADA = 8;
    private static final Integer MINUTO_LLEGADA = 10;
    private static final Integer DESCUENTO_1 = 1;
    private static final Integer DESCUENTO_2 = 3;
    private static final Integer DESCUENTO_3 = 6;
    private static final Integer DESCUENTO_4 = 15;
    private String directorio="./src/main/resources/cargas" + File.pathSeparator;
    private final Logger logg = LoggerFactory.getLogger(MarcasRelojService.class);

    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    MarcasRelojRepository marcasRelojRepository;

    public boolean guardarMarcasReloj(MultipartFile file) {
        if (!file.isEmpty() && Objects.requireNonNull(file.getOriginalFilename()).endsWith(".txt")) {
            try {
                byte [] bytes= file.getBytes();
                Path path = Paths.get( directorio + file.getOriginalFilename() );
                Files.write(path, bytes);
                leerMarcasReloj(path);
                return true;

            } catch (IOException e) {
                logg.error("ERROR", e);
                return false;
            }
        }else{
            return false;
        }
    }

    public void leerMarcasReloj(Path path) throws IOException {
        try(BufferedReader br = new BufferedReader(new java.io.FileReader(path.toString()))){
            String linea = br.readLine();
            // Hasta que no se llegue al final del archivo
            while (linea != null){
                leerLinea(linea);
                linea = br.readLine();
            }
        } catch (IOException f){
            logg.error("ERROR", f);
        }
    }

    public void leerLinea(String linea){
        String[] datos = linea.split(";");
        String fecha = datos[0];
        String hora = datos[1];
        String rut = datos[2];
        // Si el empleado existe, se crea la marca de reloj
        EmpleadoModel empleado = empleadoService.empleadoPorRut(rut);
        MarcasRelojEntity marcas = marcasRelojRepository.findByFechaAndRutEmpleado(fecha, rut);
        if (empleado != null){
            if(marcas == null) {
                crearMarcaReloj(fecha, hora, rut);
            } else {
                marcas.setHoraSalida(hora);
                marcasRelojRepository.save(marcas);
            }
        }
    }

    public void crearMarcaReloj(String fecha, String hora, String rut) {
        EmpleadoModel empleado = empleadoService.empleadoPorRut(rut);
        Integer descuento = calcularDescuentoAtraso(hora);
        MarcasRelojEntity marcaReloj = new MarcasRelojEntity();
        marcaReloj.setFecha(fecha);
        marcaReloj.setHora(hora);
        marcaReloj.setRutEmpleado(empleado.getRut());
        if(!Objects.equals(descuento, DESCUENTO_4)){
            empleadoService.incrementaDescuentoAtraso(empleado, descuento);
        }else {
            empleadoService.incrementaInasistencias(empleado);
        }
        marcasRelojRepository.save(marcaReloj);
    }

    public Integer calcularDescuentoAtraso(String hora) {
        String[] horaMinuto = hora.split(":");
        Integer horaInt = Integer.parseInt(horaMinuto[0]);
        Integer minutoInt = Integer.parseInt(horaMinuto[1]);

        if(horaInt <= HORA_LLEGADA && minutoInt <= MINUTO_LLEGADA){
            return 0;
        } else {
            Integer minutosAtraso = (horaInt - HORA_LLEGADA) * 60 + minutoInt - MINUTO_LLEGADA;
            return montoDescuentoAtrasos(minutosAtraso);
        }
    }

    public Integer montoDescuentoAtrasos(Integer minutos){
        if(10 < minutos && minutos <= 25){
            return DESCUENTO_1;
        } else if(25 < minutos && minutos <= 45){
            return DESCUENTO_2;
        } else if(45 < minutos && minutos <= 70){
            return DESCUENTO_3;
        } else {
            return DESCUENTO_4;
        }
    }

    public MarcasRelojEntity marcaRelojPorFechaYRut(String fecha, String rut) {
        return marcasRelojRepository.findByFechaAndRutEmpleado(fecha, rut);
    }
}
