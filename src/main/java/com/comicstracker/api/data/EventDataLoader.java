package com.comicstracker.api.data;

import com.comicstracker.api.entity.Event;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class EventDataLoader {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final List<Event> events = new ArrayList<>();

    public EventDataLoader() {
        loadEvents("data/marvel_now/events.json");
        loadEvents("data/all_new_all_different/events.json");
        loadEvents("data/ultimate_universe/events.json");
        System.out.println("Loaded events: " + events.size());
    }

    private void loadEvents(String path) {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(path)) {
            if (is != null) {
                List<Event> loaded = objectMapper.readValue(is, new TypeReference<List<Event>>() {});
                events.addAll(loaded);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Event> getEvents() {
        return events;
    }

    public List<Event> getEventsByPeriodId(String periodId) {
        List<Event> result = new ArrayList<>();
        for (Event event : events) {
            if (event.getPeriodId().equals(periodId)) {
                result.add(event);
            }
        }
        return result;
    }
}
