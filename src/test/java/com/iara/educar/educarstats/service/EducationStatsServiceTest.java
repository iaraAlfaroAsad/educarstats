package com.iara.educar.educarstats.service;

import com.iara.educar.educarstats.model.EnrollmentStats;
import com.iara.educar.educarstats.util.DataLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.iara.educar.educarstats.util.TestUtilDataGenerator.getMockData;
import static org.mockito.Mockito.when;

public class EducationStatsServiceTest {

    @Mock
    private DataLoader dataLoader;

    @InjectMocks
    private EducationStatsService educationStatsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getEnrollmentStats_returnsAggregateData_correctly() {
        // Arrange
        List<EnrollmentStats> mockData = getMockData();
        when(dataLoader.loadEnrollmentData()).thenReturn(CompletableFuture.completedFuture(mockData));

        // Act
        List<EnrollmentStats> result = educationStatsService.getEnrollmentStats();

        // Assertions
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("Buenos Aires", result.get(0).getProvince());
    }
}
