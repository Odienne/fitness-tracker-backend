package com.odienne.fitnessTrackerServer.dto;

import lombok.Data;

@Data
public class StatsDTO {

    private long achievedGoals;
    private long ongoingGoals;

    private int steps;
    private double distance;
    private int totalCaloriesBurned;

    private int duration;
}
