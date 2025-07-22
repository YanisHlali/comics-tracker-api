package com.comicstracker.api.controller;

import com.comicstracker.api.entity.Period;
import com.comicstracker.api.service.PeriodService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/periods")
public class PeriodController {

    private final PeriodService periodService;

    public PeriodController(PeriodService periodService) {
        this.periodService = periodService;
    }

    @GetMapping
    public List<Period> getAll() {
        return periodService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Period> getById(@PathVariable String id) {
        return periodService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
