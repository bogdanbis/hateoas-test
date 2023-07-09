package ro.bogdannegoita.hateoastest.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.bogdannegoita.hateoastest.persistence.entities.FirmEntity;

import java.util.UUID;

@Repository
public interface FirmRepository extends JpaRepository<FirmEntity, UUID> {
}
