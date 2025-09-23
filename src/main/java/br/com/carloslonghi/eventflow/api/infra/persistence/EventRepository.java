package br.com.carloslonghi.eventflow.api.infra.persistence;

import br.com.carloslonghi.eventflow.api.core.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {

    boolean existsByIdentifier(String identifier);

    Optional<Event> findByIdentifier(String identifier);
}
