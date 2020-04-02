package org.anastaklo.portal.adapter.persistence;

import org.anastaklo.portal.port.out.GetPersonalDataPort;
import org.anastaklo.portal.port.out.PersonJpaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonAdapter implements GetPersonalDataPort {
    
    @Autowired
    private PersonRepository personRepository;
    
    @Override
    public PersonJpaEntity getPersonalData(long id) {

        return personRepository.findById(id).orElseThrow();
    }
}
