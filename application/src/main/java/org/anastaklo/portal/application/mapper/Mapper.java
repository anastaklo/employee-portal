package org.anastaklo.portal.application.mapper;

import org.anastaklo.portal.port.in.PersonDTO;
import org.anastaklo.portal.port.out.PersonJpaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    @Autowired
    ModelMapper mapper;

    public PersonDTO convertJpaToDtoEntity(PersonJpaEntity jpaEntity) {

        return mapper.map(jpaEntity, PersonDTO.class);
    }
}
