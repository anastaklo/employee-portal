package org.anastaklo.portal.entities;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Employee {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String phone;
    private LocalDate startWorkDate;
    private LocalDate finishWorkDate;
    private Department department;
    private boolean isActive;
}
