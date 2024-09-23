package com.odienne.fitnessTrackerServer.controller;

import com.odienne.fitnessTrackerServer.dto.ActivityDTO;
import com.odienne.fitnessTrackerServer.services.activity.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ActivityController {
    private final ActivityService activityService;

    @PostMapping("/activity")
    public ResponseEntity<?> postActivity(@RequestBody ActivityDTO dto) {
        ActivityDTO createActivity = activityService.postActivity(dto);

        if (createActivity != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createActivity);


        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @GetMapping("/activities")
    public ResponseEntity<?> getActivities() {
        try {
            List<ActivityDTO> activities = activityService.getActivities();
            return ResponseEntity.status(HttpStatus.OK).body(activities);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
}
