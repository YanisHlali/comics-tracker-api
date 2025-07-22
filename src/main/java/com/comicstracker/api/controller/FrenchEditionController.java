package com.comicstracker.api.controller;

import com.comicstracker.api.service.FrenchEditionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/french-editions")
public class FrenchEditionController {

    private final FrenchEditionService frenchEditionService;

    public FrenchEditionController(FrenchEditionService frenchEditionService) {
        this.frenchEditionService = frenchEditionService;
    }

    @GetMapping
    public List<Map<String, Object>> getFrenchEditionsByPeriod(@RequestParam String periodName) {
        return frenchEditionService.getFrenchEditionsByPeriod(periodName);
    }
}
