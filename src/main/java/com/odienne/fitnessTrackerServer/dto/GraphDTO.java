package com.odienne.fitnessTrackerServer.dto;

import com.odienne.fitnessTrackerServer.entity.Activity;
import lombok.Data;

import java.util.List;

@Data
public class GraphDTO {
    private List<WorkoutDTO> workouts;
    private List<ActivityDTO> activities;
}
