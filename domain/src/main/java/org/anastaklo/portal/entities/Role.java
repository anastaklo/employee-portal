package org.anastaklo.portal.entities;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Role {
    private Long id;
    private String name;
    private Set<Permission> permissions = new HashSet<>();
}
