package com.comicstracker.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class FrenchEditionService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Map<String, Object>> getFrenchEditionsByPeriod(String periodName) {
        String path = String.format("/data/%s/french_editions.json", periodName);
        try (InputStream is = getClass().getResourceAsStream(path)) {
            if (is == null) return Collections.emptyList();
            return objectMapper.readValue(is, new TypeReference<>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to load french editions for " + periodName, e);
        }
    }
}
