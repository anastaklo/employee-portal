package org.anastaklo.portal.adapter.persistence;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "vacation_request")
public class VacationRequestJpaEntity {

    @EmbeddedId
    private VacationRequestId id;
    
    @OneToOne(fetch = FetchType.LAZY)
    @NonNull
    private EventJpaEntity event;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private EmployeeJpaEntity manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private EmployeeJpaEntity employee;
    
    @Column
    @NotBlank
    @Max(50)
    private String status; //todo: change to enum type

    @Override
    public int hashCode() {

        return 13;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof VacationRequestJpaEntity)) {
            return false;
        }
        VacationRequestJpaEntity other = (VacationRequestJpaEntity) o;
        return Objects.equals(id, other.id);
    }
}
