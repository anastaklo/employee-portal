package org.anastaklo.portal.adapter.web;

import org.anastaklo.portal.entities.Employee;
import org.anastaklo.portal.port.in.GetPersonalDataQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/employee")
public class GetPersonalDataController {
    
    @Autowired
    private GetPersonalDataQuery getQuery;
    
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeInfo(@PathVariable long id){
        
        return getQuery.getPersonalData(id);
    }
}
