package org.anastaklo.portal.adapter.persistence.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "office")
public class OfficeJpaEntity extends BaseJpaEntity{
    
    @Column
    @Max(50)
    private String name;

    @Column
    @Max(500)
    private String address;

    @Column
    @NotBlank
    @Max(10)
    private String zip;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private CityJpaEntity city;
    
    @OneToMany(mappedBy = "office")
    @NotEmpty
    private List<RoomJpaEntity> rooms = new ArrayList<>();
}
