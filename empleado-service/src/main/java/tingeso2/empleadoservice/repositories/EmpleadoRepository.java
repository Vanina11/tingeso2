package tingeso2.empleadoservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tingeso2.empleadoservice.entities.EmpleadoEntity;

@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long> {
    EmpleadoEntity findByRut(String rut);

    void deleteByRut(String rut);
}
