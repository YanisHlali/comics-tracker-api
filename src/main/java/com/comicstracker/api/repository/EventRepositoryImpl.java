package com.comicstracker.api.repository;

import com.comicstracker.api.data.EventDataLoader;
import com.comicstracker.api.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventRepositoryImpl implements EventRepository {
    private final EventDataLoader eventDataLoader;

    @Autowired
    public EventRepositoryImpl(EventDataLoader eventDataLoader) {
        this.eventDataLoader = eventDataLoader;
    }

    @Override
    public List<Event> findByPeriodId(String periodId) {
        return eventDataLoader.getEventsByPeriodId(periodId);
    }

    @Override
    public List<Event> findAll() {
        return eventDataLoader.getEvents();
    }
}
