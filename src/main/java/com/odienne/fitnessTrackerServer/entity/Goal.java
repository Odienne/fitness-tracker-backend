package com.odienne.fitnessTrackerServer.entity;

import com.odienne.fitnessTrackerServer.dto.GoalDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    private Date startDate;
    private Date endDate;
    private boolean achieved = false;

    public GoalDTO getGoalDTO() {
        GoalDTO goalDTO = new GoalDTO();
        goalDTO.setId(id);
        goalDTO.setName(name);
        goalDTO.setDescription(description);
        goalDTO.setStartDate(startDate);
        goalDTO.setEndDate(endDate);
        goalDTO.setAchieved(achieved);

        return goalDTO;
    }

}
