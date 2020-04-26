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
@Table(name = "city")
public class CityJpaEntity extends BaseJpaEntity{

    @Column
    @NonNull
    @Getter
    @Setter
    private String name;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    @NonNull
    private CountryJpaEntity country;
    
    @OneToMany(mappedBy = "city")
    @Getter
    @Setter
    private List<OfficeJpaEntity> offices = new ArrayList<>();
}
