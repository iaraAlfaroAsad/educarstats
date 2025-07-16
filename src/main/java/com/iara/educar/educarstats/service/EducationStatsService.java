package com.iara.educar.educarstats.service;

import com.iara.educar.educarstats.model.EnrollmentStats;
import com.iara.educar.educarstats.util.DataLoader;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class EducationStatsService implements EducationStatsServiceInterface {
    private final DataLoader dataLoader;

    public EducationStatsService(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

    @Override
    public List<EnrollmentStats> getEnrollmentStats() {
        try {
            List<EnrollmentStats> rawData = dataLoader.loadEnrollmentData().get();
            return rawData.stream()
                    .collect(Collectors.groupingBy(
                            EnrollmentStats::getProvince,
                            Collectors.summingDouble(EnrollmentStats::getEnrollmentRate)
                    ))
                    .entrySet().stream()
                    .map(entry -> new EnrollmentStats(
                            entry.getKey(),
                            entry.getValue()
                    ))
                    .toList();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException("Error retrieving enrollment stats", e);
        }
    }
}
