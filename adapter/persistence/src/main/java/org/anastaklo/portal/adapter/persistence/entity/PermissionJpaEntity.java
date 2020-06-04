package org.anastaklo.portal.adapter.persistence.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "permission")
public class PermissionJpaEntity extends BaseJpaEntity {
    
    @Column
    @NotBlank
    @Max(50)
    private String action;
    
    @ManyToMany(mappedBy = "permissions")
    @NotEmpty
    private Set<RoleJpaEntity> roles = new HashSet<>();
}
