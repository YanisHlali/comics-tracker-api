package com.comicstracker.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CreatorController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/writers")
    public ResponseEntity<?> getWriters() {
        return readJson("data/writers.json");
    }

    @GetMapping("/pencillers")
    public ResponseEntity<?> getPencillers() {
        return readJson("data/pencillers.json");
    }

    @GetMapping("/characters")
    public ResponseEntity<?> getCharacters() {
        return readJson("data/characters.json");
    }

    private ResponseEntity<?> readJson(String path) {
        try {
            Resource file = new ClassPathResource(path);
            if (!file.exists()) return ResponseEntity.notFound().build();

            List<?> list = objectMapper.readValue(file.getInputStream(), List.class);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
