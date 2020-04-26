package org.anastaklo.portal.adapter.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "room")
public class RoomJpaEntity extends BaseJpaEntity {
    
    @Column
    @Getter
    @Setter
    private String floor;
    
    @Column
    @Getter
    @Setter
    private String number;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    @NonNull
    private OfficeJpaEntity office;
    
    @OneToMany(mappedBy = "room")
    @Getter
    @Setter
    private List<EmployeeJpaEntity> employees = new ArrayList<>();
}
