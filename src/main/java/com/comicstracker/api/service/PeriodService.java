package com.comicstracker.api.service;

import com.comicstracker.api.entity.Period;
import com.comicstracker.api.repository.PeriodRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;


import java.util.List;

@Service
public class PeriodService {

    private final PeriodRepository periodRepository;

    public PeriodService(PeriodRepository periodRepository) {
        this.periodRepository = periodRepository;
    }

    public List<Period> findAll() {
        return periodRepository.findAll();
    }

    public Optional<Period> findById(String id) {
        return periodRepository.findById(id);
    }
}
