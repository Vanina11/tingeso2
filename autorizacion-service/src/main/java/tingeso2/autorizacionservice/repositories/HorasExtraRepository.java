package tingeso2.autorizacionservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tingeso2.autorizacionservice.entities.HorasExtraEntity;

public interface HorasExtraRepository extends JpaRepository<HorasExtraEntity, Long> {
    HorasExtraEntity findByRutEmpleadoAndMes(String rutEmpleado, String mes);

    HorasExtraEntity findByRutEmpleado(String rut);
}

