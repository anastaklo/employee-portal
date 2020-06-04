package org.anastaklo.portal.adapter.persistence.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "role")
public class RoleJpaEntity extends BaseJpaEntity {
    
    @Column
    @NotBlank
    @Max(100)
    private String name;
    
    @ManyToMany
    @JoinTable(name = "Role_Permission_Map",
    joinColumns = { @JoinColumn(name = "role_id")},
    inverseJoinColumns = { @JoinColumn(name = "permission_id")})
    @NotEmpty
    private Set<PermissionJpaEntity> permissions = new HashSet<>();
    
    @ManyToMany(mappedBy = "roles")
    @NotEmpty
    private Set<EmployeeJpaEntity> employees = new HashSet<>();
}
