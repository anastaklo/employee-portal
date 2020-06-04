package org.anastaklo.portal.adapter.persistence;

import org.anastaklo.portal.adapter.persistence.entity.RoleJpaEntity;
import org.anastaklo.portal.adapter.persistence.repository.RoleRepository;
import org.anastaklo.portal.entities.Role;
import org.anastaklo.portal.port.out.GetRolePort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleAdapter implements GetRolePort {

    private final ModelMapper mapper;
    private final RoleRepository roleRepository;

    public RoleAdapter(ModelMapper mapper, RoleRepository roleRepository) {

        this.mapper = mapper;
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRole(long id) {
        RoleJpaEntity jpa = roleRepository.findById(id).orElseThrow();
        return mapper.map(jpa, Role.class);
    }
}
