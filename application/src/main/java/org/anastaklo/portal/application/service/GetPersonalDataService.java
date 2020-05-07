package org.anastaklo.portal.application.service;

import org.anastaklo.portal.entities.Employee;
import org.anastaklo.portal.port.in.GetPersonalDataQuery;
import org.anastaklo.portal.port.out.GetPersonalDataPort;
import org.springframework.stereotype.Service;

@Service
class GetPersonalDataService implements GetPersonalDataQuery {
    
    private final GetPersonalDataPort personalDataPort;

    public GetPersonalDataService(GetPersonalDataPort personalDataPort) {

        this.personalDataPort = personalDataPort;
    }

    @Override
    public Employee getPersonalData(long employeeId) {

        return personalDataPort.getPersonalData(employeeId);
    }
}
