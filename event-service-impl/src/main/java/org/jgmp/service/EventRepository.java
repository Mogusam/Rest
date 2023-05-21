package org.jgmp.service;

import java.util.List;

import org.jgmp.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
    List<Event> findAllByTitle(String title);
}
