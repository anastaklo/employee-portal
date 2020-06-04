package org.anastaklo.portal.adapter.persistence.repository;

import org.anastaklo.portal.adapter.persistence.entity.RoleJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<RoleJpaEntity, Long> {
}
