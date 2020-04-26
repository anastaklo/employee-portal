package org.anastaklo.portal.adapter.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "calendar")
public class CalendarJpaEntity extends BaseJpaEntity{
    
    @OneToMany(mappedBy = "parentCalendar")
    @Getter
    @Setter
    private List<CalendarJpaEntity> childCalendars = new ArrayList<>();
    
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    private CalendarJpaEntity parentCalendar;
    
    @OneToMany(mappedBy = "calendar")
    @Getter
    @Setter
    private List<EventJpaEntity> events = new ArrayList<>();

    @OneToMany(mappedBy = "calendar")
    @Getter
    @Setter
    @NonNull
    private List<EmployeeJpaEntity> employees = new ArrayList<>();
}
