package org.jgmp.service;

import java.util.List;
import java.util.stream.StreamSupport;

import org.jgmp.Event;
import org.jgmp.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {


    @Autowired
    private EventRepository repository;

    @Override
    public Event createEvent(Event event) {
        repository.save(event);
        return event;
    }

    @Override
    public void updateEvent(Event event) {
         repository.save(event);
    }

    @Override
    public Event getEvent(Integer id) {
        return repository.findById(id).orElse(new Event());
    }

    @Override
    public void deleteEvent(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Event> getAllEvents() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }

    @Override
    public List<Event> getAllEventsByTitle(String title) {
        return repository.findAllByTitle(title);
    }
}
