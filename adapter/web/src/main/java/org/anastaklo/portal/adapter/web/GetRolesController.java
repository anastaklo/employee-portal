package org.anastaklo.portal.adapter.web;

import org.anastaklo.portal.entities.Role;
import org.anastaklo.portal.port.in.GetRolesQuery;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/role")
public class GetRolesController {

    private final GetRolesQuery getQuery;

    public GetRolesController(GetRolesQuery getQuery) {

        this.getQuery = getQuery;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Role> getRoles() {

        return getQuery.getRoles();
    }
}
