package org.anastaklo.portal.application.service;

import org.anastaklo.portal.application.mapper.Mapper;
import org.anastaklo.portal.port.in.GetPersonalDataQuery;
import org.anastaklo.portal.port.in.PersonDTO;
import org.anastaklo.portal.port.out.GetPersonalDataPort;
import org.anastaklo.portal.port.out.PersonJpaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class GetPersonalDataService implements GetPersonalDataQuery {
    
    @Autowired
    private GetPersonalDataPort personalDataPort;
    
    @Autowired
    private Mapper mapper;
    
    @Override
    public PersonDTO getPersonalData(long personId) {

        PersonJpaEntity jpaEntity = personalDataPort.getPersonalData(personId);
        return mapper.convertJpaToDtoEntity(jpaEntity);
    }
}
