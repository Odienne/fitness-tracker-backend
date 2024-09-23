package com.odienne.fitnessTrackerServer.services.workout;

import com.odienne.fitnessTrackerServer.dto.ActivityDTO;
import com.odienne.fitnessTrackerServer.dto.WorkoutDTO;

import java.util.List;

public interface WorkoutService {
    WorkoutDTO postWorkout(WorkoutDTO dto);
    List<WorkoutDTO> getWorkouts();

}
