package org.anastaklo.portal.adapter.persistence;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeJpaEntity, Long> {
}
