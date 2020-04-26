package org.anastaklo.portal.adapter.persistence;

import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public int hashCode() {

        return 13;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof BaseJpaEntity)) {
            return false;
        }
        BaseJpaEntity other = (BaseJpaEntity) o;
        return Objects.equals(id, other.id);
    }
}
