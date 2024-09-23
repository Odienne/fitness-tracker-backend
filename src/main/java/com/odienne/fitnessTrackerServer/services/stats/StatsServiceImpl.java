package com.odienne.fitnessTrackerServer.services.stats;

import com.odienne.fitnessTrackerServer.dto.GraphDTO;
import com.odienne.fitnessTrackerServer.dto.StatsDTO;
import com.odienne.fitnessTrackerServer.entity.Activity;
import com.odienne.fitnessTrackerServer.entity.Workout;
import com.odienne.fitnessTrackerServer.repository.ActivityRepository;
import com.odienne.fitnessTrackerServer.repository.GoalRepository;
import com.odienne.fitnessTrackerServer.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {

    private final GoalRepository goalRepository;

    private final ActivityRepository activityRepository;

    private final WorkoutRepository workoutRepository;

    public StatsDTO getStats() {
        Long achievedGoals = goalRepository.countByAchieved(true);
        Long ongoingGoals = goalRepository.countByAchieved(false);

        Integer totalSteps = activityRepository.sumSteps();
        Double totalDistance = activityRepository.sumDistance();
        Integer totalActivityCaloriesBurned = activityRepository.sumCaloriesBurned();

        Integer totalWorkoutDuration = workoutRepository.sumDuration();
        Integer totalWorkoutCaloriesBurned = workoutRepository.sumCaloriesBurned();

        int totalCaloriesBurned = (totalActivityCaloriesBurned != null ? totalActivityCaloriesBurned : 0)
                + (totalWorkoutCaloriesBurned != null ? totalWorkoutCaloriesBurned : 0);

        StatsDTO dto = new StatsDTO();
        dto.setAchievedGoals(achievedGoals != null ? achievedGoals : 0);
        dto.setOngoingGoals(ongoingGoals != null ? ongoingGoals : 0);
        dto.setSteps(totalSteps != null ? totalSteps : 0);
        dto.setDistance(totalDistance != null ? totalDistance : 0);
        dto.setTotalCaloriesBurned(totalCaloriesBurned);
        dto.setDuration(totalWorkoutDuration != null ? totalWorkoutDuration : 0);
        return dto;
    }

    public GraphDTO getGraphStats() {
        Pageable pageable = PageRequest.of(0, 7);
        List<Workout> workouts = workoutRepository.findLastWorkouts(pageable);
        List<Activity> activities = activityRepository.findLastWorkouts(pageable);

        GraphDTO graphDTO = new GraphDTO();
        graphDTO.setWorkouts(workouts.stream().map(Workout::getWorkoutDTO).collect(Collectors.toList()));
        graphDTO.setActivities(activities.stream().map(Activity::getActivityDTO).collect(Collectors.toList()));

        return graphDTO;
    }

}
