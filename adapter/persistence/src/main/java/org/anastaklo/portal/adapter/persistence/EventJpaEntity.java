package org.anastaklo.portal.adapter.persistence;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "event")
public class EventJpaEntity extends BaseJpaEntity {
    
    @Column(name = "start_date")
    @Getter
    @Setter
    @NonNull
    private LocalDateTime startDate;

    @Column(name = "finish_date")
    @Getter
    @Setter
    @NonNull
    private LocalDateTime finishDate;
    
    @Column
    @Getter
    @Setter
    @NonNull
    private String type;

    @Column
    @Getter
    @Setter
    private String comment;

    @Column
    @Getter
    @Setter
    @NonNull
    private String status;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    @NonNull
    private CalendarJpaEntity calendar;
    
    @OneToMany(mappedBy = "event")
    @Getter
    @Setter
    private List<DocumentJpaEntity> documents = new ArrayList<>();
    
    @OneToOne(mappedBy = "event")
    @Getter
    @Setter
    private VacationRequestJpaEntity vacationRequest;
}
