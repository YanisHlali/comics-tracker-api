package com.comicstracker.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loadData")
@RequiredArgsConstructor
public class LoadDataController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping
    public ResponseEntity<?> loadData(
            @RequestParam String periodName,
            @RequestParam String fileType) {
        try {
            String path = String.format("data/%s/%s.json", periodName, fileType);
            Resource file = new ClassPathResource(path);
            if (!file.exists()) return ResponseEntity.notFound().build();

            List<?> list = objectMapper.readValue(file.getInputStream(), List.class);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
