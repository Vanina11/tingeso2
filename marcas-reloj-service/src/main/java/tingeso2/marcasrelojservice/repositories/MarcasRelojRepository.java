package tingeso2.marcasrelojservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tingeso2.marcasrelojservice.entities.MarcasRelojEntity;

import java.util.List;

@Repository
public interface MarcasRelojRepository extends JpaRepository<MarcasRelojEntity, Long> {
    MarcasRelojEntity findByFechaAndRutEmpleado(String fecha, String rutEmpleado);
    List<MarcasRelojEntity> findByRutEmpleado(String rutEmpleado);
}

