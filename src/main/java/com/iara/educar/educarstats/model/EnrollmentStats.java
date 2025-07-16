package com.iara.educar.educarstats.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EnrollmentStats {

    @NotBlank(message = "Province cannot be blank")
    private String province;

    @PositiveOrZero(message = "Enrollment rate must be zero or positive")
    private double enrollmentRate;
}
