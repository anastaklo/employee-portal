package org.anastaklo.portal.port.out;

import org.anastaklo.portal.entities.Role;

import java.util.List;

public interface GetRolesPort {

    List<Role> getRoles();
}