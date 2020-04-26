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
@Table(name = "office")
public class OfficeJpaEntity extends BaseJpaEntity{
    
    @Column
    @Getter
    @Setter
    private String name;

    @Column
    @Getter
    @Setter
    private String address;

    @Column
    @NonNull
    @Getter
    @Setter
    private String zip;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    @NonNull
    private CityJpaEntity city;
    
    @OneToMany(mappedBy = "office")
    @Getter
    @Setter
    @NonNull
    private List<RoomJpaEntity> rooms = new ArrayList<>();
}
