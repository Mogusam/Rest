package org.jgmp;

import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Event extends RepresentationModel<Event> {

    @Id
    private Integer id;
    @Column
    private String title;
    @Column
    private String place;
    @Column
    private String speaker;
    @Column
    private String  eventType;
    @Column
    private LocalDate dateTime;
}