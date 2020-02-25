package org.anastaklo.portal.domain;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Person {
    
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String phone;
    private LocalDate startWorkDate;
    private LocalDate finishWorkDate;
    private Department department;
    private boolean isActive;
}
