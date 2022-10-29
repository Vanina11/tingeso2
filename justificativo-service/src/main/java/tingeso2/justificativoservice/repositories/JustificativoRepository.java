package tingeso2.justificativoservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tingeso2.justificativoservice.entities.JustificativoEntity;

public interface JustificativoRepository extends JpaRepository<JustificativoEntity, Long> {
}
