package org.anastaklo.portal.adapter.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "document")
public class DocumentJpaEntity extends BaseJpaEntity{
    
    @Column
    @NotBlank
    @Max(100)
    private String label;

    @Column
    @NotBlank
    @Max(400)
    private String path;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private EventJpaEntity event;
}
