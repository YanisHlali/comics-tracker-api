package com.comicstracker.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/issues")
@RequiredArgsConstructor
public class IssueController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping
    public ResponseEntity<?> getIssuesByPeriod(@RequestParam String periodName) {
        return readJsonArray("data/" + periodName + "/issues.json");
    }

    @PostMapping("/byIds")
    public ResponseEntity<?> getIssuesByIds(
            @RequestParam String periodName,
            @RequestBody List<String> ids) {
        try {
            Resource file = new ClassPathResource("data/" + periodName + "/issues.json");
            if (!file.exists()) return ResponseEntity.notFound().build();

            List<Map<String, Object>> allIssues = objectMapper.readValue(
                    file.getInputStream(),
                    List.class
            );

            List<Map<String, Object>> filtered = allIssues.stream()
                    .filter(issue -> ids.contains(issue.get("id")))
                    .collect(Collectors.toList());

            return ResponseEntity.ok(filtered);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    private ResponseEntity<?> readJsonArray(String path) {
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
