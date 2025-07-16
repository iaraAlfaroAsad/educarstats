package com.iara.educar.educarstats.controller;

import com.iara.educar.educarstats.model.EnrollmentStats;
import com.iara.educar.educarstats.service.EducationStatsServiceInterface;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/education/stats")
public class EducationStatsController {

    private final EducationStatsServiceInterface educationStatsService;

    public EducationStatsController(EducationStatsServiceInterface educationStatsService) {
        this.educationStatsService = educationStatsService;
    }

    @GetMapping("/enrollment")
    public List<@Valid EnrollmentStats> getEnrollmentStats() {
        return  educationStatsService.getEnrollmentStats();
    }
}
