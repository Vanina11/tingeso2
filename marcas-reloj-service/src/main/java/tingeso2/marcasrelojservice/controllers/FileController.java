package tingeso2.marcasrelojservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tingeso2.marcasrelojservice.entities.MarcasRelojEntity;
import tingeso2.marcasrelojservice.services.FileResponse;
import tingeso2.marcasrelojservice.services.FileStorageService;
import tingeso2.marcasrelojservice.services.MarcasRelojService;

@RestController
@RequestMapping("/marcas-reloj")
public class FileController {
    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private MarcasRelojService marcasRelojService;

    @PutMapping("/subir-archivo")
    public ResponseEntity<FileResponse> uploadFile(@RequestParam("file") MultipartFile file){
        String fileName = fileStorageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/")
                .path(fileName)
                .toUriString();

        FileResponse fileResponse = new FileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
        marcasRelojService.guardarMarcasReloj(file);
        return new ResponseEntity<FileResponse>(fileResponse,HttpStatus.OK);
    }

    @GetMapping("{fecha}/{rut}")
    public ResponseEntity<MarcasRelojEntity> obtenerMarcasRelojPorFechaYEmpleado(@PathVariable String fecha, @PathVariable String rut){
        MarcasRelojEntity marca = marcasRelojService.marcaRelojPorFechaYRut(fecha, rut);
        if(marca == null){
            return new ResponseEntity<MarcasRelojEntity>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(marca);
    }
}
