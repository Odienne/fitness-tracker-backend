package com.odienne.fitnessTrackerServer.services.workout;

import com.odienne.fitnessTrackerServer.dto.ActivityDTO;
import com.odienne.fitnessTrackerServer.dto.WorkoutDTO;
import com.odienne.fitnessTrackerServer.entity.Activity;
import com.odienne.fitnessTrackerServer.entity.Workout;
import com.odienne.fitnessTrackerServer.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutDTO postWorkout(WorkoutDTO dto) {
        Workout workout = new Workout();

        workout.setType(dto.getType());
        workout.setDate(dto.getDate());
        workout.setDuration(dto.getDuration());
        workout.setCaloriesBurned(dto.getCaloriesBurned());

        return workoutRepository.save(workout).getWorkoutDTO();
    }

    public List<WorkoutDTO> getWorkouts() {
        List<Workout> workouts = workoutRepository.findAll();
        return workouts.stream().map(Workout::getWorkoutDTO).collect(Collectors.toList());
    }
}
