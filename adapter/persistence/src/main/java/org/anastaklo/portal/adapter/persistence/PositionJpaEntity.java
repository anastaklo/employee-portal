package org.anastaklo.portal.adapter.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "position")
public class PositionJpaEntity extends BaseJpaEntity{

    @Column
    @Getter
    @Setter
    @NonNull
    private String name;

    @Column
    @Getter
    @Setter
    @NonNull
    private String category; //todo: maybe change this field to just 'isManager'?
    
    @OneToMany(mappedBy = "position")
    @Getter
    @Setter
    @NonNull
    private List<EmployeeJpaEntity> employees = new ArrayList<>();
}
