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
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "event")
public class EventJpaEntity extends BaseJpaEntity {
    
    @Column(name = "start_date")
    @NonNull
    private LocalDateTime startDate;

    @Column(name = "finish_date")
    @NonNull
    private LocalDateTime finishDate;
    
    @Column
    @NotBlank
    @Max(50)
    private String type; //todo: change to enum type

    @Column
    @Max(255)
    private String comment;

    @Column
    @NotBlank
    @Max(50)
    private String status; //todo: change to enum type
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private CalendarJpaEntity calendar;
    
    @OneToMany(mappedBy = "event")
    private List<DocumentJpaEntity> documents = new ArrayList<>();
    
    @OneToOne(mappedBy = "event")
    private VacationRequestJpaEntity vacationRequest;
}
