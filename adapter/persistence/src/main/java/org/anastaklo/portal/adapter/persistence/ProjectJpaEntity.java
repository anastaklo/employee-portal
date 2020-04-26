package org.anastaklo.portal.adapter.persistence;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "project")
public class ProjectJpaEntity extends BaseJpaEntity{

    @Column
    @Getter
    @Setter
    @NonNull
    private String name;

    @Column
    @Getter
    @Setter
    private String description;

    @Column(name = "start_date")
    @Getter
    @Setter
    @NonNull
    private LocalDateTime startDate;

    @Column(name = "finish_date")
    @Getter
    @Setter
    private LocalDateTime finishDate;
    
    @ManyToMany(mappedBy = "projects")
    @Getter
    @Setter
    @NonNull
    private Set<EmployeeJpaEntity> employees = new HashSet<>();
}
