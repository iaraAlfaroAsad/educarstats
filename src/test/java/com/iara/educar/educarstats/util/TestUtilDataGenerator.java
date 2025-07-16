package com.iara.educar.educarstats.util;

import com.iara.educar.educarstats.model.EnrollmentStats;

import java.util.List;

public class TestUtilDataGenerator {
    public static List<EnrollmentStats> getMockData() {
        return List.of(
                new EnrollmentStats("Buenos Aires", 85.5),
                new EnrollmentStats("Buenos Aires", 90.0),
                new EnrollmentStats("Mendoza", 100.0)
        );
    }

    public static List<EnrollmentStats> getResponseMockData() {
        return List.of(
                new EnrollmentStats("Buenos Aires", 175.5),
                new EnrollmentStats("Mendoza", 100.0)
        );
    }
}
