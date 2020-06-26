package org.anastaklo.portal.adapter.persistence.repository;

import org.anastaklo.portal.adapter.persistence.entity.RoleJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleJpaEntity, Long> {
}
