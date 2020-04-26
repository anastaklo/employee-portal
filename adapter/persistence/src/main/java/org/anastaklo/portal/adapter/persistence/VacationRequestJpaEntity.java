package org.anastaklo.portal.adapter.persistence;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "vacation_request")
public class VacationRequestJpaEntity {

    @EmbeddedId
    private VacationRequestId id;
    
    @OneToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    @NonNull
    private EventJpaEntity event;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    @NonNull
    private EmployeeJpaEntity manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    @NonNull
    private EmployeeJpaEntity employee;
    
    @Column
    @Getter
    @Setter
    @NonNull
    private String status;

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
