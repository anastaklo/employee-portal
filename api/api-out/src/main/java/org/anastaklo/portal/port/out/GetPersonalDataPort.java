package org.anastaklo.portal.port.out;

import org.anastaklo.portal.entities.Employee;

public interface GetPersonalDataPort {
    Employee getPersonalData(long id);
}
