package com.comicstracker.api.controller;

import com.comicstracker.api.entity.Event;
import com.comicstracker.api.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getEvents(@RequestParam(value = "periodName", required = false) String periodName) {
        if (periodName != null) {
            return eventService.getEventsByPeriodId(periodName);
        } else {
            return eventService.getAllEvents();
        }
    }
}
