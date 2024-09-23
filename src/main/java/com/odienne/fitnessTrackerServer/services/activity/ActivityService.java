package com.odienne.fitnessTrackerServer.services.activity;

import com.odienne.fitnessTrackerServer.dto.ActivityDTO;

import java.util.List;

public interface ActivityService {
    ActivityDTO postActivity(ActivityDTO dto);
    List<ActivityDTO> getActivities();
}
