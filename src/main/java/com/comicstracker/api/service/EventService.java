package com.comicstracker.api.service;

import com.comicstracker.api.entity.Event;
import com.comicstracker.api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getEventsByPeriodId(String periodId) {
        return eventRepository.findByPeriodId(periodId);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
