package com.odienne.fitnessTrackerServer.controller;

import com.odienne.fitnessTrackerServer.dto.GraphDTO;
import com.odienne.fitnessTrackerServer.services.stats.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StatsController {

    private final StatsService statsService;

    @GetMapping("/stats")
    private ResponseEntity<?> getStats() {
        return ResponseEntity.ok(statsService.getStats());
    }

    @GetMapping("/graphs")
    public ResponseEntity<?> getGraphStats() {
        GraphDTO graphDTO = statsService.getGraphStats();

        if (graphDTO != null) {
            return ResponseEntity.ok(graphDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
