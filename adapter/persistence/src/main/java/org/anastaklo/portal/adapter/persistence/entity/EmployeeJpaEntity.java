package org.anastaklo.portal.adapter.persistence.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class EmployeeJpaEntity extends BaseJpaEntity {

    @Column
    @NotBlank
    @Max(100)
    private String firstName;

    @Column
    @Max(100)
    private String middleName;

    @Column
    @NotBlank
    @Max(100)
    private String lastName;

    @Column
    @Past
    @NonNull
    private LocalDate dateOfBirth;

    @Column
    @Email
    @Max(50)
    private String email;

    @Column
    @Max(30)
    private String phone;

    @Column
    @NonNull
    private LocalDate startWorkDate;

    @Column
    private LocalDate finishWorkDate;

    @Column
    @Max(50)
    private String department; //todo: change to enum type

    @Column
    private boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    private RoomJpaEntity room;

    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private CalendarJpaEntity calendar;

    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private PositionJpaEntity position;

    @ManyToMany
    @JoinTable(name = "Employee_Manager_Map",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "manager_id")})
    private Set<EmployeeJpaEntity> managers = new HashSet<>();

    @ManyToMany(mappedBy = "managers")
    private Set<EmployeeJpaEntity> employees = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "Employee_Project_Map",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")})
    private Set<ProjectJpaEntity> projects = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "Employee_Role_Map",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    @NotEmpty
    private Set<RoleJpaEntity> roles = new HashSet<>();
}
