package ru.ryabtsev.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ryabtsev.spring.entities.Role;
import ru.ryabtsev.spring.repositories.RoleRepository;

import java.util.List;

/**
 * Implements service which manages user roles.
 */
@Service
public class RolesService {

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(final RoleRepository roleRepository) { this.roleRepository = roleRepository; }

    /**
     * Returns all user roles registered in system.
     * @return all user roles registered in system
     */
    public List<Role> getAllRolesList() {
        return (List<Role>)roleRepository.findAll();
    }

    /**
     * Returns user role with given name if it exists.
     * @return user role with given name if it exists.
     */
    public Role findRoleByName(final String name) {
        return roleRepository.findOneByName(name);
    }

    /**
     * Returns user role with given identifier if it exists.
     * @return user role with given identifier if it exists.
     */
    public Role findRoleById(final Long id) {
        return findRoleById(id);
    }
}
