package org.anastaklo.portal.port.in;

import org.anastaklo.portal.entities.Role;

public interface GetRoleQuery {

    Role getRole(long roleId);
}
