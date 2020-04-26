package org.anastaklo.portal.adapter.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "document")
public class DocumentJpaEntity extends BaseJpaEntity{
    
    @Column
    @Getter
    @Setter
    @NonNull
    private String label;

    @Column
    @Getter
    @Setter
    @NonNull
    private String path;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    @Getter
    @Setter
    private EventJpaEntity event;
}
