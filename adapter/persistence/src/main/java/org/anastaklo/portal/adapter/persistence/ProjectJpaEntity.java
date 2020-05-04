package org.anastaklo.portal.adapter.persistence;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "project")
public class ProjectJpaEntity extends BaseJpaEntity{

    @Column
    @NotBlank
    @Max(50)
    private String name;

    @Column
    @Max(3000)
    private String description;

    @Column(name = "start_date")
    @NonNull
    private LocalDateTime startDate;

    @Column(name = "finish_date")
    private LocalDateTime finishDate;
    
    @ManyToMany(mappedBy = "projects")
    @NotEmpty
    private Set<EmployeeJpaEntity> employees = new HashSet<>();
}
