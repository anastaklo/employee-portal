package org.anastaklo.portal.adapter.web;

import org.anastaklo.portal.entities.Role;
import org.anastaklo.portal.port.in.GetRoleQuery;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/role")
public class GetRoleController {

    private final GetRoleQuery getQuery;

    public GetRoleController(GetRoleQuery getQuery) {

        this.getQuery = getQuery;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Role getRole(@PathVariable long id) {

        return getQuery.getRole(id);
    }
}
