package com.odienne.fitnessTrackerServer.services.stats;

import com.odienne.fitnessTrackerServer.dto.GraphDTO;
import com.odienne.fitnessTrackerServer.dto.StatsDTO;

public interface StatsService {

    StatsDTO getStats();

    GraphDTO getGraphStats();
}
