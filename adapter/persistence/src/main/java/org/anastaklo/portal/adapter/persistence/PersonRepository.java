package org.anastaklo.portal.adapter.persistence;

import org.anastaklo.portal.port.out.PersonJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<PersonJpaEntity, Long> {
}
