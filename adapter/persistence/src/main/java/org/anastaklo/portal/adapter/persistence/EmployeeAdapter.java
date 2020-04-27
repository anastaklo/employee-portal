package org.anastaklo.portal.adapter.persistence;

import org.anastaklo.portal.entities.Employee;
import org.anastaklo.portal.port.out.GetPersonalDataPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeAdapter implements GetPersonalDataPort {
    
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public Employee getPersonalData(long id) {

        EmployeeJpaEntity jpa = employeeRepository.findById(id).orElseThrow();
        return mapper.map(jpa, Employee.class);
    }
}
