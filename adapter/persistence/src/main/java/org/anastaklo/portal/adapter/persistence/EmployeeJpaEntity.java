package org.anastaklo.portal.adapter.persistence;

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
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "employee")
public class EmployeeJpaEntity extends BaseJpaEntity{

    @Column
    @Getter
    @Setter
    private String firstName;

    @Column
    @Getter
    @Setter
    private String middleName;

    @Column
    @Getter
    @Setter
    private String lastName;

    @Column
    @Getter
    @Setter
    private LocalDate dateOfBirth;

    @Column
    @Getter
    @Setter
    private String email;

    @Column
    @Getter
    @Setter
    private String phone;

    @Column
    @Getter
    @Setter
    private LocalDate startWorkDate;

    @Column
    @Getter
    @Setter
    private LocalDate finishWorkDate;

    @Column
    @Getter
    @Setter
    private String department;

    @Column
    @Getter
    @Setter
    private boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    private RoomJpaEntity room;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    @NonNull
    private CalendarJpaEntity calendar;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    @NonNull
    private PositionJpaEntity position;
    
    @ManyToMany
    @JoinTable(name = "Employee_Manager_Map",
    joinColumns = { @JoinColumn(name = "employee_id")},
    inverseJoinColumns = { @JoinColumn(name = "manager_id")})
    @Getter
    @Setter
    @NonNull
    private Set<EmployeeJpaEntity> managers = new HashSet<>();

    @ManyToMany(mappedBy = "managers")
    @Getter
    @Setter
    @NonNull
    private Set<EmployeeJpaEntity> employees = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "Employee_Project_Map",
            joinColumns = { @JoinColumn(name = "employee_id")},
            inverseJoinColumns = { @JoinColumn(name = "project_id")})
    @Getter
    @Setter
    private Set<ProjectJpaEntity> projects = new HashSet<>();
    
    @ManyToMany
    @JoinTable(name = "Employee_Role_Map",
    joinColumns = { @JoinColumn(name = "employee_id")},
    inverseJoinColumns = { @JoinColumn(name = "role_id")})
    @Getter
    @Setter
    @NonNull
    private Set<RoleJpaEntity> roles = new HashSet<>();    
}
