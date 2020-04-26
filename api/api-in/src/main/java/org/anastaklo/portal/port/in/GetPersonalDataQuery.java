package org.anastaklo.portal.port.in;

import org.anastaklo.portal.entities.Employee;

public interface GetPersonalDataQuery {

    Employee getPersonalData(long employeeId);
}
