package com.odienne.fitnessTrackerServer.services.goal;

import com.odienne.fitnessTrackerServer.dto.GoalDTO;
import com.odienne.fitnessTrackerServer.entity.Goal;
import com.odienne.fitnessTrackerServer.repository.GoalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;

    public GoalDTO postGoal(GoalDTO dto) {
        Goal goal = new Goal();

        goal.setName(dto.getName());
        goal.setDescription(dto.getDescription());
        goal.setStartDate(dto.getStartDate());
        goal.setEndDate(dto.getEndDate());
        goal.setAchieved(dto.isAchieved());

        return goalRepository.save(goal).getGoalDTO();
    }

    @Override
    public List<GoalDTO> getGoals() {
        List<Goal> goals = goalRepository.findAll();
        return goals.stream().map(Goal::getGoalDTO).collect(Collectors.toList());
    }

    public GoalDTO updateStatus(Long id) {
        Optional<Goal> optionalGoal = goalRepository.findById(id);

        if (optionalGoal.isPresent()) {
            Goal existingGoal = optionalGoal.get();
            existingGoal.setAchieved(true);
            return goalRepository.save(existingGoal).getGoalDTO();
        }
        throw new EntityNotFoundException("Goal not found");
    }
}
