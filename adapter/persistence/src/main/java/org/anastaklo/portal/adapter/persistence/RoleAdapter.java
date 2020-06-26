package org.anastaklo.portal.adapter.persistence;

import org.anastaklo.portal.adapter.persistence.entity.RoleJpaEntity;
import org.anastaklo.portal.adapter.persistence.repository.RoleRepository;
import org.anastaklo.portal.entities.Role;
import org.anastaklo.portal.port.out.GetRolesPort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleAdapter implements GetRolesPort {

    private final ModelMapper mapper;
    private final RoleRepository roleRepository;

    public RoleAdapter(ModelMapper mapper, RoleRepository roleRepository) {

        this.mapper = mapper;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getRoles() {
        List<RoleJpaEntity> jpaEntityList = roleRepository.findAll();
        return jpaEntityList.stream()
                .map(e -> mapper.map(e, Role.class))
                .collect(Collectors.toList());
    }
}
