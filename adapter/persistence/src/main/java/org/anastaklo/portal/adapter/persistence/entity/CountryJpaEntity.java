package org.anastaklo.portal.adapter.persistence.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "country")
public class CountryJpaEntity extends BaseJpaEntity {

    @Column
    @NotBlank
    @Max(100)
    private String name;

    @Column(name = "iso_code")
    @NotBlank
    @Max(20)
    private String isoCode;
    
    @OneToMany(mappedBy = "country")
    @NotEmpty
    private List<CityJpaEntity> cities = new ArrayList<>();
}
