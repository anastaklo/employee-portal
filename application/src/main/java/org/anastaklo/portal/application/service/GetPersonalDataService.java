package org.anastaklo.portal.application.service;

import org.anastaklo.portal.entities.Employee;
import org.anastaklo.portal.port.in.GetPersonalDataQuery;
import org.anastaklo.portal.port.out.GetPersonalDataPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class GetPersonalDataService implements GetPersonalDataQuery {
    
    @Autowired
    private GetPersonalDataPort personalDataPort;
    
    @Override
    public Employee getPersonalData(long employeeId) {

        return personalDataPort.getPersonalData(employeeId);
    }
}
