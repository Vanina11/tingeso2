package tingeso2.sueldosservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tingeso2.sueldosservice.entities.SueldosEntity;

import java.util.List;

public interface SueldosRepository extends JpaRepository<SueldosEntity, Long> {
    List<SueldosEntity> findByRut(String rut);

}
