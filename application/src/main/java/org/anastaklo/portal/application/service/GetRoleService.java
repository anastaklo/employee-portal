package org.anastaklo.portal.application.service;

import org.anastaklo.portal.entities.Role;
import org.anastaklo.portal.port.in.GetRoleQuery;
import org.anastaklo.portal.port.out.GetRolePort;
import org.springframework.stereotype.Service;

@Service
class GetRoleService implements GetRoleQuery {

    private final GetRolePort rolePort;

    public GetRoleService(GetRolePort rolePort) {

        this.rolePort = rolePort;
    }

    @Override
    public Role getRole(long roleId) {
        return rolePort.getRole(roleId);
    }
}
