package org.anastaklo.portal.adapter.persistence;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "role")
public class RoleJpaEntity extends BaseJpaEntity {
    
    @Column
    @Getter
    @Setter
    @NonNull
    private String name;
    
    @ManyToMany
    @JoinTable(name = "Role_Permission_Map",
    joinColumns = { @JoinColumn(name = "role_id")},
    inverseJoinColumns = { @JoinColumn(name = "permission_id")})
    @Getter
    @Setter
    @NonNull
    private Set<PermissionJpaEntity> permissions = new HashSet<>();
    
    @ManyToMany(mappedBy = "roles")
    @Getter
    @Setter
    @NonNull
    private Set<EmployeeJpaEntity> employees = new HashSet<>();
}
