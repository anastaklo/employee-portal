package org.anastaklo.portal.port.out;

import org.anastaklo.portal.entities.Role;

public interface GetRolePort {

    Role getRole(long id);
}