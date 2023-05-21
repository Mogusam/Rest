package org.jgmp;

import java.util.List;

public interface EventService {

    Event createEvent(Event event);

    void updateEvent(Event event);

    Event getEvent(Integer id);

    void deleteEvent(Integer id);

    List<Event> getAllEvents();

    List<Event> getAllEventsByTitle(String title);

}
