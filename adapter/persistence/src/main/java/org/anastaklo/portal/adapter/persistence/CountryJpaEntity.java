package org.anastaklo.portal.adapter.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "country")
public class CountryJpaEntity extends BaseJpaEntity {

    @Column
    @NonNull
    @Getter
    @Setter
    private String name;

    @Column(name = "iso_code")
    @NonNull
    @Getter
    @Setter
    private String isoCode;
    
    @OneToMany(mappedBy = "country")
    @Getter
    @Setter
    @NonNull
    private List<CityJpaEntity> cities = new ArrayList<>();
}
