package com.comicstracker.api.data;

import com.comicstracker.api.entity.Period;
import com.comicstracker.api.repository.PeriodRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class PeriodDataLoader {

    private final PeriodRepository periodRepository;
    private final ObjectMapper objectMapper;

    public PeriodDataLoader(PeriodRepository periodRepository, ObjectMapper objectMapper) {
        this.periodRepository = periodRepository;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void loadData() {
        try (InputStream is = getClass().getResourceAsStream("/data/periods.json")) {
            List<Period> periods = objectMapper.readValue(is, new TypeReference<>() {});
            periodRepository.saveAll(periods);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load periods", e);
        }
    }
}
