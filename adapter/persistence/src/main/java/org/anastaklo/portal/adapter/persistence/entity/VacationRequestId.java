package org.anastaklo.portal.adapter.persistence.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class VacationRequestId implements Serializable {
    
    @Column(name = "parent_event_id")
    private Long eventId;
    
    @Column(name = "parent_manager_id")
    private Long managerId;
}
