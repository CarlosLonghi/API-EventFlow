package br.com.carloslonghi.eventflow.api.infra.persistence;

import br.com.carloslonghi.eventflow.api.core.enums.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String description;

    String identifier;

    @Column(name = "start_at")
    LocalDateTime startAt;

    @Column(name = "end_at")
    LocalDateTime endAt;

    String location; // criar outra entidade "location" com informações do local

    @Column(name = "maximum_capacity")
    Integer maximumCapacity;

    String organizer;

    @Enumerated(EnumType.STRING)
    EventType type;
}
