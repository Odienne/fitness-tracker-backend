package com.odienne.fitnessTrackerServer.services.goal;

import com.odienne.fitnessTrackerServer.dto.GoalDTO;

import java.util.List;

public interface GoalService {
    GoalDTO postGoal(GoalDTO dto);
    List<GoalDTO> getGoals();
    GoalDTO updateStatus(Long id);
}
