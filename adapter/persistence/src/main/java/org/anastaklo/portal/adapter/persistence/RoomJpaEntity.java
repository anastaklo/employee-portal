package org.anastaklo.portal.adapter.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "room")
public class RoomJpaEntity extends BaseJpaEntity {
    
    @Column
    @DecimalMin("0")
    @DecimalMax("200")
    private int floor;
    
    @Column
    @NotBlank
    @Max(15)
    private String number;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private OfficeJpaEntity office;
    
    @OneToMany(mappedBy = "room")
    private List<EmployeeJpaEntity> employees = new ArrayList<>();
}
