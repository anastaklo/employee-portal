package org.anastaklo.portal.adapter.persistence;

import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
public class BaseJpaEntity {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // we can't use @EqualsAndHashCode for our entities because 'id' is automatically generated 
    // by database, so this 'id' differs in different entity states (it is 'null' when entity is in transient state 
    // and later it will be set to some number after persisting, this number is a random integer, i.g. '13')
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
