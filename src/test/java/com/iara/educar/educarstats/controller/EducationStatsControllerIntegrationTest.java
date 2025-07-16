package com.iara.educar.educarstats.controller;

import com.iara.educar.educarstats.model.EnrollmentStats;
import com.iara.educar.educarstats.service.EducationStatsServiceInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import static com.iara.educar.educarstats.util.TestUtilDataGenerator.getResponseMockData;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EducationStatsControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EducationStatsServiceInterface educationStatsService;

    @Test
    void getEnrollmentStats_returnsAggregateDataAsJson() throws Exception {
        // Arrange
        List<EnrollmentStats> mockResponse = getResponseMockData();
        when(educationStatsService.getEnrollmentStats()).thenReturn(mockResponse);

        // Act & Assert
        mockMvc.perform(get("/api/education/stats/enrollment"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].province").value("Buenos Aires"))
            .andExpect(jsonPath("$[0].enrollmentRate").value(175.5))
            .andExpect(jsonPath("$[1].province").value("Mendoza"))
            .andExpect(jsonPath("$[1].enrollmentRate").value(100.0));

    }
}
