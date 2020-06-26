package org.anastaklo.portal.application.service;

import org.anastaklo.portal.entities.Role;
import org.anastaklo.portal.port.in.GetRolesQuery;
import org.anastaklo.portal.port.out.GetRolesPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class GetRolesService implements GetRolesQuery {

    private final GetRolesPort rolePort;

    public GetRolesService(GetRolesPort rolePort) {

        this.rolePort = rolePort;
    }

    @Override
    public List<Role> getRoles() {
        return rolePort.getRoles();
    }
}
