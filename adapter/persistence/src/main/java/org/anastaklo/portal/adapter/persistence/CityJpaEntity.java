package org.anastaklo.portal.adapter.persistence;

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
@Table(name = "city")
public class CityJpaEntity extends BaseJpaEntity{

    @Column
    @NotBlank
    @Max(100)
    private String name;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private CountryJpaEntity country;
    
    @OneToMany(mappedBy = "city")
    @NotEmpty
    private List<OfficeJpaEntity> offices = new ArrayList<>();
}
