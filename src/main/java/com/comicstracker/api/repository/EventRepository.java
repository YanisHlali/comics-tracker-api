package com.comicstracker.api.repository;

import com.comicstracker.api.entity.Event;
import java.util.List;

public interface EventRepository {
    List<Event> findByPeriodId(String periodId);
    List<Event> findAll();
}
