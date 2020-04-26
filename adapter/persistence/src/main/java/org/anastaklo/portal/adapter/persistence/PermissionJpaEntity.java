package org.anastaklo.portal.adapter.persistence;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "permission")
public class PermissionJpaEntity extends BaseJpaEntity {
    
    @Column
    @Getter
    @Setter
    @NonNull
    private String action;
    
    @ManyToMany(mappedBy = "permissions")
    @Getter
    @Setter
    @NonNull
    private Set<RoleJpaEntity> roles = new HashSet<>();
}
