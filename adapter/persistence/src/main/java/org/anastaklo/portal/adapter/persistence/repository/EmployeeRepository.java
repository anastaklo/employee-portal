package org.anastaklo.portal.adapter.persistence.repository;

import org.anastaklo.portal.adapter.persistence.entity.EmployeeJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeJpaEntity, Long> {
}
