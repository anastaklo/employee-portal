package org.anastaklo.portal.adapter.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "calendar")
public class CalendarJpaEntity extends BaseJpaEntity{
    
    @OneToMany(mappedBy = "parentCalendar")    
    private List<CalendarJpaEntity> childCalendars = new ArrayList<>();
    
    @ManyToOne(fetch = FetchType.LAZY)
    private CalendarJpaEntity parentCalendar;
    
    @OneToMany(mappedBy = "calendar")
    private List<EventJpaEntity> events = new ArrayList<>();

    @OneToMany(mappedBy = "calendar")
    @NotEmpty
    private List<EmployeeJpaEntity> employees = new ArrayList<>();
}
